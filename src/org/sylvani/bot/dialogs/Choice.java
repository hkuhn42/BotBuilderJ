/**
 * 
 */
package org.sylvani.bot.dialogs;

import java.io.Serializable;

import org.sylvani.bot.util.IModel;
import org.sylvani.bot.util.Model;

/**
 * @author Harald Kuhn
 *
 */
public class Choice<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T				  value;
	private IModel<String>	  label;

	public Choice(T value, String label) {
		super();
		this.value = value;
		this.label = new Model<String>(label);
	}

	public Choice(T value, IModel<String> label) {
		super();
		this.value = value;
		this.label = label;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public IModel<String> getLabel() {
		return label;
	}

	public String getLabelString() {
		return label.getObject();
	}

	public void setLabel(IModel<String> label) {
		this.label = label;
	}
}