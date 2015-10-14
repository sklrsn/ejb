package org.component.extricator.client;

import javax.naming.Context;
import javax.naming.NamingException;

import org.component.extricator.context.ExtricatorContext;
import org.component.extricator.session.MethodExtricator;

public class ExtricatorClient {
	private static final String LOOKUP_STRING = "MethodExtricatorBean/remote";

	public static void main(String[] args) {
		MethodExtricator bean = ExtricatorClient.doLookup();
		// 3. Call business logic
		System.out.println(bean.isRunning());
	}

	private static MethodExtricator doLookup() {
		Context context = null;
		MethodExtricator bean = null;
		try {
			// 1. Obtaining Context
			context = ExtricatorContext.getInitialContext();
			// 2. Lookup and cast
			bean = (MethodExtricator) context.lookup(LOOKUP_STRING);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

}
