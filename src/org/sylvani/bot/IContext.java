package org.sylvani.bot;

import java.util.Iterator;
import java.util.List;

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

	/**
	 * Get the List of in interceptors, to add an interceptor, add it to the list
	 * 
	 * @return the List of in interceptors
	 */
	public List<IInInterceptor> getInInterceptors();

	/**
	 * Get the List of out interceptors, to add an interceptor, add it to the list
	 * 
	 * @return the List of out interceptors
	 */
	public List<IOutInterceptor> getOutInterceptors();

}
