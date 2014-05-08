package edu.neumont.csc380.AuctionServer;

import edu.neumont.csc380.AuthClient.AuthClient;

public class AuthenticationService {

	public static boolean verify (String userID, String token) {
		return new AuthClient().verify(userID, token).isSuccess();
	}
}
