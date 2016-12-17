package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

public interface ISession extends IContext {

	public void sendAsync(Activity activity);

	public IBotContext getBotContext();
}
