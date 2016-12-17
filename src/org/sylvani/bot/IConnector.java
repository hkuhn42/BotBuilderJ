package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Defines a connector to a message api or message endpoint Curretly console and
 * ms apis are supported
 * 
 * @author Harald
 */
public interface IConnector {

	public void listen(IBot handler);

	public void send(Activity data);
}
