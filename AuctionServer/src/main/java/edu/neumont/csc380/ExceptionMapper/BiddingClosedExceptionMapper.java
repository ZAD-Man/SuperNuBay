package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.BiddingClosedException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class BiddingClosedExceptionMapper implements ExceptionMapper<BiddingClosedException>
{
	public Response toResponse(BiddingClosedException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}