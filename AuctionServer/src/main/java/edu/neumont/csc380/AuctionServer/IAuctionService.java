package edu.neumont.csc380.AuctionServer;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.neumont.csc380.Database.Bid;
import edu.neumont.csc380.Database.Item;

@Path("/auctionServer")
public interface IAuctionService {
	
	@GET
	@Consumes("application/vnd.neumont.auction.edu-v1+json")
	@Path("/item/{itemId}")
	@Produces("application/json")
	Response getItem(@PathParam("itemId") Long id) throws Exception;
	
	@POST
	@Consumes("application/vnd.neumont.auction.edu-v1+json")
	@Path("/item")
	@Produces("application/json")
	Response createItem(Item item) throws Exception;
	
	@PUT
	@Consumes("application/vnd.neumont.auction.edu-v1+json")
	@Path("/item/{itemId}")
	@Produces("application/json")
	Response updateItem(@PathParam("itemId") Long id, Item item)  throws Exception;
	
	@DELETE
	@Consumes("application/vnd.neumont.auction.edu-v1+json")
	@Path("/item/{itemId}")
	Response deleteItem(@PathParam("itemId") Long id) throws Exception;
	
	@POST
	@Consumes("application/vnd.neumont.auction.edu-v1+json")
	@Path("/item/{itemId}/bid")
	@Produces("application/json")
	Response placeBid(Bid bid) throws Exception;
}

