package org.sylvani.bot;

/**
 * This crypt implementation does exactly nothing It should not be used except for diagnostic of crypto problems
 * 
 * @author Harald Kuhn
 *
 */
public class IKnowThisIsWrongCrypt implements ICrypt {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.util.ICrypt#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String encrypted) {
		return encrypted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.util.ICrypt#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String plain) {
		return plain;
	}

}
