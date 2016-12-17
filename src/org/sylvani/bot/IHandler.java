package org.sylvani.bot;

import org.sylvani.bot.connector.ms.model.Activity;

public interface IHandler {

	void handle(ISession context, Activity activity);

}
