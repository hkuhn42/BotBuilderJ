/**
 * 
 */
package org.sylvani.bot.connector.ms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.SerializationConfig;
import org.sylvani.bot.IBot;
import org.sylvani.bot.IConnector;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Connector implementation for the ms bot apis
 * 
 * @author Harald Kuhn
 */
public class MSConnector implements IConnector {

	private BotClient client;

	private String address;

	public static String LOCAL_ADDRESS = "http://localhost:3978";

	public MSConnector() {
		this(LOCAL_ADDRESS);
	}

	public MSConnector(String address) {
		this.client = new BotClient();
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConnector#listen(org.sylvani.bot.IBot)
	 */
	@Override
	public void listen(IBot handler) {
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(MessageAPI.class);
		sf.setResourceProvider(MessageAPI.class, new SingletonResourceProvider(new MessageAPIImpl(handler)));
		List<Object> providers = new ArrayList<>();
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		providers.add(provider);
		sf.setProviders(providers);
		sf.setAddress(address);
		BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
		JAXRSBindingFactory factory = new JAXRSBindingFactory();
		factory.setBus(sf.getBus());
		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
		sf.create();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sylvani.bot.IConnector#send(java.lang.Object)
	 */
	@Override
	public void send(Activity activity) {
		client.send(activity);
	}

}