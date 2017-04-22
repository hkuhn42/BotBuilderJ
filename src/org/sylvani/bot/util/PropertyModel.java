/**
 * 
 */
package org.sylvani.bot.util;

/**
 * @author hkuhn
 */
public class PropertyModel<T> extends ReadonlyPropertyModel<T> implements IModel<T> {
    
    public PropertyModel(Object sourceObject, String propertyExpression) {
        super(sourceObject, propertyExpression);
    }
    
    @Override
    public void setObject(T object) {
    }
}
