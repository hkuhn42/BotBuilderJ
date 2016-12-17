package org.sylvani.bot;

import java.util.Iterator;
import java.util.List;

/**
 * general purpose context
 * 
 * @author Harald Kuhn
 */
public interface IContext {

	public Object getAttribute(String name);

	public Iterator<String> getAttributeNames();

	public void setAttribute(String name, Object value);

	public List<IInInterceptor> getInInterceptors();

	public List<IOutInterceptor> getOutInterceptors();

}
