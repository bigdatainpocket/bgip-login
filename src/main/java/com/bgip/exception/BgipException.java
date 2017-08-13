package com.bgip.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BgipException extends Exception{

	private static final long serialVersionUID = 633746055431776833L;

	private static final Logger LOGGER = LoggerFactory.getLogger(BgipException.class);

	    private static final String DEFAULT_MSG = "BGIP Exception";

	    private static final String BGIP_EXCEPTION_CODE = "BGIP_EXCEPTION";

	    private final String code;

	    private final Throwable reason;

	    private final String hostName;

	    private final String message;
	    
	    /**
	     * Create exception object with the default message.
	     */
	    public BgipException() {

	        this(DEFAULT_MSG);
	    }
	    
	    /**
	     * Create exception object with the given message.
	     *
	     * @param msg the exception message
	     */
	    public BgipException(final String msg) {

	        this(msg, BGIP_EXCEPTION_CODE, null);
	    }
	    
	    
	    /**
	     * Create exception object with the given message and exception code.
	     *
	     * @param msg the exception message
	     * @param code the exception code
	     */
	    public BgipException(final String msg, final String code) {

	        this(msg, code, null);
	    }
	    
	    /**
	     * Create exception object with the given message and exception code.
	     *
	     * @param msg the exception message
	     * @param code the exception code
	     * @param reason actual exception
	     */
	    public BgipException(final String msg, final String code,
	            final Throwable reason) {

	    	this(msg, (Exception) reason);
	        /*super(msg);
	        this.message = msg;
	        this.hostName = "";
	        this.code = code;
	        this.reason = reason;*/
	    }

	    /**
	     * Create exception object with the given message.
	     *
	     * @param message exception message
	     * @param exception the actual Exception thrown.
	     */
	    public BgipException(final String message, final Exception exception) {
	        super(message);

	        if (System.getProperty("os.name").startsWith("Windows")) {
	            hostName = System.getenv("COMPUTERNAME");
	        } else {
	            hostName = System.getenv("HOSTNAME");
	        }
	        String printmessage = "BODT Exception : " + message + " occurred, code " + hostName + "-" + new Date().getTime() / 1000;
	        LOGGER.error(printmessage, " with exception : {} ", exception);
	        this.message = printmessage;
	        this.code = "";
	        this.reason = exception;
	    }

	    public String getCode() {
	        return code;
	    }

	    public Throwable getReason() {
	        return reason;
	    }

	    public String getHostName() {
	        return hostName;
	    }

	    @Override
	    public String getMessage() {
	        return message;
	    }

	    
	    
	    
}
