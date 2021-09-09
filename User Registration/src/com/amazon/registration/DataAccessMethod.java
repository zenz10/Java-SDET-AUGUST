package com.amazon.registration;

public interface DataAccessMethod {

	public void createRecord(); //Create New Resource
	public void retrieveRecord();	// Getting a record from data source
	public void retrieveAllRecords(); // Getting a record from data source
	public void updateRecord(); // Updates record
	public void deleteRecord(); // Delete record
	
}
