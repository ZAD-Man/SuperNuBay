package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class BiddingClosedException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BiddingClosedException() {
        super("Bidding is closed");
    }
    public BiddingClosedException(String msg)   {
        super(msg);
    }
    public BiddingClosedException(String msg, Exception e)  {
        super(msg, e);
    }
}
