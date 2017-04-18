package org.sylvani.bot.connector;

import java.io.Serializable;

import org.sylvani.bot.IConversation;

public class GenericConversation implements IConversation, Serializable {

	private static final long serialVersionUID = 1L;

	private String			  id;
	private String			  channel;
	private String			  connectorId;

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}
}
