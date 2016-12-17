package org.sylvani.bot.connector.console;

import java.util.Scanner;

import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.connector.ms.model.ConversationAccount;
import org.sylvani.bot.examples.TestBot;

/**
 * Connector for development which routes console input and output to and from
 * the bots
 * 
 * @author Harald Kuhn
 *
 */
public class ConsoleConnector implements IConnector {

	public static void main(String[] args) {
		ConsoleConnector c = new ConsoleConnector();
		c.listen(new TestBot());
	}

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
				ConversationAccount account = new ConversationAccount();
				account.setId(String.valueOf(this.hashCode()));
				account.setName("console");
				activity.setConversation(account);
				activity.setText(text);
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
