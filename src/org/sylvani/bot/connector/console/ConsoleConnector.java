package org.sylvani.bot.connector.console;

import java.util.Scanner;

import org.sylvani.bot.ActivityType;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
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
				IActivity activity = new GenericActivity();
				activity.setType(ActivityType.MESSAGE);
				GenericConversation conversation = new GenericConversation();
				conversation.setId(String.valueOf(this.hashCode()));
				conversation.setChannel("console");
				activity.setConversation(conversation);
				activity.setText(text);

				GenericParticipant from = new GenericParticipant();
				from.setName("shell");
				from.setId("shell");
				activity.setFrom(from);

				GenericParticipant recipient = new GenericParticipant();
				from.setName("bot");
				from.setId("bot");
				activity.setRecipient(recipient);

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

}
