package main;

public class Event {
	private String description;
	private String date;
	private String address;

	public Event (String description, String date, String address) {
		this.description = description;
		this.date = date;
		this.address = address;
	}
	
	public void getEventDetails() {
		/**
		 * Print the details of an event.
		 */
		System.out.println ("The event : "+description+" will be on : "+date+" and the address is : "+address+".");
	}
	
	public void changeDescription(String newdescription) {
		this.description = newdescription;
	}
	
	public void changeDate(String newdate) {
		this.date = newdate;
	}
	
	public void changeAddress(String newaddress) {
		this.address = newaddress;
	}
}


