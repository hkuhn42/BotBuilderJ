/**
 * 
 */
package org.sylvani.bot.util.crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;

/**
 * Utility
 * 
 * @author Harald Kuhn
 */
public class AESKeystoreHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		AESKeystoreHelper e = new AESKeystoreHelper();
		SecretKey key = e.newKey();
		e.save(key, args[0]);
	}

	public SecretKey newKey() throws Exception {
		javax.crypto.KeyGenerator keyFactory = javax.crypto.KeyGenerator.getInstance("AES");
		keyFactory.init(128);

		return keyFactory.generateKey();
	}

	public void save(SecretKey spec, String passwd) throws Exception {
		KeyStore ks = KeyStore.getInstance("JCEKS");
		ks.load(null);

		ks.setKeyEntry(AESHelper.ALIAS, spec, passwd.toCharArray(), null);
		File keystoreFile = new File(AESHelper.KEYSTORE);
		FileOutputStream fStream = new FileOutputStream(keystoreFile);
		ks.store(fStream, passwd.toCharArray());
		fStream.close();

		System.out.println("new keystore written to " + keystoreFile.getAbsolutePath());
	}

}
