/**
 * 
 */
package org.sylvani.bot.dialogs;

import java.lang.reflect.ParameterizedType;

import org.apache.commons.beanutils.ConvertUtils;
import org.sylvani.bot.IActivity;
import org.sylvani.bot.ISession;
import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.ISessionModel;

/**
 * @author Harald Kuhn
 *
 */
public abstract class Question<T> extends DialogBase {

	private IValidator<T>	 answerValidator;
	private ISessionModel<T> answerModel;

	private IModel<String>	 confirmText;

	public Question(ISessionModel<T> anwerModel) {
		this.answerModel = anwerModel;
	}

	/**
	 * use only for subclassing when {@link #answered(Object, ISession)} is overwritten
	 */
	protected Question() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IHandler#handle(org.sylvani.bot.ISession, org.sylvani.bot.IActivity)
	 */
	@Override
	public void handle(ISession session, IActivity activity) {
		T answer = null;
		Object alreadyAsked = session.getAttribute(String.valueOf(this.hashCode()));
		if (alreadyAsked != null) {
			String text = activity.getText();
			answer = findAnswer(text);
		}
		if (answer != null) {
			answered(answer, session);

			session.removeAttribut("asked");
			session.activeDialogFinished();
			return;
		}
		session.setAttribute(String.valueOf(this.hashCode()), "asked");
		super.handle(session, activity);
	}

	protected void answered(T answer, ISession session) {
		answerModel.setObject(answer, session);
		session.activeDialogFinished();
	}

	protected T findAnswer(String text) {
		return convert(text);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected T convert(String answerText) {
		Class clazz = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		return (T) ConvertUtils.convert(answerText, clazz);
	}

	public IValidator<T> getAnswerValidator() {
		return answerValidator;
	}

	public void setAnswerValidator(IValidator<T> answerValidator) {
		this.answerValidator = answerValidator;
	}

	public IModel<String> getConfirmText() {
		return confirmText;
	}

	public void setConfirmText(IModel<String> confirmText) {
		this.confirmText = confirmText;
	}

}
