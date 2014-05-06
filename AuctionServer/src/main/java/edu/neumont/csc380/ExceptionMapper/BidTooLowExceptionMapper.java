package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.BidTooLowException;
import edu.neumont.csc380.Exceptions.EndDateBeforeStartDateException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class BidTooLowExceptionMapper implements ExceptionMapper<BidTooLowException>
{
	public Response toResponse(BidTooLowException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}