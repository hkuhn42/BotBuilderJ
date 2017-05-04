package org.sylvani.bot;

import java.util.List;

/**
 * Defines an activity in a chat
 * 
 * Activities are of a type (like message, a state change or anything else)
 * 
 * @author Harald Kuhn
 *
 */
public interface IActivity {

	String getId();

	void setId(String id);

	String getTopic();

	void setTopic(String topic);

	ActivityType getType();

	void setType(ActivityType type);

	IParticipant getFrom();

	void setFrom(IParticipant from);

	IParticipant getRecipient();

	void setRecipient(IParticipant recipient);

	public String getText();

	public void setText(String text);

	public IConversation getConversation();

	public void setConversation(IConversation conversation);

	public void setAttachments(List<IAttachment> attachement);

	public List<IAttachment> getAttachments();

	/**
	 * Get the connector (can be used to access connector specific features)
	 * 
	 * @return
	 */
	public Object getConnectorActivity();

	/**
	 * get the Intent the recognizer detected (may be null)
	 * 
	 * @return
	 */
	public IIntent<?> getIntent();

	public void setIntent(IIntent<?> intent);
}