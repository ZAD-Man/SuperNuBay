package edu.neumont.csc380.AuctionServer;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Database.Bid;
import edu.neumont.csc380.Database.Item;

@Service("IAuctionService")
public class AuctionService implements IAuctionService {

	@Override
	public Response getItem(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createItem(Item item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateItem(Long id, Item item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteItem(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response placeBid(Bid bid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}