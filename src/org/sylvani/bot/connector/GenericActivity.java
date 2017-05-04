/**
 * 
 */
package org.sylvani.bot.connector;

import java.io.Serializable;
import java.util.List;

import org.sylvani.bot.ActivityType;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IAttachment;
import org.sylvani.bot.IConversation;
import org.sylvani.bot.IIntent;
import org.sylvani.bot.IParticipant;

/**
 * @author Harald Kuhn
 *
 */
public class GenericActivity implements Serializable, IActivity {

	private static final long serialVersionUID = 1L;

	private String			  id;

	private String			  topic;

	private ActivityType	  type;

	private String			  text;

	private IParticipant	  from;

	private IParticipant	  recipient;

	private IConversation	  conversation;

	private List<IAttachment> attachements;

	private IIntent<?>		  intent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getTopic()
	 */
	@Override
	public String getTopic() {
		return topic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setTopic(java.lang.String)
	 */
	@Override
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getType()
	 */
	@Override
	public ActivityType getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setType(org.sylvani.bot.ActivityType)
	 */
	@Override
	public void setType(ActivityType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getFrom()
	 */
	@Override
	public IParticipant getFrom() {
		return from;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setFrom(org.sylvani.bot.IParticipant)
	 */
	@Override
	public void setFrom(IParticipant from) {
		this.from = from;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getRecipients()
	 */
	@Override
	public IParticipant getRecipient() {
		return recipient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setRecipients(java.util.List)
	 */
	@Override
	public void setRecipient(IParticipant recipient) {
		this.recipient = recipient;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public IConversation getConversation() {
		return conversation;
	}

	@Override
	public void setConversation(IConversation conversation) {
		this.conversation = conversation;
	}

	@Override
	public void setAttachments(List<IAttachment> attachement) {
		this.attachements = attachement;
	}

	@Override
	public List<IAttachment> getAttachments() {
		return attachements;
	}

	@Override
	public Object getConnectorActivity() {
		return this;
	}

	@Override
	public IIntent<?> getIntent() {
		return intent;
	}

	@Override
	public void setIntent(IIntent<?> intent) {
		this.intent = intent;
	}

}
