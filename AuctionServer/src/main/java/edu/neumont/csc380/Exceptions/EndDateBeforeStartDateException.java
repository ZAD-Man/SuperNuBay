package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class EndDateBeforeStartDateException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EndDateBeforeStartDateException() {
        super("The end date is before the start date");
    }
    public EndDateBeforeStartDateException(String msg)   {
        super(msg);
    }
    public EndDateBeforeStartDateException(String msg, Exception e)  {
        super(msg, e);
    }
}
