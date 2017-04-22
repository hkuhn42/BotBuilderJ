/**
 * 
 */
package org.sylvani.bot.universal;

import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.ISession;

/**
 * Remembers the conversation.
 * 
 * @author Harald Kuhn
 */
public class UniversalSession extends ContextBase implements ISession {

	private IBot	bot;
	private boolean	typing;

	protected UniversalSession(IBot bot) {
		this.bot = bot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversationContext#sendAsync(java.lang.Object)
	 */
	@Override
	public void send(IActivity activity) {

	}

	public IBot getBot() {
		return bot;
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
