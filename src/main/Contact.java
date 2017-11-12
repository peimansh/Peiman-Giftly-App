package main;

import java.util.ArrayList;

public class Contact {
	private ArrayList<Wishlist> wishlists;
	private ArrayList<Event> events;
	private String contactN;
	/**making a contact object.
	 * 
	 * @param contactN
	 */
	public Contact(String contactN, Wishlist wish, Event event) {
		wishlists = new ArrayList<>();
		events = new ArrayList<>();
		this.contactN = contactN;
	}
	
	public String getContactName() {
		return contactN;
	}
	
	
	/**
	 * Enter the contact into the program
	 */
}
