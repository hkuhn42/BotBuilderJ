package org.sylvani.bot.connector.ms;

import java.sql.Timestamp;

import org.apache.log4j.BasicConfigurator;

public class TokenUtil {

	private static TokenUtil instance;

	private String token = null;

	private Timestamp tokenBestBefore = null;

	private static final String SCOPE = "https://api.botframework.com/.default";
	private static final String GRANT = "client_credentials";

	protected String ensureToken() {
		if (token != null && tokenBestBefore != null && tokenBestBefore.before(now())) {
			return token;
		}

		BasicConfigurator.configure();
		AuthenticationAPI client = BotClient.initRestProxy();
		String clientId = System.getProperty("MICROSOFT_APP_ID");
		String clientSecret = System.getProperty("MICROSOFT_APP_PASSWORD");
		AuthResponse response = client.requestToken(GRANT, clientId, clientSecret, SCOPE);
		if (response.getAccessToken() != null) {
			tokenBestBefore = new Timestamp(System.currentTimeMillis() + (response.getExpiresIn() * 1000));
			return response.getAccessToken();
		}
		return null;
	}

	public static TokenUtil getInstance() {
		if (instance == null) {
			instance = new TokenUtil();
		}
		return instance;
	}

	public static Timestamp now() {
		return new Timestamp(System.currentTimeMillis());
	}
}
