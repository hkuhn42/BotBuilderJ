package org.sylvani.bot.connector.ms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.sylvani.bot.connector.ms.model.OpenIdConfig;

/**
 * Proxy api for microsofts openID service for the botFramework
 * 
 * @author Harald Kuhn
 *
 */
public interface OpenIdAPI {
	@Path("/.well-known/openidconfiguration")
	@Produces("application/json")
	@GET
	public OpenIdConfig getOpenIdConfiguration();

	@Path("/.well-known/openidconfiguration")
	@Produces("application/json")
	@GET
	public Message getOpenIdConfigurationRaw();

}
