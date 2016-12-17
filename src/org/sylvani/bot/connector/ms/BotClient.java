package org.sylvani.bot.connector.ms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.Bus;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.sylvani.bot.connector.ms.model.Activity;

/**
 * Bot API Client
 * 
 * @author Harald Kuhn
 *
 */
public class BotClient {

	private static String serverURL = "https://login.microsoftonline.com/d6d49420-f39b-4df7-a1dc-d59a935871db/oauth2/v2.0/token";

	// private static String CONVERSATION_URL = "https://api.botframework.com";

	public void send(Activity activity) {
		// conversationURL = "https://webchat.botframework.com";

		ConversationsApi conAPI = initConversationRestProxy(activity.getServiceUrl());
		configureLogging(conAPI);
		configureConduit(conAPI);

		String token = TokenUtil.getInstance().ensureToken();
		WebClient.client(conAPI).header("Authorization", "Bearer " + token);

		conAPI.conversationsReplyToActivity(activity.getConversation().getId(), activity.getId(), activity);
	}

	protected static ConversationsApi initConversationRestProxy(String url) {
		List<Object> providers = new ArrayList<>();
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		providers.add(provider);
		ConversationsApi inbox = JAXRSClientFactory.create(url, ConversationsApi.class, providers);
		return inbox;
	}

	protected static AuthenticationAPI initRestProxy() {
		List<Object> providers = new ArrayList<>();
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		providers.add(provider);
		AuthenticationAPI inbox = JAXRSClientFactory.create(serverURL, AuthenticationAPI.class, providers);

		return inbox;
	}

	protected static void configureLogging(Object proxy) {
		Bus bus = WebClient.getConfig(proxy).getBus();
		bus.getInInterceptors().add(new LoggingInInterceptor());
		bus.getOutInterceptors().add(new LoggingOutInterceptor());
	}

	protected static void configureConduit(Object proxy) {
		HTTPConduit conduit = (HTTPConduit) WebClient.getConfig(proxy).getConduit();
		TLSClientParameters params = new TLSClientParameters();
		params.setDisableCNCheck(true);// FIXME: this is not the way to go
		conduit.setTlsClientParameters(params);
	}
}
