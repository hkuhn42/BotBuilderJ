package org.sylvani.bot.connector.console;

import java.util.Scanner;

import org.sylvani.bot.ActivityType;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.IParticipant;
import org.sylvani.bot.connector.GenericActivity;
import org.sylvani.bot.connector.GenericConversation;
import org.sylvani.bot.connector.GenericParticipant;

/**
 * Connector for development which routes console input and output to and from the bots
 * 
 * @author Harald Kuhn
 *
 */
public class ConsoleConnector implements IConnector {

	@Override
	public void listen(final IBot handler) {

		Thread t = new Thread(new Runnable() {

			private Scanner scanner = new Scanner(System.in);

			@Override
			public void run() {
				listen(handler);
			}

			public void listen(final IBot handler) {
				String text = scanner.nextLine();

				IActivity activity = newMessageTo(new GenericParticipant("shell", "shell"));
				activity.setText(text);

				handler.receive(activity);
				listen(handler);
			}
		});
		t.start();

	}

	@Override
	public void send(final IActivity data) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(data.getText());
			}

		});
		t.start();
	}

	@Override
	public IActivity newMessageTo(IParticipant recipient) {
		IActivity activity = new GenericActivity();
		activity.setType(ActivityType.MESSAGE);
		GenericConversation conversation = new GenericConversation();
		conversation.setId(String.valueOf(this.hashCode()));
		conversation.setChannel("console");
		activity.setConversation(conversation);

		activity.setFrom(getConnectorAccount());

		activity.setRecipient(new GenericParticipant());
		activity.getRecipient().setId(recipient.getId());
		activity.getRecipient().setName(recipient.getName());
		return activity;
	}

	@Override
	public IActivity newReplyTo(IActivity toThisActivity) {
		return newMessageTo(toThisActivity.getRecipient());
	}

	@Override
	public IParticipant getConnectorAccount() {
		return new GenericParticipant("shell", "shell");
	}

}
