package org.sylvani.bot.dialogs;

import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.util.IModel;

import io.rincl.Rincled;

/**
 * Abstract base class that handles preparatino of an answer
 * 
 * @author Harald Kuhn
 *
 */
public abstract class DialogBase implements IDialog, Rincled {

	public abstract IModel<String> getText(IActivity request, ISession session);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IHandler#handle(org.sylvani.bot.ISession, org.sylvani.bot.IActivity)
	 */
	@Override
	public void handle(ISession session, IActivity request) {
		IActivity answer = session.getConnector().newReplyTo(request);
		fillActivity(request, answer, session);
		session.send(answer);
	}

	protected void fillActivity(IActivity request, IActivity response, ISession session) {
		response.setText(getText(request, session).getObject());
	}

}