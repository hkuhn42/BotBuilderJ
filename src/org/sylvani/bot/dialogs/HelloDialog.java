/**
 * 
 */
package org.sylvani.bot.dialogs;

import org.sylvani.bot.ISession;
import org.sylvani.bot.IDialog;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * @author hkuhn
 */
public class HelloDialog implements IDialog {

	/*
	 * (non-Javadoc)
	 * 
	 * @see test.IHandler#receive(test.IConversationContext, java.lang.Object)
	 */
	@Override
	public void handle(ISession context, Activity activity) {
		activity.setText("Hello!");
		context.sendAsync(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see test.IDialog#getPattern()
	 */
	@Override
	public String getPattern() {
		return "hello";
	}

}
