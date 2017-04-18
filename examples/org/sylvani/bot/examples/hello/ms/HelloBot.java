package org.sylvani.bot.examples.hello.ms;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.MSConnector;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.universal.UniversalBot;
import org.sylvani.bot.util.Prompt;;

/**
 * This example uses the msConnector for a hello world
 */
public class HelloBot extends UniversalBot {

	public HelloBot() {
		super(new MSConnector());
	}

	public static void main(String[] args) {
		HelloBot bot = new HelloBot();

		bot.add(".*", new IDialog() {

			@Override
			public void handle(ISession session, IActivity activity) {
				session.send(Prompt.answer("Hello World", activity));
			}
		});

	}
}
