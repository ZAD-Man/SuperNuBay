package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.InvalidPasswordOrUserNameException;
import edu.neumont.csc380.Exceptions.NoNameException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class NoNameExceptionMapper implements ExceptionMapper<NoNameException>
{
	public Response toResponse(NoNameException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}