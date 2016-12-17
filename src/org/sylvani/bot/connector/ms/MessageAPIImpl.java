/**
 * 
 */
package org.sylvani.bot.connector.ms;

import javax.ws.rs.core.Response;

import org.sylvani.bot.IBot;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * @author hkuhn -Djavax.net.debug=ssl
 */
public class MessageAPIImpl implements MessageAPI {

	private IBot bot;
	private Api2BotTokenVerifier verifier;

	public MessageAPIImpl(IBot bot) {
		this.bot = bot;
		this.verifier = new Api2BotTokenVerifier();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sylvani.bot.MessageAPI#receive(org.sylvani.bot.connector.ms.model.
	 * Activity)
	 */
	@Override
	public Response receive(String bearer, Activity message) {
		System.out.println(bearer);
		verifier.verifyToken(bearer.replace("Bearer ", ""));
		bot.receive(message);
		return Response.ok().build();
	}

}
