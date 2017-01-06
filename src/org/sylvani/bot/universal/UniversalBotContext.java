/**
 * 
 */
package org.sylvani.bot.universal;

import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IBotContext;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * @author Harald Kuhn
 *
 */
public class UniversalBotContext extends ContextBase implements IBotContext {

	private IBot bot;

	public UniversalBotContext(IBot bot) {
		this.bot = bot;
	}

	@Override
	public void send(Activity activity) {
		bot.send(activity);
	}
}