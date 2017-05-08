package org.sylvani.bot;

/**
 * Utilities for crypto
 * 
 * @author Harald Kuhn
 *
 */
public interface ICrypt {

	public String decrypt(String encrypted);

	public String encrypt(String plain);

}
