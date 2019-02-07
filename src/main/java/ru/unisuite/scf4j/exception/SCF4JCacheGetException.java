package ru.unisuite.scf4j.exception;

public class SCF4JCacheGetException extends Exception{

	private static final long serialVersionUID = 1L;

	private int errorCode;
	
    public SCF4JCacheGetException(final String message) {
    	
        this(0, "PersistentCache can not get this object: " + message);
    }
 
    public SCF4JCacheGetException(final int errorCode, final String message) {
    	
        super(message);

        this.errorCode = errorCode;
    }
    
    public SCF4JCacheGetException(String message, Throwable cause) {
  		super(message, cause);
  	}
 
    public int getErrorCode() {
    	
    	return errorCode;
    }
	
}
