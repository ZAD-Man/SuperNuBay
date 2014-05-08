package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class IdMismatchException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdMismatchException() {
        super("Uri specified a different item ID compared to the item ID in the body");
    }
    public IdMismatchException(String msg)   {
        super(msg);
    }
    public IdMismatchException(String msg, Exception e)  {
        super(msg, e);
    }
}
