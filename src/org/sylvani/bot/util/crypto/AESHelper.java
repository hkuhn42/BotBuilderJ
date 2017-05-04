/*
 * TurnFriendly-Project $Header: /cvs/turnfriendly/src/com/turnfriendly/util/encrypt/CredentialHelper.java,v 1.10
 * 2016-05-02 11:23:49 hkuhn Exp $ $Revision: 1.10 $ $Date: 2016-05-02 11:23:49 $
 * ==================================================================== Copyright (c) 2002-2012 Fiprox AG. All rights
 * reserved.
 */
package org.sylvani.bot.util.crypto;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility for AES encrypt and decrypt
 * 
 * keeps a transient copy of the key from the keystore for performance
 * 
 * @author hkuhn
 */
public class AESHelper {

	static final String					   ENCODING	= "ISO-8859-1";

	static final String					   KEYSTORE	= "Bot.jks";

	static final String					   ALIAS	= "BotKey";

	private static transient SecretKeySpec key;

	static String decrypt(String value) throws Exception {
		byte[] input = Base64.getDecoder().decode(value);
		byte[] result = doChiper(ALIAS, KEYSTORE, input, Cipher.DECRYPT_MODE);
		return new String(result, ENCODING);
	}

	static String encrypt(String value) throws Exception {
		byte[] input = value.getBytes(ENCODING);
		byte[] result = doChiper(ALIAS, KEYSTORE, input, Cipher.ENCRYPT_MODE);
		return Base64.getEncoder().encodeToString(result);
	}

	static byte[] doChiper(String alias, String keystore, byte[] value, int mode) throws Exception {

		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec spec = loadKey(alias, keystore);
		cipher.init(mode, spec);

		return cipher.doFinal(value);
	}

	static SecretKeySpec loadKey(String alias, String keystore) throws Exception {
		if (key != null) {
			return key;
		}
		InputStream is = null;
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(keystore);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		String password = System.getProperty("KEYSTORE_PASSWORD");
		if (password == null || password.length() < 1) {
			throw new NullPointerException("password for keystore:" + keystore + " was not found");
		}
		KeyStore ks = KeyStore.getInstance("JCEKS");
		ks.load(is, password.toCharArray());

		is.close();

		key = (SecretKeySpec) ks.getKey(alias, password.toCharArray());
		return key;
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("KEYSTORE_PASSWORD", "aklsfdlj");
		String encrypted = AESHelper.encrypt("hello world");
		System.out.println(encrypted);
		String reborn = AESHelper.decrypt(encrypted);
		System.out.println(reborn);
	}
}
