package org.component.extricator.session;

import javax.ejb.Remote;

@Remote
public interface MethodExtricator {
	public String sayHello();

}
