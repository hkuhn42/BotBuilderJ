package org.sylvani.bot.connector.ms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Harald Kuhn
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthResponse {

	@XmlElement(name = "token_type")
	private String tokenType;

	@XmlElement(name = "expires_in")
	private int expiresIn;

	@XmlElement(name = "ext_expires_in")
	private String extExpiresIn;

	@XmlElement(name = "access_token")
	private String accessToken;

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expires_in) {
		this.expiresIn = expires_in;
	}

	public String getExtExpiresIn() {
		return extExpiresIn;
	}

	public void setExtExpiresIn(String extExpiresIn) {
		this.extExpiresIn = extExpiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
