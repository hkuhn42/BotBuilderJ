/**
 * 
 */
package org.sylvani.bot.util;

import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Utiltiy for creating activities to prompt text to the conversation
 * 
 * TODO: intergrate with bot and session
 * 
 * @author Harald Kuhn
 *
 */
public class Prompt {

	ISession sessiont;

	public Prompt(ISession session) {
		this.sessiont = session;
	}

	public static Activity answer(Activity inActivity) {
		Activity activity = new Activity();

		activity.setId(inActivity.getId() + "a");
		activity.setFrom(inActivity.getRecipient());
		activity.setRecipient(inActivity.getFrom());

		return activity;
	}

	public static Activity answer(String text, Activity inActivity) {
		Activity activity = answer(inActivity);
		activity.setText(text);
		return activity;
	}

	public static Activity choice(String text, String[] choices, Activity inActivity) {
		StringBuilder textBuilder = new StringBuilder(text);
		for (int i = 0; i < choices.length; i++) {
			textBuilder.append("\n" + (i + 1) + "." + choices[i]);
		}
		Activity activity = answer(textBuilder.toString(), inActivity);
		return activity;
	}

}
