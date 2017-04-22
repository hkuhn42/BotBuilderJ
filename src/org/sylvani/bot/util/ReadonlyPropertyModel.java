/**
 * 
 */
package org.sylvani.bot.util;

/**
 * @author hkuhn
 */
public class ReadonlyPropertyModel<T> implements IReadonlyModel<T> {
    
    private Object sourceObject;
    private String propertyExpression;
    
    public ReadonlyPropertyModel(Object sourceObject, String propertyExpression) {
        this.sourceObject = sourceObject;
        this.propertyExpression = propertyExpression;
    }
    
    public Object getSourceObject() {
        return sourceObject;
    }
    
    public String getPropertyExpression() {
        return propertyExpression;
    }
    
    @Override
    public T getObject() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
