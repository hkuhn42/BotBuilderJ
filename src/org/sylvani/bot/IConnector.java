package org.sylvani.bot;

/**
 * Defines a connector to a message api or message endpoint
 * 
 * One connector can only be associated with one bot and should only handle one account (participate in a chat as one
 * entity)
 * 
 * @author Harald Kuhn
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

	/**
	 * the participant (account) for the account currently used by this connector
	 * 
	 * @return
	 */
	public IParticipant getConnectorAccount();

	/**
	 * prepare a message to the given Participant (e.g. User, Bot, Group)
	 * 
	 * @param recipientId
	 * @return
	 */
	public IActivity newMessageTo(IParticipant recipientId);

	/**
	 * prepare an answer to the given Activity (e.g. User, Bot, Group)
	 * 
	 * this is a shortcut to newMessageTo and setRecipient calls
	 * 
	 * @param toThisActivity
	 *            the IActivity to answer to
	 * @return the answer IActivity
	 */
	public IActivity newAnswerTo(IActivity toThisActivity);
}
