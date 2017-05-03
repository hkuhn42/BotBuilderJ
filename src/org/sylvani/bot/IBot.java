package org.sylvani.bot;

import io.rincl.Rincled;

/**
 * Defines a generic bot
 * 
 * A bot is both listener and emitter of activities and acts like the controller of a conversation it keeps track of the
 * conversations via sessions and delegates the activities to dialogs based on the IRecognizers results
 * 
 * The actual handling and creation of Activities is normally done by instances of IDialog
 * 
 * The acutal connection to a messaging service is handled by a {@link IConnector}. Multiple connectors can be
 * associated with one bot but a connector may not be shared between different bots
 * 
 * @author Harald Kuhn
 */
public interface IBot extends IContext, IHandler, Rincled {

	/**
	 * Called for received activities
	 * 
	 * @param activity
	 */
	public void receive(IActivity activity);

	/**
	 * Send the activity
	 * 
	 * @param activity
	 */
	public void send(IActivity activity);

	public void invalidate(ISession session);

	/**
	 * Get the bots config
	 * 
	 * @return
	 */
	public IBotConfig getBotConfig();
}
