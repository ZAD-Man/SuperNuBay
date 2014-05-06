package edu.neumont.csc380.Database;

public enum Status {

	READY,		//On Create
	WAIT,		//Biding is paused or otherwise not ready
	COMPLETE;	//Item has been shipped, feedback has been given
}
