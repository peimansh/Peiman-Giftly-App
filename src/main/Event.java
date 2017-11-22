package main;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Pemi
 *This class defines an event for a contact.
 *it contains description, date of event ( it uses the default 00:00:00 as time for the event) , and address ( which is
 *just an info about the event, will be used for future features).
 */
public class Event implements Serializable {
	private String description;
	private Date date;
	private String address;
	private long currentdate;
	
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

	public String getDescription(  ) {
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
		return ("The event : \""+description+"\" is on : "+date+" and the address is : \""+address+"\"");
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
	
	/**
	 * gets the difference between current date of machine and the given date
	 * it will be used to check if there exists an event in the next 24 hours.
	 */
	public long getDateDifference() {
		currentdate = System.currentTimeMillis();
		long difference = (currentdate - date.getTime());
		return difference;
	}
	
	/**
	 * boolean which returns true only if the date of the event is in the range of today or next 24 hours.
	 */
	public boolean getReminder() {
		Reminder reminder = new Reminder(getDateDifference());
		return reminder.remind();
	}
}