package org.sylvani.bot.examples.hello.ms;

import org.apache.log4j.BasicConfigurator;
import org.sylvani.bot.connector.ms.MSConnector;
import org.sylvani.bot.examples.hello.HelloBot;;

/**
 * This example uses the msConnector for a hello world
 */
public class HelloMSConnector {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		new HelloBot(new MSConnector());
	}
}
