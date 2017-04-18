package org.sylvani.bot;

/**
 * Generic handler for activities. Defines a common api for interceptors and dialogs
 * 
 * @author Harald Kuhn
 */
public interface IHandler {
	/**
	 * Handle the Activity
	 * 
	 * @param session
	 * @param activity
	 */
	void handle(ISession session, IActivity activity);

}
