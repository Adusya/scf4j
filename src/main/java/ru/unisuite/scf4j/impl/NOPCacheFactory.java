package ru.unisuite.scf4j.impl;

import ru.unisuite.scf4j.Cache;
import ru.unisuite.scf4j.CacheFactory;

public class NOPCacheFactory implements CacheFactory {

	public Cache getCache() {
		return new NOPCache();
	}

	public void close() {
	}

}
