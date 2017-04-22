package org.sylvani.bot.util;

/**
 * A basic readonly model
 * This is conceptionally borrowed from wicket (but rather more primitive)
 * 
 * @author hkuhn
 * @param <T>
 */
public interface IReadonlyModel<T> {
    
    /**
     * Gets the model object.
     * 
     * @return The model object
     */
    T getObject();
    
}
