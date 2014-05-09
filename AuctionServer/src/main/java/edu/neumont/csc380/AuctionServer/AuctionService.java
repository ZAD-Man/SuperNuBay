package edu.neumont.csc380.AuctionServer;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Database.Bid;
import edu.neumont.csc380.Database.DataBase;
import edu.neumont.csc380.Database.Item;
import edu.neumont.csc380.Database.Items;
import edu.neumont.csc380.Exceptions.IdMismatchException;
import edu.neumont.csc380.Exceptions.TokenInvalidException;

@Service("IAuctionService")
public class AuctionService implements IAuctionService {

	@Override
	public Response getItem(Long id) throws Exception {
		Items items = DataBase.getItems();
		
		if (!items.containsItem(id)) {
			//TODO: make a better exception like no ID exists - currently, no such exception exists
			throw new IdMismatchException();
		}
		Item returnItem = items.getById(id);
		
		return Response.status(200).entity(returnItem).build();
	}

	@Override
	public Response createItem(Item item, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		new CMSService().addAuctionMedia(item);
		Items items = DataBase.getItems();
		Item returnItem = items.addItem(item);

		return Response.status(200).entity(returnItem).build();
	}

	@Override
	public Response updateItem(Long id, Item item, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		return null;
	}

	@Override
	public Response deleteItem(Long id, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		new CMSService().deleteMedia(id);
		return null;
	}

	@Override
	public Response placeBid(Bid bid, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		return null;
	}

	@Override
	public Response getBids(Long id, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		return null;
	}
	
	
}