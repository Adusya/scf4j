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

import ru.unisuite.scf4j.Cache;

public class NOPCache implements Cache {

	public Boolean put(String idInCache, Map<String, Object> parameters) throws IOException {
		return false;
	}

	public CompletableFuture<Boolean> putAsync(String idInCache, Map<String, Object> parameters) {
		return null;
	}

	public boolean get(String idInCache, OutputStream out, HttpServletResponse response)  {
		return false;
	}

	public boolean exists(String id)  {
		return false;
	}

	public String getHashById(String id)  {
		return "";
	}

	public Boolean deleteItem(String id) throws IOException {
		return false;
	}

	public CompletableFuture<Boolean> deleteItemAsync(String id) {
		return null;
	}

	public void applyDowntine(long downtime)  {
		
	}

	public FileOutputStream getFileOutputStream(String nodeName, String idInCache) throws FileNotFoundException {
		return null;
	}

	public void increaseHits() {
		
	}

	public void increaseMisses(){
		
	}

	public void clear()  {
		
	}

	public boolean connectionIsUp() {
		return false;
	}

	public void close() {
		
	}

	public void shutdown() {
		
	}

	public void writeToTwoStreams(String idInCache, Blob blobObject, OutputStream os1, OutputStream os2)
			throws IOException, SQLException {
		
	}

	public OutputStream openStream(String key) throws IOException {
		return null;
	}

	@Override
	public String getStatistics()  {
		return "";
	}

}
