package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.DescriptionTooLongException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class DescriptionTooLongExceptionMapper implements ExceptionMapper<DescriptionTooLongException>
{
	public Response toResponse(DescriptionTooLongException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}