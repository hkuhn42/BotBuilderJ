package org.sylvani.bot;

import java.util.Iterator;

/**
 * General purpose context
 * 
 * @author Harald Kuhn
 */
public interface IContext {

	/**
	 * fetch a context attribute
	 * 
	 * @param name
	 *            the name of the attribute
	 * @return the attribute or null
	 */
	public Object getAttribute(String name);

	/**
	 * Get all attributes as an iterator
	 * 
	 * @return an iterator of all attributes
	 */
	public Iterator<String> getAttributeNames();

	/**
	 * Set an attribute in the context
	 * 
	 * @param name
	 * @param value
	 */
	public void setAttribute(String name, Object value);

}
