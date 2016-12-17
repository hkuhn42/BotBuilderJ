
package org.sylvani.bot.connector.ms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.jose4j.jwk.HttpsJwks;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.resolvers.HttpsJwksVerificationKeyResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.connector.ms.model.OpenIdConfig;

/**
 * verifies the jose token sample config
 * "{\"issuer\":\"https://api.botframework.com\",\"authorization_endpoint\":\"https://invalid.botframework.com\",\"jwks_uri\":\"https://api.aps.skype.com/v1/keys\",\"id_token_signing_alg_values_supported\":[\"RSA256\"],\"token_endpoint_auth_methods_supported\":[\"private_key_jwt\"]}";
 * 
 * @author Harald Kuhn
 *
 */
public class Api2BotTokenVerifier {

	private static Logger logger = LoggerFactory.getLogger(Api2BotTokenVerifier.class);

	static final String DEFAULT_ISSUER = "https://api.botframework.com";
	static final String EMULATOR_ISSUER = "https://sts.windows.net/d6d49420-f39b-4df7-a1dc-d59a935871db/";

	static String OPEN_ID_METADATA_API_3_0 = "https://api.aps.skype.com/v1";
	static String OPEN_ID_METADATA_API_3_1 = "https://login.botframework.com/v1";

	static String OPEN_ID_METADATA_EMULATOR = "https://login.microsoftonline.com/common/v2.0";

	// ms recommends to cache the config for up to 5 days
	public static final long maxConfigAge = (5 * 24 * 60 * 60 * 1000);

	private OpenIdConfig config;
	private long configFetched;
	private String issuer = DEFAULT_ISSUER;

	public boolean verifyToken(String token) {
		// fetch config
		if (config == null || isConfigToOld()) {
			config = initOpenIdRestProxy(OPEN_ID_METADATA_API_3_0).getOpenIdConfiguration();

			configFetched = System.currentTimeMillis();
		}
		return verify(config, token);
	}

	protected boolean verify(OpenIdConfig config, String jwt) {

		HttpsJwks httpsJkws = new HttpsJwks(config.getJwksUri());
		HttpsJwksVerificationKeyResolver httpsJwksKeyResolver = new HttpsJwksVerificationKeyResolver(httpsJkws);

		JwtConsumer jwtConsumer = new JwtConsumerBuilder()

				.setVerificationKeyResolver(httpsJwksKeyResolver).setRequireExpirationTime()
				.setMaxFutureValidityInMinutes(20).setAllowedClockSkewInSeconds(5)
				// .setRequireSubject() // the JWT must have a subject claim
				.setExpectedIssuer(issuer).setExpectedAudience(System.getProperty("MICROSOFT_APP_ID")).build(); // create

		try {
			// Validate the JWT and process it to the Claims
			JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
			logger.debug("JWT validation succeeded! " + jwtClaims);
			return true;
		} catch (InvalidJwtException e) {
			logger.debug("Invalid JWT! " + e);
			return false;
		}
	}

	protected static OpenIdAPI initOpenIdRestProxy(String url) {
		List<Object> providers = new ArrayList<>();
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		providers.add(provider);
		OpenIdAPI inbox = JAXRSClientFactory.create(url, OpenIdAPI.class, providers);

		return inbox;
	}

	private boolean isConfigToOld() {
		long age = System.currentTimeMillis() - configFetched;
		if (age > maxConfigAge) {
			return true;
		}
		return false;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
}
