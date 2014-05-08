package edu.neumont.csc380.AuctionServer;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.AuthServer.AuthPayload;
import edu.neumont.csc380.AuthServer.Credentials;
import edu.neumont.csc380.Database.AuthorizationToken;
import edu.neumont.csc380.Exceptions.NoIDException;
import edu.neumont.csc380.Exceptions.NoUserFoundException;
import edu.neumont.csc380.Exceptions.TokenExpiredException;
import edu.neumont.csc380.Exceptions.TokenInvalidException;
import edu.neumont.csc380.Exceptions.TokenMissingException;

@Service("IAuctionService")
public class AuctionService implements IAuctionService {
	
	public Response handleLoginRequest(Credentials credentials) throws Exception {		
		Response response = null;
		return response;
	}

	public Response handleLogoutRequest(AuthPayload payload) throws Exception {
		return Response.status(204).build();
	}

	//TODO: This needs to create a user not check if one exists
	public Response handleCreationRequest(Credentials creds) throws Exception {
		Response response = null;
		return response;
	}

	/* (non-Javadoc)
	 * @see edu.neumont.csc380.AuthServer.IAuthenticationService#verify(edu.neumont.csc380.AuthServer.AuthPayload)
	 */
	public Response verify(AuthPayload auth) throws Exception {
		Response response = null;
		return response;
	}

	/**
	 * Generates a response after validating the token
	 * The response will have a AuthPayload with only the id
	 * 
	 * @param userID
	 * @return response with an AuthPayload
	 */
	private Response generateResponse(String userID) {
		Response response = null;
		return response;
	}

	/**
	 * Generates and updates a token in the database
	 * @param userID
	 * @return
	 */
	private String updateToken(String userID) {
		String tokenString = null;
		return tokenString;
	}

	/**
	 * Validates the token provided is valid
	 * Checks the userID, Signature, and Expiry of a token match
	 * @param userID
	 * @param userToken
	 * @throws TokenInvalidException
	 * @throws TokenExpiredException
	 * @throws TokenMissingException
	 */
	private AuthorizationToken validateUserToken(String userID, AuthorizationToken userToken) throws Exception {
		AuthorizationToken dbToken =  null;
		return dbToken;
	}

	/**
	 * Will verify the user exists in the database
	 * @param auth
	 * @throws NoUserFoundException
	 */
	private void verifyUserExists(AuthPayload auth) throws NoUserFoundException {

	}

	/**
	 * Checks the user is not null or empty
	 * 
	 * @param id
	 * @throws NoIDException
	 */
	private void verifyIdExists(String id) throws NoIDException {
		
	}
}