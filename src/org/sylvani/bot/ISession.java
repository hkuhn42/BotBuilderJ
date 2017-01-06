package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Chat session
 * 
 * @author Harald Kuhn
 */
public interface ISession extends IContext {

	/**
	 * send the given activity
	 * 
	 * @param activity
	 */
	public void send(Activity activity);

	/**
	 * access the global bot context
	 * 
	 * @return
	 */
	public IBotContext getBotContext();

}
