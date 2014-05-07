package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.StatusCodes;
import edu.neumont.csc380.Exceptions.UnsafeDescriptionException;

@Provider
@Service
public class UnsafeDescriptionExceptionMapper implements ExceptionMapper<UnsafeDescriptionException>
{
	public Response toResponse(UnsafeDescriptionException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}