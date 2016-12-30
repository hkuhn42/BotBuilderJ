package org.sylvani.bot.connector.console;

import java.util.Scanner;

import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.connector.ms.model.ChannelAccount;
import org.sylvani.bot.connector.ms.model.ConversationAccount;

/**
 * Connector for development which routes console input and output to and from
 * the bots
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
				Activity activity = new Activity();
				activity.setType("message");
				ConversationAccount account = new ConversationAccount();
				account.setId(String.valueOf(this.hashCode()));
				account.setName("console");
				activity.setConversation(account);
				activity.setText(text);

				ChannelAccount from = new ChannelAccount();
				from.setName("shell");
				from.setId("shell");
				activity.setFrom(from);

				ChannelAccount recipient = new ChannelAccount();
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
	public void send(final Activity data) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(data.getText());
			}

		});
		t.start();
	}

}
