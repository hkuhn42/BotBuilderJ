/**
 * 
 */
package org.sylvani.bot.connector.ms;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * 
 * @author Harald Kuhn
 */
public interface AuthenticationAPI {

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	@Path("/")
	public AuthResponse requestToken(@FormParam("grant_type") String grantType, @FormParam("client_id") String clientId,
			@FormParam("client_secret") String clientSecret, @FormParam("scope") String scope);

}
