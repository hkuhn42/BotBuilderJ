/**
 * 
 */
package org.sylvani.bot.recognize;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

/**
 * Defines a recognizer for recognizing wether a dialog fits to the users intent
 * 
 * @author Harald Kuhn
 *
 */
public interface IRecognizer {

	/**
	 * 
	 * @param activity
	 * @return
	 */
	public double recognize(ISession session, IActivity activity);

}
