package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Bot specific context
 * 
 * @author Harald Kuhn
 *
 */
public interface IBotContext extends IContext {

	public void sendAsync(Activity activity);

}
