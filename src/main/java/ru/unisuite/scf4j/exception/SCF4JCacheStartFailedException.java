package ru.unisuite.scf4j.exception;

public class SCF4JCacheStartFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	
    public SCF4JCacheStartFailedException(final String message) {
    	
        this(0, "PersistentCache can not get this object: " + message);
    }
 
    public SCF4JCacheStartFailedException(final int errorCode, final String message) {
    	
        super(message);

        this.errorCode = errorCode;
    }
    
    public SCF4JCacheStartFailedException(String message, Throwable cause) {
  		super(message, cause);
  	}
 
    public int getErrorCode() {
    	
    	return errorCode;
    }
	
}