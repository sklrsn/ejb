package org.component.extricator.context;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ExtricatorContext {
	private static final String PROVIDER_URL = "jnp://localhost:1099";
	private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
	private static Context initialContext;

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
			prop.put(Context.PROVIDER_URL, PROVIDER_URL);
			initialContext = new InitialContext(prop);
		}
		return initialContext;
	}
}