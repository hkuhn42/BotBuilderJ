/**
 * 
 */
package org.sylvani.bot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.globalmentor.collections.Maps;

/**
 * General purpose context base impl.
 * 
 * @author hkuhn
 */
public abstract class ContextBase implements IContext {

	private Map<String, Serializable> attributes;

	public ContextBase() {
		attributes = new HashMap<>();

	}

	@Override
	public Serializable getAttribute(String name) {
		return attributes.get(name);
	}

	@Override
	public Set<String> getAttributeNames() {
		return attributes.keySet();
	}

	@Override
	public void setAttribute(String name, Serializable value) {
		attributes.put(name, value);
	}

	@Override
	public Serializable removeAttribut(String name) {
		return attributes.remove(name);
	}

	@Override
	public Map<String, Serializable> asAttributeMap() {
		return Maps.toImmutableMap(attributes);
	}

}
