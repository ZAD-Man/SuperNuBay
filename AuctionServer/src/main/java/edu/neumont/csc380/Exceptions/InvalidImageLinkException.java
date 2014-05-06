package edu.neumont.csc380.Exceptions;

import java.io.Serializable;

public class InvalidImageLinkException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidImageLinkException() {
        super("The image link is not a valid URL");
    }
    public InvalidImageLinkException(String msg)   {
        super(msg);
    }
    public InvalidImageLinkException(String msg, Exception e)  {
        super(msg, e);
    }
}
