package ru.unisuite.scf4j;

import ru.unisuite.scf4j.exception.SCF4JCacheStartFailedException;
import ru.unisuite.scf4j.impl.PersistentCacheFactoryAdapter;
import ru.unisuite.cache.cacheexception.CacheStartFailedException;

public class StaticCacheFactory {

	public static CacheFactory getCacheFactory(String congicFilePath) throws SCF4JCacheStartFailedException {
		
		try {
			return new PersistentCacheFactoryAdapter(congicFilePath);
		} catch (CacheStartFailedException e) {
			throw new SCF4JCacheStartFailedException(e.getMessage(), e);
		}
		
	}
	
}
