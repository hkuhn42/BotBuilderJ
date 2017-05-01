/**
 * 
 */
package org.sylvani.bot.dialogs;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.Model;

/**
 * Basic dialog that just outputs a sentence
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

	@Override
	public void handle(ISession session, IActivity request) {
		super.handle(session, request);
		session.activeDialogFinished();
	}

	@Override
	public IModel<String> getText(IActivity request) {
		return text;
	}

}
