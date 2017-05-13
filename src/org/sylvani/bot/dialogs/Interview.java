/**
 *    Copyright (C) 2016-2017 Harald Kuhn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
public class Interview implements IDialog {

	private static final String	DIALOG_STATE_PREFIX	= "WaterfallDialog";

	private List<IDialog>		dialogs;
	private String				instanceStateKey;
	private Class				resultBean;

	public Interview(Class resultBean) {
		this.resultBean = resultBean;
	}

	public Interview() {
		this.dialogs = new ArrayList<>();
		this.instanceStateKey = DIALOG_STATE_PREFIX + "." + UUID.randomUUID().toString();
	}

	public Interview(IDialog[] dialogs) {
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
