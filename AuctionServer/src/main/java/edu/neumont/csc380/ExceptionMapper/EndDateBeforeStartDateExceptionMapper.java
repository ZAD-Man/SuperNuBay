package edu.neumont.csc380.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Exceptions.EndDateBeforeStartDateException;
import edu.neumont.csc380.Exceptions.InvalidPasswordOrUserNameException;
import edu.neumont.csc380.Exceptions.NoNameException;
import edu.neumont.csc380.Exceptions.NoOwnerException;
import edu.neumont.csc380.Exceptions.StatusCodes;

@Provider
@Service
public class EndDateBeforeStartDateExceptionMapper implements ExceptionMapper<EndDateBeforeStartDateException>
{
	public Response toResponse(EndDateBeforeStartDateException e) 
	{
		return Response.status(StatusCodes.ERROR_400).entity(e.getMessage()).build();
	}
}