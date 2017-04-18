/**
 * 
 */
package org.sylvani.bot.util;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.GenericActivity;

/**
 * Utiltiy for creating activities to prompt text to the conversation
 * 
 * TODO: intergrate with bot and session
 * 
 * @author Harald Kuhn
 *
 */
public class Prompt {

	ISession session;

	public Prompt(ISession session) {
		this.session = session;
	}

	public static IActivity answer(IActivity inIActivity) {
		IActivity activity = new GenericActivity();

		activity.setId(inIActivity.getId() + "a");
		activity.setFrom(inIActivity.getRecipient());
		activity.setRecipient(inIActivity.getFrom());

		return activity;
	}

	public static IActivity answer(String text, IActivity inIActivity) {
		IActivity activity = answer(inIActivity);
		activity.setText(text);
		return activity;
	}

	public static IActivity choice(String text, String[] choices, IActivity inIActivity) {
		StringBuilder textBuilder = new StringBuilder(text);
		for (int i = 0; i < choices.length; i++) {
			textBuilder.append("\n" + (i + 1) + "." + choices[i]);
		}
		IActivity activity = answer(textBuilder.toString(), inIActivity);
		return activity;
	}

}
