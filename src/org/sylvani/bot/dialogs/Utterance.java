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

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.Model;

/**
 * Basic dialog that just outputs a sentence and finishes waits for the user input
 * 
 * @author Harald Kuhn
 *
 */
public class Utterance extends DialogBase {

	private IModel<String> text;

	public Utterance(String text) {
		this(new Model<String>(text));
	}

	public Utterance(IModel<String> text) {
		this.text = text;
	}

	protected Utterance() {
	}

	@Override
	public void handle(ISession session, IActivity request) {
		super.handle(session, request);
		session.activeDialogFinished();
	}

	@Override
	public IModel<String> getText(IActivity request, ISession session) {
		return text;
	}

}
