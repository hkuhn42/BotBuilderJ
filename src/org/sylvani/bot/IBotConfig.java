package org.sylvani.bot;

import java.util.List;

import org.sylvani.bot.recognize.IRecognizer;
import org.sylvani.bot.util.ICrypt;
import org.sylvani.bot.util.ILocalizer;

/**
 * Bot global context (shared between all bots)
 * 
 * @author Harald Kuhn
 *
 */
public interface IBotConfig {

	ILocalizer getLocalizer();

	IRecognizer getRecognizer();

	ICrypt getCrypt();

	void setLocalizer(ILocalizer localizer);

	void setRecognizer(IRecognizer recognizer);

	void setCrypt(ICrypt crypt);

	// add dev config

	// add secruity config

	/**
	 * Get the List of in interceptors, to add an interceptor, add it to the list
	 * 
	 * @return the List of in interceptors
	 */
	List<IInterceptor> getInInterceptors();

	/**
	 * Get the List of out interceptors, to add an interceptor, add it to the list
	 * 
	 * @return the List of out interceptors
	 */
	List<IInterceptor> getOutInterceptors();
}