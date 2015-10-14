package org.mdh.component.retrieve.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mdh.component.retrieve.utils.ComponentUtils;

public class RetrieveMethods {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String path = "C:/Users/ksaminathan/Downloads/test/javax.servlet-api-3.0.1.jar";
		try {
			Map<String, List<Method>> map = ComponentUtils.getMethodsMap(path);
			System.out.println(map.keySet().size());

			Iterator entries = map.entrySet().iterator();
			while (entries.hasNext()) {
				Entry thisEntry = (Entry) entries.next();
				System.out.println(thisEntry.getKey());
				System.out.println(thisEntry.getValue());
				System.out.println();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
