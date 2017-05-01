/**
 * 
 */
package org.sylvani.bot.examples.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.connector.telegram.TelegramConnector;
import org.sylvani.bot.dialogs.EchoDialog;
import org.sylvani.bot.universal.UniversalBot;;

/**
 * @author Harald Kuhn
 *
 */
public class HelloBot extends UniversalBot {

	private static Logger logger = LoggerFactory.getLogger(HelloBot.class);

	public HelloBot(IConnector connector) {
		super(connector);

		setWelcomeDialog(new EchoDialog());
	}

	public static void main(String[] args) {
		new HelloBot(new TelegramConnector());
	}
}
