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
package org.sylvani.bot.dialogs;

import java.util.List;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
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
	protected void fillActivity(IActivity request, IActivity response, ISession session) {
		super.fillActivity(request, response, session);
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
