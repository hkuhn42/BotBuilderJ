package org.sylvani.bot.connector.ms;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.sylvani.bot.connector.ms.model.Activity;

@Path("/api/messages")
/**
 * API for receiving messages from MS cloud
 * 
 * @author Harald Kuhn
 */
public interface MessageAPI {

	@POST
	@Consumes("application/json")
	public Response receive(@HeaderParam("Authorization") String bearer, Activity message);

}
