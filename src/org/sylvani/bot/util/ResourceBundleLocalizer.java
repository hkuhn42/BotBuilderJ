/**
 *    Copyright (C) 2016-2017 Harald Kuhn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see util.ILocalizer#getLocaleString(java.util.Locale, java.lang.String, java.lang.Object)
	 */
	@Override
	public String getLocaleString(Locale locale, String key, Object... params) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see util.ILocalizer#formatDate(java.util.Locale, java.util.Date)
	 */
	@Override
	public String formatDate(Locale locale, Date date) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see util.ILocalizer#formatTime(java.util.Locale, java.util.Date)
	 */
	@Override
	public String formatTime(Locale locale, Date date) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
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
