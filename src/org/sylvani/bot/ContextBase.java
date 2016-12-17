/**
 * 
 */
package org.sylvani.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * General purpose context base impl.
 * 
 * @author hkuhn
 */
public abstract class ContextBase implements IContext {

	private Map<String, Object> attributes;

	private List<IInInterceptor> inInterceptors;
	private List<IOutInterceptor> outInterceptors;

	public ContextBase() {
		attributes = new HashMap<>();
		inInterceptors = new ArrayList<>();
		outInterceptors = new ArrayList<>();
	}

	@Override
	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	@Override
	public Iterator<String> getAttributeNames() {
		return attributes.keySet().iterator();
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	@Override
	public List<IInInterceptor> getInInterceptors() {
		return inInterceptors;
	}

	@Override
	public List<IOutInterceptor> getOutInterceptors() {
		return outInterceptors;
	}

}
