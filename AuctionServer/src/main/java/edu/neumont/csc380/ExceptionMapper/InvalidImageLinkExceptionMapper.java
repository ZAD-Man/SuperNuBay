package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.BidTooLowException;
import edu.neumont.csc380.Exceptions.InvalidImageLinkException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class InvalidImageLinkExceptionMapper implements ExceptionMapper<InvalidImageLinkException>
{
	public Response toResponse(InvalidImageLinkException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}