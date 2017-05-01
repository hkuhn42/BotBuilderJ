package org.sylvani.bot.dialogs;

import org.sylvani.bot.ISession;

public interface IValidator<T> {

	public ValidationResult validate(Object value, ISession session);

}
