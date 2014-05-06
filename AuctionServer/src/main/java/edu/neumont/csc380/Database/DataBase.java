package edu.neumont.csc380.Database;


public class DataBase
{
	private static Items items = new Items();
//	private static AuthorizationTokens tokens = new AuthorizationTokens();
	
	public static Items getItems() {
		return items;
	}
	
//  TODO: Replace with bids
//	public static AuthorizationTokens getTokens() {
//		return tokens;
//	}
}
