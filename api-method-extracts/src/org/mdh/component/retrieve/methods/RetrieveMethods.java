package org.mdh.component.retrieve.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mdh.component.retrieve.utils.ComponentUtils;

public class RetrieveMethods {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String path = "C:/Test/antlr-2.7.7.jar";
		try {
			Map<String, List<Method>> map = ComponentUtils.getMethodsMap(path);
			System.out.println(map.keySet().size());
			Map<String, List<String>> outputMap = ComponentUtils.getMapInstance();
			Iterator entries = map.entrySet().iterator();
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

			System.out.println(outputMap.size());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
