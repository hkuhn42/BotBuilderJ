/**
 * 
 */
package org.sylvani.bot.recognize;

import org.sylvani.bot.ISession;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Defines a recognizer for recognizing wether a dialog fits to the users intent
 * 
 * @author Harald Kuhn
 *
 */
public interface IRecognizer {

	/**
	 * TODO: change to use double from 0 to 1 as result
	 * 
	 * @param activity
	 * @return
	 */
	public double recognize(ISession session, Activity activity);

}
