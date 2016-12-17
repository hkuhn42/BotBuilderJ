/**
 * 
 */
package org.sylvani.bot.universal;

import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Remembers the conversation.
 * 
 * @author Harald
 */
public class UniversalSession extends ContextBase implements ISession {

	private IBotContext botContext;

	protected UniversalSession(IBotContext botContext) {
		this.botContext = botContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversationContext#sendAsync(java.lang.Object)
	 */
	@Override
	public void sendAsync(Activity activity) {
		botContext.sendAsync(activity);
	}

	@Override
	public IBotContext getBotContext() {
		return botContext;
	}

}
