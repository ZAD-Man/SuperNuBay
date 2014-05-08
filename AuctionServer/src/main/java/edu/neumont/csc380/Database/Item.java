package edu.neumont.csc380.Database;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Item {

	
	long id; 				//Unique identifier Body Long Always 
	String name; 			//Name of the item Body String Always
	String description; 	//Brief description of the item Body String Always
	double highestBid; 		//The current highest bid  Body Double Always
	
	Timestamp startDate; 	//When the item opens (or opened) for bid 
							//(not necessarily when the record was 
							//created) Body Timestamp Always 
	Timestamp endDate; 		//When the item closes (or closed) for bid 
							//Body Timestamp Always  

	Status status; 			//The status of the item Body Enum Always
	long   ownerId;			//The item owners ID
	String ownerLink; 		//The item owner Body Link Always
	String thumbnailLink; 	//A thumbnail image of the item Body Link Always
	String imageLink;	 	//The original image of the item Body Link Always
	String placeBidLink; 	//The link for placing a bid Body Link
							//if Non-Owner and the current date is greater than start date
	String editLink; 		//The link for editing an item Body Link
							//If Owner and the current date is less than the closed date
	String deleteLink; 		//The link for deleting an item Body Link 
							//if Owner and there are no bids on the item
	String historyLink; 	//The bid history Body Link 
							//If-Owner 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getHighestBid() {
		return highestBid;
	}
	public void setHighestBid(double highestBid) {
		this.highestBid = highestBid;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getOwnerLink() {
		return ownerLink;
	}
	public void setOwnerLink(String ownerLink) {
		this.ownerLink = ownerLink;
	}
	public String getThumbnailLink() {
		return thumbnailLink;
	}
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getPlaceBidLink() {
		return placeBidLink;
	}
	public void setPlaceBidLink(String placeBidLink) {
		this.placeBidLink = placeBidLink;
	}
	public String getEditLink() {
		return editLink;
	}
	public void setEditLink(String editLink) {
		this.editLink = editLink;
	}
	public String getDeleteLink() {
		return deleteLink;
	}
	public void setDeleteLink(String deleteLink) {
		this.deleteLink = deleteLink;
	}
	public String getHistoryLink() {
		return historyLink;
	}
	public void setHistoryLink(String historyLink) {
		this.historyLink = historyLink;
	}
	
	
}
