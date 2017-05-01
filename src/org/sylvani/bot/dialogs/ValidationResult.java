package org.sylvani.bot.dialogs;

import java.io.Serializable;

public class ValidationResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean			  valid;

	private String			  message;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
