/**
 * 
 */
package org.sylvani.bot.connector.ms;

import javax.ws.rs.core.Response;

import org.sylvani.bot.IBot;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Implementation of MessageAPI
 * 
 * @author Harald Kuhn
 */
public class MessageAPIImpl implements MessageAPI {

	private IBot				 bot;
	private Api2BotTokenVerifier verifier;

	public MessageAPIImpl(IBot bot) {
		this.bot = bot;
		this.verifier = new Api2BotTokenVerifier();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.MessageAPI#receive(org.sylvani.bot.connector.ms.model. Activity)
	 */
	@Override
	public Response receive(String bearer, Activity message) {
		verifier.verifyToken(bearer.replace("Bearer ", ""));
		bot.receive(new MSActivity(message));
		return Response.ok().build();
	}

}
