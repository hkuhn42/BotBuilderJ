package org.sylvani.bot;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

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
	public Serializable getAttribute(String name);

	/**
	 * Get all attributes as an iterator
	 * 
	 * @return an iterator of all attributes
	 */
	public Set<String> getAttributeNames();

	/**
	 * Set an attribute in the context
	 * 
	 * @param name
	 * @param value
	 */
	public void setAttribute(String name, Serializable value);

	/**
	 * remove the attribute
	 * 
	 * @param name
	 * @return
	 */
	public Serializable removeAttribut(String name);

	/**
	 * get attributes as immutable map
	 * 
	 * @return
	 */
	public Map<String, Serializable> asAttributeMap();

}
