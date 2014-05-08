package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class AttributeLockedException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttributeLockedException() {
        super("Starting bid cannot be changed since item now has bids");
    }
    public AttributeLockedException(String msg)   {
        super(msg);
    }
    public AttributeLockedException(String msg, Exception e)  {
        super(msg, e);
    }
}
