package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class DescriptionTooLongException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DescriptionTooLongException() {
        super("Description is too long");
    }
    public DescriptionTooLongException(String msg)   {
        super(msg);
    }
    public DescriptionTooLongException(String msg, Exception e)  {
        super(msg, e);
    }
}
