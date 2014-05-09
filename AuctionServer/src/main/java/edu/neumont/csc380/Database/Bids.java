package edu.neumont.csc380.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bids {
	private HashMap<Long, List<Bid>> table = new HashMap<Long, List<Bid>>();
	
	public List<Bid> getBidsById(String itemId) {
		return table.get(itemId);
	}
	
	public boolean containsBids(long itemId) {
		return table.containsKey(itemId);
	}
	
	public void addBid(Bid bid) {
		long itemId = bid.getItemId();
		if ( !containsBids( itemId ) ) {
			table.put(itemId, new ArrayList<Bid>());
		}
		table.get(itemId).add(bid);
	}
}
