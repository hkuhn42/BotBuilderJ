package org.sylvani.bot.util;

import java.util.Date;
import java.util.Locale;

public interface ILocalizer {
    
    /**
     * Get the string resource for the given locale
     * 
     * @param locale
     * @param key
     * @param params
     * @return
     */
    public abstract String getLocaleString(Locale locale, String key, Object... params);
    
    public abstract String formatDate(Locale locale, Date date);
    
    public abstract String formatTime(Locale locale, Date date);
    
    public abstract String formatDateTime(Locale locale, Date date);
    
}
