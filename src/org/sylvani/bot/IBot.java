package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Defines a generic bot
 * 
 * @author Harald Kuhn
 */
public interface IBot {

	/**
	 * Called for received activities
	 * 
	 * @param activity
	 */
	public void receive(Activity activity);

	/**
	 * Send the activity
	 * 
	 * @param activity
	 */
	public void send(Activity activity);

}
