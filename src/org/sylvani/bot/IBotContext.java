package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Bot global context (shared between all bots)
 * 
 * @author Harald Kuhn
 *
 */
public interface IBotContext extends IContext {

	/**
	 * Send the activity to the conversation
	 * 
	 * @param activity
	 */
	public void send(Activity activity);

}