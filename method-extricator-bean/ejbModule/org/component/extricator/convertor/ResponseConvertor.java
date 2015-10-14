package org.component.extricator.convertor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.component.extricator.utils.ComponentUtils;

/**
 * @author Kalaiarasan
 * @version 1.0
 */
public class ResponseConvertor {

	public static Map<String, List<String>> convert(Map<String, List<Method>> map) {
		Map<String, List<String>> outputMap = ComponentUtils.getMapInstance();
		Iterator<Entry<String, List<Method>>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, List<Method>> thisEntry = (Entry<String, List<Method>>) entries.next();
			if (!thisEntry.getValue().isEmpty()) {
				List<String> output = new ArrayList<String>();
				for (Method method : thisEntry.getValue()) {
					output.add(String.valueOf(method));
				}
				outputMap.put(thisEntry.getKey(), output);
			}
		}

		return outputMap;
	}

}
