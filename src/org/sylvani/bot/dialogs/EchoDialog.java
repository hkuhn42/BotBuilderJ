/**
 * 
 */
package org.sylvani.bot.dialogs;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

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
	public void handle(ISession context, IActivity activity) {
		activity.setText("Echo " + activity.getText());
		context.send(activity);
	}

}
