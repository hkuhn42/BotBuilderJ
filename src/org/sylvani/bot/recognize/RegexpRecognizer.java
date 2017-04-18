/**
 * 
 */
package org.sylvani.bot.recognize;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

/**
 * Basic recongizer using java regexp
 * 
 * @author Harald Kuhn
 *
 */
public class RegexpRecognizer implements IRecognizer {

	private String pattern;

	public RegexpRecognizer(String pattern) {
		this.pattern = pattern;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IRecognizer#match(org.sylvani.bot.connector.ms.model. Activity)
	 */
	@Override
	public double recognize(ISession session, IActivity activity) {
		if (activity.getText() != null && activity.getText().matches(getPattern())) {
			return 1.0;
		}
		return 0.0;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
