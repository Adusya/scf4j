package ru.unisuite.scf4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;

import ru.unisuite.cache.cacheexception.CacheMetadataStoreConnectionException;
import ru.unisuite.scf4j.exception.SCF4JCacheGetException;

public interface Cache {

	public Boolean put(final String idInCache, Map<String, Object> parameters) throws IOException;

	public CompletableFuture<Boolean> putAsync(final String idInCache, final Map<String, Object> parameters);

	public boolean get(final String idInCache, OutputStream out, HttpServletResponse response) throws SCF4JCacheGetException;

	public boolean exists(final String id) ;

	public String getHashById(final String id) ;

	public Boolean deleteItem(final String id) throws IOException;

	public CompletableFuture<Boolean> deleteItemAsync(final String id);

	public void applyDowntine(final long downtime) ;

	public FileOutputStream getFileOutputStream(String nodeName, String idInCache) throws FileNotFoundException;

	public void increaseHits();

	public void increaseMisses();

	public void clear() ;

	public boolean connectionIsUp();

	public void close();

	public void shutdown();

	public void writeToTwoStreams(String idInCache, Blob blobObject, OutputStream os1, OutputStream os2)
			throws IOException, SQLException;

	public OutputStream openStream(String key) throws IOException;
	
	public String getStatistics() ;
	

}
