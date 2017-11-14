package main;

import java.util.Date;

public class Event {
	private String description;
	private Date date;
	private String address;

	public Event (String description, Date date, String address) {
		setDetails(description, date, address);
	}
	
	public void setDetails(String description, Date date, String address) {
		this.description = description;
		this.date = date;
		this.address = address;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public String getAddress() {
		return address;
	}

	public String getEventDetails() {
		/**
		 * Print the details of an event.
		 */
		return ("The event : "+description+" will be on : "+date+" and the address is : "+address+".");
	}
	
	
	
	public void changeDescription(String newdescription) {
		this.description = newdescription;
	}
	
	public void changeDate(Date newdate) {
		this.date = newdate;
	}
	
	public void changeAddress(String newaddress) {
		this.address = newaddress;
	}
}


