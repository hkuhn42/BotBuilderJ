/**
 * 
 */
package org.sylvani.bot.util.crypto;

import java.io.Serializable;

import org.sylvani.bot.util.ICrypt;

/**
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
