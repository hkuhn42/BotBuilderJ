/**
 * 
 */
package org.sylvani.bot.util.crypto;

import java.io.Serializable;

import org.sylvani.bot.util.ICrypt;

/**
 * A {@link ICrypt} implementation using AES to encrypt and decrypt values
 * 
 * The key is expected inside a keystore called Bot.jks which is loaded from the classpath root The password for the
 * keystore and entry is expected to be the same and configured via the Java system property KEYSTORE_PASSWORD
 * 
 * There are two utilities {@link AESHelper} and {@link AESKeystoreHelper} which also helo with encrypting text and
 * createing new keystores
 * 
 * @author Harald Kuhn
 *
 */
public class AESCrypt implements ICrypt, Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.util.ICrypt#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String encrypted) {
		try {
			return AESHelper.decrypt(encrypted);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.util.ICrypt#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String plain) {
		try {
			return AESHelper.encrypt(plain);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
