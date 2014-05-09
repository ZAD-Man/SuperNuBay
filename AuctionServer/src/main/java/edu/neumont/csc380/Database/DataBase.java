package edu.neumont.csc380.Database;


public class DataBase
{
	private static Items items = new Items();
	private static Bids bids = new Bids();
	
	public static Items getItems() {
		return items;
	}
	
	public static Bids getBids() {
		return bids;
	}
}
