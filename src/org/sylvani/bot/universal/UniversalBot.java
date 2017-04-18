package org.sylvani.bot.universal;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.ActivityType;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.ISession;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.recognize.IRecognizer;
import org.sylvani.bot.recognize.RegexpRecognizer;

/**
 * General purpose bot implementation
 * 
 * @author Harald Kuhn
 */
public class UniversalBot implements IBot {

	private Logger					  logger = LoggerFactory.getLogger(UniversalBot.class);

	private Map<IRecognizer, IDialog> dialogs;

	private IConnector				  connector;

	private IBotContext				  botContext;

	private Map<String, ISession>	  conversations;

	public UniversalBot(IConnector connector) {
		this.connector = connector;
		this.connector.listen(this);
		this.dialogs = new HashMap<>();
		this.botContext = new UniversalBotContext(this);
		this.conversations = new HashMap<>();
	}

	@Override
	public void receive(IActivity activity) {
		String convId = activity.getConversation().getId();
		ISession session = conversations.get(convId);

		if (session == null) {
			session = new UniversalSession(botContext);
			conversations.put(convId, session);
		}
		logger.debug("receive activity of  type " + activity.getType());
		// use a recognizer

		if (ActivityType.MESSAGE == activity.getType()) {
			session.setTyping(false);
			findDialog(session, activity);
		}
		// else if ("typing".equalsIgnoreCase(activity.getType())) {
		// session.setTyping(true);
		// }
	}

	private void findDialog(ISession session, IActivity activity) {
		for (IRecognizer recognizer : dialogs.keySet()) {
			if (recognizer.recognize(session, activity) > 0) {
				dialogs.get(recognizer).handle(session, activity);
			}
		}
	}

	public void add(String pattern, IDialog dialog) {
		this.add(new RegexpRecognizer(pattern), dialog);
	}

	public void add(IRecognizer recognizer, IDialog dialog) {
		dialogs.put(recognizer, dialog);
	}

	@Override
	public void send(IActivity activity) {
		logger.debug("send from " + activity.getFrom().getName() + " to " + activity.getRecipient().getName());
		connector.send(activity);
	}
}
