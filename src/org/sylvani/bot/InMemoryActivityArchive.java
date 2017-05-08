/**
 * 
 */
package org.sylvani.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harald Kuhn
 *
 */
public class InMemoryActivityArchive implements IActivityArchive {

	private Map<String, List<IActivity>> conversations;

	public InMemoryActivityArchive() {
		conversations = new HashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IHandler#handle(org.sylvani.bot.ISession, org.sylvani.bot.IActivity)
	 */
	@Override
	public void handle(ISession session, IActivity activity) {
		List<IActivity> activities = conversations.get(session.getId());
		if (activities == null) {
			activities = new ArrayList<>();
			conversations.put(session.getId(), activities);
		}
		activities.add(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivityArchive#removeConversation(java.lang.String)
	 */
	@Override
	public void removeConversation(String id) {
		conversations.remove(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivityArchive#getMessagesByConversation(java.lang.String)
	 */
	@Override
	public List<IActivity> getActivitiesByConversation(String id) {
		return conversations.get(id);
	}

}
