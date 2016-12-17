package org.sylvani.bot.examples;

import org.sylvani.bot.connector.ms.MSConnector;
import org.sylvani.bot.dialogs.EchoDialog;
import org.sylvani.bot.dialogs.HelloDialog;
import org.sylvani.bot.universal.UniversalBot;

/**
 * A simple test bot
 * 
 * @author Harald Kuhn
 *
 */
public class TestBot extends UniversalBot {

	public TestBot() {
		super(new MSConnector());
	}

	public static void main(String[] args) {
		TestBot bot = new TestBot();
		bot.add(new EchoDialog());
		bot.add(new HelloDialog());
	}

}
