package main;

import java.util.ArrayList;
import java.util.Date;

public class Contact {
	private ArrayList<Wish> wishlist;
	private ArrayList<Event> events;
	private String contactN;
	/**making a contact object.
	 * 
	 * @param contactN
	 */
	public Contact(String contactN) {
		wishlist = new ArrayList<>();
		events = new ArrayList<>();
		setContactN(contactN);
	}
	
	public void addWish(String wishname, int wishprice) {
		this.wishlist.add(new Wish(wishname,wishprice));
	}
	
	public void addEvent(String description, Date date, String address) {
		this.events.add(new Event(description, date, address));
	}

	public String getContactN() {
		return contactN;
	}

	public void setContactN(String contactN) {
		this.contactN = contactN;
	}
	
	public Wish print(int i){
		return wishlist.get(i);
	}
	/**
	 * Enter the contact into the program
	 */
	public void getContactDetails(){
		System.out.println(contactN);
		for (Wish wish : wishlist) {
			System.out.println(wish.getWishDetails());
		}
		for(Event event:events){
			System.out.println(event.getEventDetails());
		}
		
	}
	
}
