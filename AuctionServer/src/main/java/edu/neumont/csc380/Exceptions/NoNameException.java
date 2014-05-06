package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class NoNameException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoNameException() {
        super("Item name is missing");
    }
    public NoNameException(String msg)   {
        super(msg);
    }
    public NoNameException(String msg, Exception e)  {
        super(msg, e);
    }
}
