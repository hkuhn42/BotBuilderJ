package org.sylvani.bot.universal;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.recognize.IRecognizer;
import org.sylvani.bot.recognize.RegexpRecognizer;

public class UniversalBot implements IBot {

	private Logger logger = LoggerFactory.getLogger(UniversalBot.class);

	private Map<IRecognizer, IDialog> dialogs;

	private IConnector connector;

	private IBotContext botContext;

	private Map<String, ISession> conversations;

	public UniversalBot(IConnector connector) {
		this.connector = connector;
		this.connector.listen(this);
		this.dialogs = new HashMap<>();
		this.botContext = new UniversalBotContext(this);
		this.conversations = new HashMap<>();
	}

	@Override
	public void receive(Activity activity) {
		String convId = activity.getConversation().getId();
		ISession context = conversations.get(convId);

		if (context == null) {
			context = new UniversalSession(botContext);
			conversations.put(convId, context);
		}
		logger.debug("receive activity of  type " + activity.getType());
		// use a recognizer

		if ("message".equalsIgnoreCase(activity.getType())) {
			findDialog(context, activity);
		}
	}

	private void findDialog(ISession session, Activity activity) {
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
	public void send(Activity activity) {
		logger.debug("send from " + activity.getFrom().getName() + " to " + activity.getRecipient().getName());
		connector.send(activity);
	}
}
