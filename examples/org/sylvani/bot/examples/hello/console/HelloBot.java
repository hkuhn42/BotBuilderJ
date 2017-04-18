/**
 * 
 */
package org.sylvani.bot.examples.hello.console;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.console.ConsoleConnector;
import org.sylvani.bot.dialogs.IDialog;
import org.sylvani.bot.universal.UniversalBot;
import org.sylvani.bot.util.Prompt;;

/**
 * @author Harald Kuhn
 *
 */
public class HelloBot extends UniversalBot {

	public HelloBot() {
		super(new ConsoleConnector());
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
