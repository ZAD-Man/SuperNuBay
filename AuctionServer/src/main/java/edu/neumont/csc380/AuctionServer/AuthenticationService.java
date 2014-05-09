package edu.neumont.csc380.AuctionServer;

import edu.neumont.csc380.AuthClient.AuthClient;

public class AuthenticationService {

	public boolean verify (String token) {
		return new AuthClient().verify(token).isSuccess();
	}
}
