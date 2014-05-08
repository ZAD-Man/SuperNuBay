package edu.neumont.csc380.AuctionServer;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Database.Bid;
import edu.neumont.csc380.Database.Item;

@Service("IAuctionService")
public class AuctionService implements IAuctionService {

	@Override
	public Response getItem(Long id) throws Exception {
		
		return null;
	}

	@Override
	public Response createItem(Item item, String token) throws Exception {
		new CMSService().addAuctionMedia(item);
		
		return null;
	}

	@Override
	public Response updateItem(Long id, Item item, String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteItem(Long id, String token) throws Exception {
		new CMSService().deleteMedia(id);
		return null;
	}

	@Override
	public Response placeBid(Bid bid, String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getBids(Long id, String token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}