package org.sylvani.bot.universal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.ActivityType;
import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IBotConfig;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.IHandler;
import org.sylvani.bot.IInterceptor;
import org.sylvani.bot.ISession;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.recognize.IRecognizer;

import io.rincl.Rincled;

/**
 * General purpose bot implementation
 * 
 * @author Harald Kuhn
 */
public class UniversalBot extends ContextBase implements IBot, Rincled {

	private Logger					  logger = LoggerFactory.getLogger(UniversalBot.class);

	private IDialog					  welcomeDialog;

	private Map<IRecognizer, IDialog> globalCommands;

	private Map<IRecognizer, IDialog> dialogs;

	private IConnector				  connector;

	private IBotConfig				  botConfig;

	private Stack<IHandler>			  inInterceptorChain;
	private Stack<IHandler>			  outInterceptorChain;

	public UniversalBot(IConnector connector) {
		this.connector = connector;
		this.dialogs = new HashMap<>();
		this.globalCommands = new HashMap<>();
		try {
			this.botConfig = new UniversalBotConfig();
		}
		catch (IOException e) {
			throw new RuntimeException("config failed", e);
		}
		this.connector.listen(this);

		inInterceptorChain = new Stack<>();
		inInterceptorChain.push(this); // the bot is the final in handler
		if (botConfig.getArchive() != null) {
			inInterceptorChain.push(botConfig.getArchive());
		}
		if (!botConfig.getInInterceptors().isEmpty()) {
			for (IInterceptor interceptor : botConfig.getInInterceptors()) {
				interceptor.chain(inInterceptorChain.peek());
				inInterceptorChain.push(interceptor);
			}
		}

		outInterceptorChain = new Stack<>();
		outInterceptorChain.push(this); // the bot is the final out handler, too
		if (botConfig.getArchive() != null) {
			outInterceptorChain.push(botConfig.getArchive());
		}

		if (!botConfig.getOutInterceptors().isEmpty()) {
			for (IInterceptor interceptor : botConfig.getOutInterceptors()) {
				interceptor.chain(outInterceptorChain.peek());
				outInterceptorChain.push(interceptor);
			}
		}
	}

	@Override
	public void receive(IActivity activity) {
		String convId = activity.getConversation().getId();
		ISession session = botConfig.getSessionStore().find(convId);
		logger.debug("receive activity of  type " + activity.getType() + " " + activity.getText());
		if (session == null) {
			logger.debug("new session");
			session = new UniversalSession(convId, this, connector);
			botConfig.getSessionStore().add(convId, session);
		}
		handle(session, activity);
	}

	@Override
	public void handle(ISession session, IActivity activity) {
		if (ActivityType.MESSAGE == activity.getType()) {
			IDialog dialog = findDialog(session, activity);
			((UniversalSession) session).setActiveDialog(dialog);
			dialog.handle(session, activity);
		}
	}

	private IDialog findDialog(ISession session, IActivity activity) {
		for (IRecognizer recognizer : globalCommands.keySet()) {
			if (recognizer.recognize(session, activity) > 0) {
				IDialog dialog = globalCommands.get(recognizer);
				logger.debug("delegating message to global " + dialog.getClass().getName());
				return dialog;
			}
		}
		if (session.getActiveDialog() != null) {
			logger.debug("delegating message to active " + session.getActiveDialog().getClass().getName());
			return session.getActiveDialog();
		}

		for (IRecognizer recognizer : dialogs.keySet()) {
			if (recognizer.recognize(session, activity) > 0) {
				IDialog dialog = dialogs.get(recognizer);
				logger.debug("delegating message to " + dialog.getClass().getSimpleName());
				return dialog;
			}
		}
		logger.debug("coult not find match, delegating to welcome");
		return welcomeDialog;
	}

	public void addDialog(IRecognizer recognizer, IDialog dialog) {
		dialogs.put(recognizer, dialog);
	}

	public void addGlobalCommand(IRecognizer recognizer, IDialog dialog) {
		globalCommands.put(recognizer, dialog);
	}

	@Override
	public void send(IActivity activity) {
		logger.debug("send from " + activity.getFrom().getName() + " to " + activity.getRecipient().getName());
		connector.send(activity);
	}

	public void setWelcomeDialog(IDialog welcomeDialog) {
		this.welcomeDialog = welcomeDialog;
	}

	@Override
	public IBotConfig getBotConfig() {
		return botConfig;
	}

	@Override
	public void invalidate(ISession session) {
		botConfig.getSessionStore().remove(session);
	}

}
