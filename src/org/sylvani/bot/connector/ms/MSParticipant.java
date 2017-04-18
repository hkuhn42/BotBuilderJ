/**
 * 
 */
package org.sylvani.bot.connector.ms;

import org.sylvani.bot.IParticipant;
import org.sylvani.bot.connector.ms.model.ChannelAccount;

/**
 * @author Harald Kuhn
 *
 */
public class MSParticipant implements IParticipant {
	private ChannelAccount account;

	MSParticipant(ChannelAccount account) {
		this.account = account;
	}

	ChannelAccount getChannelAccount() {
		return account;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#getId()
	 */
	@Override
	public String getId() {
		return account.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		account.setId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#getName()
	 */
	@Override
	public String getName() {
		return account.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IParticipant#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		account.setName(name);
	}

}
