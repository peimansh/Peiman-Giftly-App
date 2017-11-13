package main;

import java.util.ArrayList;

public class Contact {
	private ArrayList<Wish> wishlists;
	private ArrayList<Event> events;
	private String contactN;
	/**making a contact object.
	 * 
	 * @param contactN
	 */
	public Contact(String contactN) {
		wishlists = new ArrayList<>();
		events = new ArrayList<>();
		this.contactN = contactN;
	}
	
	public void addWish(String wishname, int wishprice) {
		this.wishlists.add(new Wish(wishname,wishprice));
	}
	
	public void addEvent(String description, String date, String address) {
		this.events.add(new Event(description, date, address));
	}
	
	
	/**
	 * Enter the contact into the program
	 */
}
