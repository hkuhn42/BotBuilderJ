/**
 *    Copyright (C) 2016-2017 Harald Kuhn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
/**
 * 
 */
package org.sylvani.bot.util.crypto;

import java.io.Serializable;

import org.sylvani.bot.ICrypt;

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
