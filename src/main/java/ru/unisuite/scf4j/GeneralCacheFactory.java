package ru.unisuite.scf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.helpers.Util;

import ru.unisuite.cache.PersistentCacheFactory;
import ru.unisuite.cache.cacheexception.CacheStartFailedException;
import ru.unisuite.scf4j.exception.SCF4JCacheStartFailedException;
import ru.unisuite.scf4j.impl.NOPCacheFactory;

public class GeneralCacheFactory {

	static final int UNINITIALIZED = 0;
	static final int FAILED_INITIALIZATION = 2;
	static final int SUCCESSFUL_INITIALIZATION = 3;
	static final int NOP_FALLBACK_INITIALIZATION = 4;
 
	static int INITIALIZATION_STATE = UNINITIALIZED;
	static final CacheFactory NOP_FALLBACK_FACTORY = new NOPCacheFactory();

	static final String UNSUCCESSFUL_INIT_MSG = "ru.inisuite.cache.CacheFactory in failed state. Original exception was thrown EARLIER. ";

	private GeneralCacheFactory() {
	}

	public static CacheFactory getCacheFactory(String congigFilePath) throws SCF4JCacheStartFailedException {

//		bind();
//
//		switch (INITIALIZATION_STATE) {
//		case SUCCESSFUL_INITIALIZATION:
//			return StaticCacheFactory.getCacheFactory(congigFilePath);
//		case NOP_FALLBACK_INITIALIZATION:
//			return NOP_FALLBACK_FACTORY;
//		case FAILED_INITIALIZATION:
//			throw new IllegalStateException(UNSUCCESSFUL_INIT_MSG);
//		}
//		throw new IllegalStateException("Unreachable code");
//		
//		

		try {
			return StaticCacheFactory.getCacheFactory(congigFilePath);
		} catch (NoClassDefFoundError ncde) {
			return NOP_FALLBACK_FACTORY;
		}
		
	}

	private static void bind() {

		try {
			Set<URL> staticLoggerBinderPathSet = null;

			staticLoggerBinderPathSet = findPossibleStaticCacheBinderPathSet();
			INITIALIZATION_STATE = SUCCESSFUL_INITIALIZATION;
		} catch (NoClassDefFoundError ncde) {
			INITIALIZATION_STATE = NOP_FALLBACK_INITIALIZATION;
		} catch (java.lang.NoSuchMethodError nsme) {
			INITIALIZATION_STATE = FAILED_INITIALIZATION;
		} catch (Exception e) {
			throw new IllegalStateException("Unexpected initialization failure", e);
		}

	}

	private static String STATIC_CACHE_BINDER_PATH = "ru/unisuite/cache/PersistentCacheFactory1.class";

	private static Set<URL> findPossibleStaticCacheBinderPathSet() {
		
		Set<URL> staticCacheBinderPathSet = new LinkedHashSet<URL>();
		try {
			ClassLoader cacheFactoryClassLoader = GeneralCacheFactory.class.getClassLoader();
			Enumeration<URL> paths;
			if (cacheFactoryClassLoader == null) {
				paths = ClassLoader.getSystemResources(STATIC_CACHE_BINDER_PATH);
			} else {
				paths = cacheFactoryClassLoader.getResources(STATIC_CACHE_BINDER_PATH);
			}
			while (paths.hasMoreElements()) {
				URL path = paths.nextElement();
				staticCacheBinderPathSet.add(path);
			}
		} catch (IOException ioe) {
			Util.report("Error getting resources from path", ioe);
		}
		return staticCacheBinderPathSet;

	}
}
