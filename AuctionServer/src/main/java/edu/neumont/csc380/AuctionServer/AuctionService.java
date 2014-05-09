package edu.neumont.csc380.AuctionServer;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.Database.Bid;
import edu.neumont.csc380.Database.Bids;
import edu.neumont.csc380.Database.DataBase;
import edu.neumont.csc380.Database.Item;
import edu.neumont.csc380.Database.Items;
import edu.neumont.csc380.Exceptions.BidTooLowException;
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
		if (item.getId() != id) {
			throw new IdMismatchException();
		}
		new CMSService().addAuctionMedia(item);
		Items items = DataBase.getItems();
		items.deleteItem(item.getId());;
		Item returnItem = items.addItem(item);

		return Response.status(200).entity(returnItem).build();
	}

	@Override
	public Response deleteItem(Long id, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		new CMSService().deleteMedia(id);
		DataBase.getItems().deleteItem(id);
		return null;
	}

	@Override
	public Response placeBid(Bid bid, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		if ( bid.getAmt() <= 0 ){
			throw new BidTooLowException();
		}
		Items items = DataBase.getItems();
		if ( items.containsItem(bid.getItemId()) ) {
			Item item = items.getById(bid.getItemId());
			double highestBid = item.getHighestBid();
			if (highestBid >= bid.getAmt() || 
				item.getEndDate().before(new Date())) {
				throw new BidTooLowException();
			}
			DataBase.getBids().getBidsById(item.getId()).add(bid);
		}
		return Response.status(200).entity(bid).build();
	}

	@Override
	public Response getBids(Long id, String token) throws Exception {
		AuthenticationService auth = new AuthenticationService();
		if (!auth.verify(token)) {
			throw new TokenInvalidException();
		}
		List<Bid> itemsBids = DataBase.getBids().getBidsById(id);
		return Response.status(200).entity(itemsBids).build();
	}
	
	
}