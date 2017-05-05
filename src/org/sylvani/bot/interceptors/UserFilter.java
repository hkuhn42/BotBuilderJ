/**
 * 
 */
package org.sylvani.bot.interceptors;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

/**
 * An interceptor that filters activities based on their sender user id using either a blacklist or a whitelist
 * 
 * @author Harald Kuhn
 */
public class UserFilter extends InterceptorBase {

	private static Logger logger = LoggerFactory.getLogger(UserFilter.class);

	private Set<String>	  whitelist;
	private Set<String>	  blacklist;

	public UserFilter() {
		this.whitelist = new HashSet<>();
		this.blacklist = new HashSet<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IHandler#handle(org.sylvani.bot.ISession, org.sylvani.bot.IActivity)
	 */
	@Override
	public void handle(ISession session, IActivity activity) {
		String id = activity.getFrom().getId();
		if (whitelist.contains(id)) {
			nextInChain.handle(session, activity);
		}
		else if (blacklist.contains(id)) {
			logger.info("dropped activity from " + id + " because its on the blacklist");
		}
		else if (whitelist.isEmpty()) {
			nextInChain.handle(session, activity);
		}
		logger.info("dropped activity from " + id + " because its not on the whitelist");

	}

	public boolean addToWhitelist(String e) {
		return whitelist.add(e);
	}

	public boolean removeFromWhitelist(Object o) {
		return whitelist.remove(o);
	}

	public void clearBlacklist() {
		blacklist.clear();
	}

	public boolean addToBlacklist(String e) {
		return blacklist.add(e);
	}

	public boolean removeFromBlacklist(String o) {
		return blacklist.remove(o);
	}

	public void clearWhitelist() {
		whitelist.clear();
	}

}
