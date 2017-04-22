/**
 * 
 */
package org.sylvani.bot.util;

import java.util.Date;
import java.util.Locale;

/**
 * @author hkuhn
 */
public class ResourceBundleLocalizer implements ILocalizer {
    
    /* (non-Javadoc)
     * @see util.ILocalizer#getLocaleString(java.util.Locale, java.lang.String, java.lang.Object)
     */
    @Override
    public String getLocaleString(Locale locale, String key, Object... params) {
        return null;
    }
    
    /* (non-Javadoc)
     * @see util.ILocalizer#formatDate(java.util.Locale, java.util.Date)
     */
    @Override
    public String formatDate(Locale locale, Date date) {
        return null;
    }
    
    /* (non-Javadoc)
     * @see util.ILocalizer#formatTime(java.util.Locale, java.util.Date)
     */
    @Override
    public String formatTime(Locale locale, Date date) {
        return null;
    }
    
    /* (non-Javadoc)
     * @see util.ILocalizer#formatDateTime(java.util.Locale, java.util.Date)
     */
    @Override
    public String formatDateTime(Locale locale, Date date) {
        return null;
    }
    
    public static void main(String[] args) {
        ILocalizer l = new ResourceBundleLocalizer();
        l.getLocaleString(new Locale("DE"), "test");
    }
}
