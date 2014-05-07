package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class UnsafeDescriptionException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsafeDescriptionException() {
        super("Description contains scripting or other unsafe HTML");
    }
    public UnsafeDescriptionException(String msg)   {
        super(msg);
    }
    public UnsafeDescriptionException(String msg, Exception e)  {
        super(msg, e);
    }
}
