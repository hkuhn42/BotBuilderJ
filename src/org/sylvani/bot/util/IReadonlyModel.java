package org.sylvani.bot.util;

import java.io.Serializable;

/**
 * A basic readonly model This is conceptionally borrowed from wicket (but rather more primitive)
 * 
 * @author hkuhn
 * @param <T>
 */
public interface IReadonlyModel<T> extends Serializable {

	/**
	 * Gets the model object.
	 * 
	 * @return The model object
	 */
	T getObject();

}
