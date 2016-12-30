package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * chat session
 * 
 * @author Harald Kuhn
 */
public interface ISession extends IContext {
	/**
	 * send the given activity
	 * 
	 * @param activity
	 */
	public void sendAsync(Activity activity);

	public IBotContext getBotContext();

}
