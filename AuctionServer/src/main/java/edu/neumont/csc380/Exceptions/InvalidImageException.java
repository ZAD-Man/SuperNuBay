package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class InvalidImageException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidImageException() {
        super("The image specified is too big or is otherwise unsupportable");
    }
    public InvalidImageException(String msg)   {
        super(msg);
    }
    public InvalidImageException(String msg, Exception e)  {
        super(msg, e);
    }
}
