package ru.unisuite.scf4j.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;

import ru.unisuite.cache.PersistentCache;
import ru.unisuite.cache.cacheexception.CacheGetException;
import ru.unisuite.scf4j.Cache;
import ru.unisuite.scf4j.exception.SCF4JCacheGetException;

public class PersistentCacheAdapter implements Cache{
	
	PersistentCache cache;
	
	public PersistentCacheAdapter(PersistentCache persistentCache) throws IOException {

		cache = persistentCache;
	}
	
	@Override
	public Boolean put(String idInCache, Map<String, Object> parameters) throws IOException {
		return cache.put(idInCache, parameters);
	}

	@Override
	public CompletableFuture<Boolean> putAsync(String idInCache, Map<String, Object> parameters) {
		return cache.putAsync(idInCache, parameters);
	}

	@Override
	public boolean get(String idInCache, OutputStream out, HttpServletResponse response) throws SCF4JCacheGetException {
		try {
			return cache.get(idInCache, out, response);
		} catch (CacheGetException e) {
			throw new SCF4JCacheGetException(e.getErrorCode(), e.getMessage());
		}
	}

	@Override
	public boolean exists(String id) {
		return cache.exists(id);
	}

	@Override
	public String getHashById(String id) {
		return cache.getHashById(id);
	}

	@Override
	public Boolean deleteItem(String id) throws IOException {
		return cache.deleteItem(id);
	}

	@Override
	public CompletableFuture<Boolean> deleteItemAsync(String id) {
		return cache.deleteItemAsync(id);
	}

	@Override
	public void applyDowntine(long downtime) {
		cache.applyDowntine(downtime);		
	}

	@Override
	public FileOutputStream getFileOutputStream(String nodeName, String idInCache) throws FileNotFoundException {
		return cache.getFileOutputStream(nodeName, idInCache);
	}

	@Override
	public void clear() {
		cache.clear();		
	}

	@Override
	public boolean connectionIsUp() {
		return cache.connectionIsUp();
	}

	@Override
	public void close() {
		cache.close();		
	}

	@Override
	public void shutdown() {
		cache.shutdown();		
	}

	@Override
	public void writeToTwoStreams(String idInCache, Blob blobObject, OutputStream os1, OutputStream os2)
			throws IOException, SQLException {
		cache.writeToTwoStreams(idInCache, blobObject, os1, os2);		
	}

	@Override
	public OutputStream openStream(String key) throws IOException {
		return cache.openStream(key);
	}

	@Override
	public String getStatistics() {
		return cache.getStatistics();
	}

	@Override
	public void increaseHits() {
		cache.increaseHits();		
	}

	@Override
	public void increaseMisses() {
		cache.increaseMisses();		
	}

}
