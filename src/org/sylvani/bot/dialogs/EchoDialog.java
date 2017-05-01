/**
 * 
 */
package org.sylvani.bot.dialogs;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.Model;

/**
 * @author hkuhn
 */
public class EchoDialog extends DialogBase {

	@Override
	public IModel<String> getText(IActivity request) {
		return new Model<>(request.getText());
	}

}
