/**
 * 
 */
package org.sylvani.bot.dialogs;

import java.util.List;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.util.Data;
import org.sylvani.bot.util.ISessionModel;

/**
 * Selection of choices
 * 
 * @author Harald Kuhn
 *
 */
public abstract class Selection<T> extends Question<T> {

	private List<Choice<T>> choices;

	public Selection(ISessionModel<T> anwerModel, List<Choice<T>> choices) {
		super(anwerModel);
		this.choices = choices;
	}

	@Override
	protected T findAnswer(String text) {
		String answer = null;
		if (text.contains("add")) {
			try {
				answer = text.substring(0, text.indexOf("add"));
			}
			catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		for (Choice<T> choice : choices) {
			String choiceString = choice.getLabel().getObject();
			if (answer.indexOf(choiceString) >= 0) {
				return choice.getValue();
			}
		}
		return null;
	}

	@Override
	protected void fillActivity(IActivity request, IActivity response) {
		// FIXME: add 1. 2. 3. etc to list and also use for answer resolving
		super.fillActivity(response, response);
		response.setText(response.getText() + "\n" + Data.join(", ", choices));
	}
}
