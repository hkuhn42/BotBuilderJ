/**
 * 
 */
package org.sylvani.bot.dialogs;

import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * @author hkuhn
 */
public class EchoDialog implements IDialog {

	/*
	 * (non-Javadoc)
	 * 
	 * @see test.IHandler#receive(test.IConversationContext, java.lang.Object)
	 */
	@Override
	public void handle(ISession context, Activity activity) {
		activity.setText("Echo " + activity.getText());
		context.sendAsync(activity);
	}

}