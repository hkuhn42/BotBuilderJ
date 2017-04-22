/**
 * 
 */
package org.sylvani.bot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * General purpose context base impl.
 * 
 * @author hkuhn
 */
public abstract class ContextBase implements IContext {

	private Map<String, Object> attributes;

	public ContextBase() {
		attributes = new HashMap<>();

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

}
