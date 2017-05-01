/**
 * 
 */
package org.sylvani.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.sylvani.bot.recognize.IRecognizer;
import org.sylvani.bot.util.ICrypt;
import org.sylvani.bot.util.ILocalizer;

/**
 * @author Harald Kuhn
 *
 */
public class BotConfig implements IBotConfig {

	protected Properties		 properties;

	protected ILocalizer		 localizer;
	protected IRecognizer		 recognizer;
	protected ICrypt			 crypt;

	protected IVariableResolver	 resolver;

	protected List<IInterceptor> inInterceptors;
	protected List<IInterceptor> outInterceptors;

	public BotConfig() {
		inInterceptors = new ArrayList<>();
		outInterceptors = new ArrayList<>();
		properties = new Properties();
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

	@Override
	public String getSetting(String name) {
		String setting = properties.getProperty(name);
		if (setting != null && setting.startsWith("Crypt ")) {
			setting = crypt.decrypt(setting.substring(6));
		}
		return setting;
	}

	@Override
	public ICrypt getCrypt() {
		return crypt;
	}

	@Override
	public void setCrypt(ICrypt crypt) {
		this.crypt = crypt;
	}

	@Override
	public IVariableResolver getResolver() {
		return resolver;
	}

	@Override
	public void setResolverf(IVariableResolver resolver) {
		this.resolver = resolver;
	}

}