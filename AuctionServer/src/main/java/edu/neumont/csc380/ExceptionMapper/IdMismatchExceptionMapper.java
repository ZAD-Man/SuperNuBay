package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.IdMismatchException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class IdMismatchExceptionMapper implements ExceptionMapper<IdMismatchException>
{
	public Response toResponse(IdMismatchException e) 
	{
		return Response.status(StatusCodes.INVALID_USERNAME).entity(e.getMessage()).build();
	}
}