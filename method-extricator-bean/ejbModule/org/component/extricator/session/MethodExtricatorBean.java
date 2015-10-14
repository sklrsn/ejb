package org.component.extricator.session;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.component.extricator.convertor.ResponseConvertor;
import org.component.extricator.utils.ComponentUtils;

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
	public boolean isRunning() {
		return true;
	}

	@Override
	public Map<String, List<String>> getpublicMethods(String path) {
		try {
			return ResponseConvertor.convert(ComponentUtils.getMethodsMap(path));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: Swallowing the Exception
			// TODO: create a customized exception Here
		}
		return ComponentUtils.getMapInstance();
	}

}
