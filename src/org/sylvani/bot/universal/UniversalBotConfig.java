/**
 * 
 */
package org.sylvani.bot.universal;

import java.util.ArrayList;
import java.util.List;

import org.sylvani.bot.IBotConfig;
import org.sylvani.bot.IInterceptor;
import org.sylvani.bot.recognize.IRecognizer;
import org.sylvani.bot.util.ILocalizer;

/**
 * @author Harald Kuhn
 *
 */
public class UniversalBotConfig implements IBotConfig {

	private ILocalizer		   localizer;
	private IRecognizer		   recognizer;

	private List<IInterceptor> inInterceptors;
	private List<IInterceptor> outInterceptors;

	public UniversalBotConfig() {
		inInterceptors = new ArrayList<>();
		outInterceptors = new ArrayList<>();
	}

	@Override
	public ILocalizer getLocalizer() {
		return localizer;
	}

	@Override
	public IRecognizer getRecognizer() {
		return recognizer;
	}

	@Override
	public void setLocalizer(ILocalizer localizer) {
		this.localizer = localizer;
	}

	@Override
	public void setRecognizer(IRecognizer recognizer) {
		this.recognizer = recognizer;

	}

	@Override
	public List<IInterceptor> getInInterceptors() {
		return inInterceptors;
	}

	@Override
	public List<IInterceptor> getOutInterceptors() {
		return outInterceptors;
	}

}