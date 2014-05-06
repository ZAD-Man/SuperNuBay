package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class BidTooLowException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BidTooLowException() {
        super("The bid is too low (minimum is $.01");
    }
    public BidTooLowException(String msg)   {
        super(msg);
    }
    public BidTooLowException(String msg, Exception e)  {
        super(msg, e);
    }
}
