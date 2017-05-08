/**
 * 
 */
package org.sylvani.bot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harald Kuhn
 *
 */
public class InMemorySessionStore implements ISessionStore {

	private Map<String, ISession> conversations;

	public InMemorySessionStore() {
		this.conversations = new HashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.ISessionStore#find(java.lang.String)
	 */
	@Override
	public ISession find(String id) {
		return conversations.get(id);
	}

	@Override
	public void add(String convId, ISession session) {
		conversations.put(convId, session);
	}

	@Override
	public void remove(ISession session) {
		conversations.remove(session.getId());
	}
}
