/**
 * 
 */
package org.sylvani.bot.dialogs;

import java.util.List;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.ISessionModel;
import org.sylvani.bot.util.Model;

/**
 * @author Harald Kuhn
 *
 */
public abstract class Decision<T> extends Question<T> {

	private List<Choice<T>> choices;

	public Decision(ISessionModel<T> anwerModel, List<Choice<T>> choices) {
		super(anwerModel);
		this.choices = choices;
	}

	@Override
	protected T findAnswer(String text) {
		if (text == null) {
			return null;
		}
		String answer = text.trim();
		for (int i = 0; i < choices.size(); i++) {
			if (answer.indexOf(String.valueOf(i + 1)) >= 0) {
				return choices.get(i).getValue();
			}
			String choiceString = choices.get(i).getLabel().getObject();
			if (answer.indexOf(choiceString) >= 0) {
				return choices.get(i).getValue();
			}
		}
		return null;
	}

	public IModel<String> getConfirmText(Choice<?> choice) {
		return new Model<>("OK, added ");
	}

	@Override
	protected void fillActivity(IActivity request, IActivity response) {
		super.fillActivity(request, response);
		StringBuilder builder = new StringBuilder();
		builder.append(response.getText());
		builder.append("\n");
		for (int i = 0; i < choices.size(); i++) {
			builder.append((i + 1) + ": ");
			builder.append(choices.get(i).getLabelString());
			builder.append("\n");
		}
		response.setText(builder.toString());
	}
}
