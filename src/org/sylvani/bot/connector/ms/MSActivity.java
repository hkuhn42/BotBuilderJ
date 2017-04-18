/**
 * 
 */
package org.sylvani.bot.connector.ms;

import org.sylvani.bot.ActivityType;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.IConversation;
import org.sylvani.bot.IParticipant;
import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.connector.ms.model.ChannelAccount;

/**
 * @author Harald Kuhn
 *
 */
public class MSActivity implements IActivity {
	private Activity activity;

	MSActivity(Activity activity) {
		this.activity = activity;
	}

	Activity getActivity() {
		return activity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getId()
	 */
	@Override
	public String getId() {
		return activity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		activity.setId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getTopic()
	 */
	@Override
	public String getTopic() {
		return activity.getTopicName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setTopic(java.lang.String)
	 */
	@Override
	public void setTopic(String topic) {
		activity.setTopicName(topic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getType()
	 */
	@Override
	public ActivityType getType() {
		String type = activity.getType();
		if ("message".equalsIgnoreCase(type)) {
			return ActivityType.MESSAGE;
		}
		else if ("typing".equalsIgnoreCase(type)) {
			return ActivityType.OTHER;
		}
		return ActivityType.OTHER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setType(org.sylvani.bot.ActivityType)
	 */
	@Override
	public void setType(ActivityType type) {
		switch (type) {
			case MESSAGE:
				activity.setType("message");
				break;
			default:
				break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getFrom()
	 */
	@Override
	public IParticipant getFrom() {
		return new MSParticipant(activity.getFrom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setFrom(org.sylvani.bot.IParticipant)
	 */
	@Override
	public void setFrom(IParticipant from) {
		if (from instanceof MSParticipant) {
			activity.setFrom(((MSParticipant) from).getChannelAccount());
		}
		else {
			ChannelAccount account = new ChannelAccount();
			account.setId(from.getId());
			account.setName(from.getName());
			activity.setFrom(account);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#getRecipients()
	 */
	@Override
	public IParticipant getRecipient() {
		return new MSParticipant(activity.getRecipient());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IActivity#setRecipients(java.util.List)
	 */
	@Override
	public void setRecipient(IParticipant recipient) {
		activity.setRecipient(((MSParticipant) recipient).getChannelAccount());
	}

	@Override
	public String getText() {
		return activity.getText();
	}

	@Override
	public void setText(String text) {
		activity.setText(text);
	}

	@Override
	public IConversation getConversation() {
		return new MSConversation(activity.getConversation(), activity.getChannelId());
	}

	@Override
	public void setConversation(IConversation conversation) {
		// TODO Auto-generated method stub

	}

}
