package ru.unisuite.scf4j.impl;

import java.io.IOException;

import ru.unisuite.cache.PersistentCacheFactory;
import ru.unisuite.cache.cacheexception.CacheStartFailedException;
import ru.unisuite.scf4j.Cache;
import ru.unisuite.scf4j.CacheFactory;

public class PersistentCacheFactoryAdapter implements CacheFactory {

	private PersistentCacheFactory persistentCacheFactory;
	
	public PersistentCacheFactoryAdapter(String configFilePath) throws CacheStartFailedException {
		
		persistentCacheFactory = new PersistentCacheFactory(configFilePath);
		
	}
	
	public Cache getCache() {
		Cache cache = null;
		try {
			cache = new PersistentCacheAdapter(persistentCacheFactory.getCache());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cache;
	}

	public void close() {
		persistentCacheFactory.close();
	}

}
