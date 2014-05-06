package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.InvalidImageException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class InvalidImageExceptionMapper implements ExceptionMapper<InvalidImageException>
{
	public Response toResponse(InvalidImageException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}