/**
 * 
 */
package org.sylvani.bot.util;

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
