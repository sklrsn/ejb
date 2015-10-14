package org.component.extricator.session;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MethodExtricatorBean
 */
@Stateless
public class MethodExtricatorBean implements MethodExtricator {

	/**
	 * Default constructor.
	 */
	public MethodExtricatorBean() {
	}

	@Override
	public String sayHello() {
		return "Hello Kalai";
	}

}
