package org.sylvani.bot.examples.hello.console;

import org.apache.log4j.BasicConfigurator;
import org.sylvani.bot.connector.console.ConsoleConnector;
import org.sylvani.bot.examples.hello.HelloBot;;

/**
 * This example uses the msConnector for a hello world
 */
public class HelloConsoleConnector {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		new HelloBot(new ConsoleConnector());
	}
}
