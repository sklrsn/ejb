package org.component.extricator.session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface MethodExtricator {

	public boolean isRunning();

	public Map<String, List<String>> getpublicMethods(String path);

}
