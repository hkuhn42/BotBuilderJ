package org.sylvani.bot.universal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.sylvani.bot.IBot;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.IDialog;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.connector.ms.model.ChannelAccount;

public class UniversalBot implements IBot {

	private Deque<IDialog> stack;

	private IConnector connector;

	private IBotContext botContext;

	private Map<String, ISession> conversations;

	public UniversalBot(IConnector connector) {
		this.connector = connector;
		this.connector.listen(this);
		stack = new ArrayDeque<IDialog>();
		botContext = new UniversalBotContext(this);
		conversations = new HashMap<>();
	}

	@Override
	public void receive(Activity activity) {
		String convId = activity.getConversation().getId();
		ISession context = conversations.get(convId);

		if (context == null) {
			context = new UniversalSession(botContext);
			conversations.put(convId, context);
		}
		System.out.println(activity.getType());
		// use a recognizer

		if ("message".equalsIgnoreCase(activity.getType())) {

			if (activity.getText() != null && activity.getText().matches(stack.peek().getPattern())) {
				stack.peek().handle(context, activity);
			} else {
				stack.getLast().handle(context, activity);
			}
		}
	}

	public void add(IDialog dialog) {
		stack.push(dialog);
	}

	@Override
	public void send(Activity activity) {
		activity.setId(activity.getId() + "a");
		ChannelAccount from = activity.getFrom();
		System.out.println(activity.getFrom().getName() + " " + activity.getRecipient().getName());
		activity.setFrom(activity.getRecipient());
		activity.setRecipient(from);
		System.out.println(activity.getFrom().getName() + " " + activity.getRecipient().getName());
		connector.send(activity);
	}
}
