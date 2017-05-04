/**
 * 
 */
package org.sylvani.bot.recognize;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

/**
 * @author Harald Kuhn
 *
 */
public class CommandRecognizer implements IRecognizer {

	private String[] pattern;

	public CommandRecognizer(String... pattern) {
		this.pattern = pattern;
		if (pattern == null) {
			throw new NullPointerException("pattern may not be null");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.recognize.IRecognizer#recognize(org.sylvani.bot.ISession, org.sylvani.bot.IActivity)
	 */
	@Override
	public double recognize(ISession session, IActivity activity) {

		String text = activity.getText();
		for (String string : pattern) {
			if (text.contains(string)) {
				activity.setIntent(new CommandIntent(string));
				return 1;
			}
		}
		return 0;
	}

}
