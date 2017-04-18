package org.sylvani.bot;

/**
 * Defines a connector to a message api or message endpoint currently console and ms apis are supported
 * 
 * 
 * @author Harald
 */
public interface IConnector {

	/**
	 * Listen on the connector with the given bot if multiple bots are connected, all are called it a activity (message
	 * , status change etc) is received
	 * 
	 * @param handler
	 */
	public void listen(IBot handler);

	/**
	 * Send an activity to the api or endpoint
	 * 
	 * @param data
	 */
	public void send(IActivity data);
}
