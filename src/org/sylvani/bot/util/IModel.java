/**
 * 
 */
package org.sylvani.bot.util;

/**
 * A model with get and seet
 * 
 * @author hkuhn
 */
public interface IModel<T> extends IReadonlyModel<T> {
    
    /**
     * Sets the model object.
     * 
     * @param object
     *            The model object
     */
    void setObject(final T object);
    
}
