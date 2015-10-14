package org.component.extricator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This class added for Component Utilities
 * 
 * @author Kalaiarasan
 * @version 1.0
 *
 */

public class ComponentUtils {

	@SuppressWarnings("unchecked")
	private static final Class<URL>[] parameters = new Class[] { URL.class };

	/**
	 * @param path
	 * @return Map<String, List<Method>>
	 * @throws Exception
	 */
	public static Map<String, List<Method>> getMethodsMap(String path) throws SecurityException, ClassNotFoundException, IOException,
			NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (!extractClassNames(path).isEmpty()) {
			return extractMethods(extractClassNames(path));
		}
		return getMapInstance();
	}

	private static List<String> extractClassNames(String path) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		addToClassPath(path);
		List<String> classNames = new ArrayList<String>();
		ZipInputStream zipStream = new ZipInputStream(new FileInputStream(path));
		try {
			for (ZipEntry entry = zipStream.getNextEntry(); entry != null; entry = zipStream.getNextEntry()) {
				if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
					String className = entry.getName().replace('/', '.');
					classNames.add(className.substring(0, className.length() - ".class".length()));
				}
			}
			return classNames;
		} finally {
			zipStream.close();
		}
	}

	private static Map<String, List<Method>> extractMethods(List<String> classes) throws SecurityException, ClassNotFoundException {
		Map<String, List<Method>> map = getMapInstance();

		for (String className : classes) {
			Method[] methods = Class.forName(className).getMethods();
			if (methods.length > 0) {
				map.put(className, Arrays.asList(methods));
			} else {
				map.put(className, Collections.<Method> emptyList());
			}
		}

		return map;
	}

	private static void addToClassPath(String path) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		File file = new File(path);
		if (file.exists()) {
			addtoClassLoader(file.toURI().toURL());
		} else {
			throw new IOException("File Not Found");
		}
	}

	private static void addtoClassLoader(URL url) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class<URLClassLoader> sysclass = URLClassLoader.class;
		Method method = sysclass.getDeclaredMethod("addURL", parameters);
		method.setAccessible(true);
		method.invoke(sysloader, new Object[] { url });
	}

	public static <K, V> Map<K, V> getMapInstance() {
		return new HashMap<K, V>();
	}

}
