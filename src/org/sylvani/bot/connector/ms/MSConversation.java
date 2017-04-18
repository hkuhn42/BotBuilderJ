/**
 * 
 */
package org.sylvani.bot.connector.ms;

import org.sylvani.bot.IConversation;
import org.sylvani.bot.connector.ms.model.ConversationAccount;

/**
 * @author Harald Kuhn
 *
 */
public class MSConversation implements IConversation {

	private ConversationAccount	conversation;
	private String				channel;

	MSConversation(ConversationAccount conversation, String channel) {
		this.conversation = conversation;
		this.channel = channel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversation#getId()
	 */
	@Override
	public String getId() {
		return conversation.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversation#getChannel()
	 */
	@Override
	public String getChannel() {
		return channel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConversation#getConnectorId()
	 */
	@Override
	public String getConnectorId() {
		return MSConnector.class.getName();
	}

}
