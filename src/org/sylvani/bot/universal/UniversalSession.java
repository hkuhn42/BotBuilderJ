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
 * @author Harald Kuhn
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
	public void send(Activity activity) {
		botContext.send(activity);
	}

	@Override
	public IBotContext getBotContext() {
		return botContext;
	}

}
