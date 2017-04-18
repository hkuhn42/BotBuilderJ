package org.sylvani.bot;

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
	public void send(IActivity activity);

}