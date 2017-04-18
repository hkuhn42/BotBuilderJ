package org.sylvani.bot;

/**
 * Defines a generic bot
 * 
 * A bot is both listener and emitter of activities and acts like the controller of a conversation
 * 
 * The actual handling and creation of Activities is normally done by instances of IDialog
 * 
 * @author Harald Kuhn
 */
public interface IBot {

	/**
	 * Called for received activities
	 * 
	 * @param activity
	 */
	public void receive(IActivity activity);

	/**
	 * Send the activity
	 * 
	 * @param activity
	 */
	public void send(IActivity activity);

}
