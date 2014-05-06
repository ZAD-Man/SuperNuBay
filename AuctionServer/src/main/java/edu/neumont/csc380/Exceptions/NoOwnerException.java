package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class NoOwnerException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoOwnerException() {
        super("Item owner is missing");
    }
    public NoOwnerException(String msg)   {
        super(msg);
    }
    public NoOwnerException(String msg, Exception e)  {
        super(msg, e);
    }
}
