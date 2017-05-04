/**
 * 
 */
package org.sylvani.bot.recognize;

import java.io.Serializable;

import org.sylvani.bot.IIntent;

/**
 * @author Harald Kuhn
 *
 */
public class CommandIntent implements IIntent<String>, Serializable {

	private static final long serialVersionUID = 1L;

	private String			  intent;

	public CommandIntent(String intent) {
		this.intent = intent;
	}

	@Override
	public String getIntent() {
		return intent;
	}

}
