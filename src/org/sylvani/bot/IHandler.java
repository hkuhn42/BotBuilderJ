package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Generic handler for activities. Defines a common api for interceptors and
 * dialogs
 * 
 * @author Harald Kuhn
 */
public interface IHandler {

	void handle(ISession session, Activity activity);

}
