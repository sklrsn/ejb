package org.component.extricator.session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

/**
 * @author Kalaiarasan
 * @version 1.0
 */
@Remote
public interface MethodExtricator {

	public boolean isRunning();

	public Map<String, List<String>> getpublicMethods(String path);

}
