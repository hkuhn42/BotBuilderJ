/**
 * 
 */
package org.sylvani.bot.universal;

import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.ISession;

/**
 * Remembers the conversation.
 * 
 * @author Harald Kuhn
 */
public class UniversalSession extends ContextBase implements ISession {

	private IBotContext	botContext;
	private boolean		typing;

	protected UniversalSession(IBotContext botContext) {
		this.botContext = botContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversationContext#sendAsync(java.lang.Object)
	 */
	@Override
	public void send(IActivity activity) {
		botContext.send(activity);
	}

	@Override
	public IBotContext getBotContext() {
		return botContext;
	}

	@Override
	public void setTyping(boolean typing) {
		this.typing = typing;
	}

	@Override
	public boolean isTyping() {
		return typing;
	}
}
