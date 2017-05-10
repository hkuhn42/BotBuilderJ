/**
 * 
 */
package org.sylvani.bot.universal;

import org.sylvani.bot.ContextBase;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.ISession;
import org.sylvani.bot.dialogs.IDialog;

/**
 * Remembers the conversation.
 * 
 * @author Harald Kuhn
 */
public class UniversalSession extends ContextBase implements ISession {

	private IBot	   bot;
	private boolean	   typing;
	private IDialog	   dialog;
	private IConnector connector;
	private String	   id;

	protected UniversalSession(String id, IBot bot, IConnector connector) {
		this.bot = bot;
		this.connector = connector;
		this.id = id;
	}

	@Override
	public void send(IActivity activity) {
		connector.send(activity);
	}

	@Override
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

	@Override
	public void setActiveDialog(IDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public IDialog getActiveDialog() {
		return dialog;
	}

	@Override
	public IConnector getConnector() {
		return connector;
	}

	@Override
	public void activeDialogFinished() {
		dialog = null;
	}

	@Override
	public void activeDialogFinished(IActivity activity) {
		activeDialogFinished();
		getBot().handle(this, activity);
	}

	@Override
	public void invalidate() {
		getBot().invalidate(this);
	}

	@Override
	public String getResolvedResource(String key) {
		String resource = getBot().getResources().getString(key);
		if (getBot().getBotConfig().getResolver() != null) {
			return getBot().getBotConfig().getResolver().resolveVariables(resource, this);
		}
		return resource;
	}

	@Override
	public String getId() {
		return id;
	}
}
