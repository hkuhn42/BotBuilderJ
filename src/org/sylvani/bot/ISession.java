package org.sylvani.bot;

import org.sylvani.bot.dialogs.IDialog;

import io.rincl.Rincled;

/**
 * A bot session A session is generally created for one chat or thread (depending on the implementation) with one or
 * more other entities (usually other bots or people
 * 
 * @author Harald Kuhn
 */
public interface ISession extends IContext, Rincled {

	/**
	 * send the given activity to this session (This is a convenience method to send on the connector)
	 * 
	 * @param activity
	 */
	public void send(IActivity activity);

	/**
	 * access the global bot context
	 * 
	 * @return
	 */
	public IBot getBot();

	public IConnector getConnector();

	public void setActiveDialog(IDialog dialog);

	public IDialog getActiveDialog();

	/**
	 * finish the active dialog and wait for a new activity
	 */
	public void activeDialogFinished();

	/**
	 * finish the active dialog and delegate directly to the next
	 */
	public void activeDialogFinished(IActivity activity);

	/**
	 * invalidate this session. the session is removed from the bot and cleaned up
	 */
	public void invalidate();

	/**
	 * gets a string resource from the bot and resolves it using the default resolver shortcut for
	 * 
	 * <pre>
	 * String resource = session.getBot().getResources().getString(key);
	 * String resolvedResource = session.getBot().getBotConfig().getVariableResolver().resolve(resource, session);
	 * </pre>
	 * 
	 * if no resolver is configured, the resource is returned with substitution
	 * 
	 * @param key
	 * @return
	 */
	public String getResolvedResource(String key);

	public void setTyping(boolean b);

	public boolean isTyping();
}
