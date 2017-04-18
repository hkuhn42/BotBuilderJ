package org.sylvani.bot;

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
}