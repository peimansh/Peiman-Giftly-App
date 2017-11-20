package main;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;


public class Event implements Serializable {
	private String description;
	private Date date;
	private String address;
	private Date currentdate;
	private Toolkit toolkit;
	private Timer timer;

	public Event (String description, Date date, String address) {
		setDetails(description, date, address);
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
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
		return ("The event : ("+description+") is on : "+date+" and the address is : "+address+".");
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
	
	public long getDateDifference(Date date) {
		this.date = date;
		long difference = (date.getTime()- currentdate.getTime())/1000;
		return difference;
	}
	
	//public getReminder
}