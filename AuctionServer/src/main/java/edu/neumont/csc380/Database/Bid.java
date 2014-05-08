package edu.neumont.csc380.Database;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bid")
public class Bid {

	String amt;
	int ownerId;
	int itemId;
	Timestamp created;
	
}
