/**
 * 
 */
package org.sylvani.bot.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;

/**
 * Simple waterfall dialog subdialogs are processes in sequence
 * 
 * @author Harald Kuhn
 */
public class WaterfallDialog implements IDialog {

	private static final String	DIALOG_STATE_PREFIX	= "WaterfallDialog";

	private List<IDialog>		dialogs;
	private String				instanceStateKey;

	public WaterfallDialog() {
		this.dialogs = new ArrayList<>();
		this.instanceStateKey = DIALOG_STATE_PREFIX + "." + UUID.randomUUID().toString();
	}

	public WaterfallDialog(IDialog[] dialogs) {
		this();
		this.dialogs.addAll(Arrays.asList(dialogs));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IHandler#handle(org.sylvani.bot.ISession, org.sylvani.bot.connector.ms.model.Activity)
	 */
	@Override
	public void handle(ISession session, IActivity activity) {
		Integer instanceState = (Integer) session.getAttribute(instanceStateKey);
		if (instanceState == null) {
			instanceState = new Integer(0);
		}
		else if (instanceState >= dialogs.size()) {
			instanceState = new Integer(0);
		}
		IDialog activeDialog = dialogs.get(instanceState.intValue());
		session.setActiveDialog(activeDialog);
		instanceState++;
		session.setAttribute(instanceStateKey, instanceState);

		activeDialog.handle(session, activity);
	}

}
