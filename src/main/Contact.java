package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Contact {
	ArrayList<Wish> wishlist;
	private ArrayList<Event> events;
	private String contactN;
	private Commands command;
	/**making a contact object.
	 * 
	 * @param contactN
	 */
	public Contact(String contactN) {
		wishlist = new ArrayList<>();
		events = new ArrayList<>();
		setContactN(contactN);
		command = new Commands();
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
	 * print the List of interests of the contact
	 * @throws IOException 
	 */
	public void getInterestsList() throws IOException {
		if (wishlist.size()==0) {
			System.out.println("There is no Interest to modify !");
			command.modifyContactMsg();
			}
			System.out.println("Write the number of the Interest you want to delete:");
		for (int i=0; i<wishlist.size(); i++) {
			Wish wish= wishlist.get(i);
			System.out.println(i+1 +" - "+ wish.getWishName()+" - Price: "+wish.getWishPrice());
		}
	}
	
	public void removeInterest(int index) {
		wishlist.remove(index);
	}
	/**
	 * returns contacts details without the index number.
	 */
	public void getContactDetails(){
		System.out.println("Contact: "+contactN);
		if (wishlist.size()==0) {
			System.out.println("No interests exist for this contact.");
		}
		for (Wish wish : wishlist) {
			System.out.println(wish.getWishDetails());
		}
		if (events.size()==0) {
			System.out.println("No events exist for this contact.");
		}
		for(Event event:events){
			System.out.println(event.getEventDetails());
		}
	}
	
	/**
	 * returns contacts details with the index number beside them.
	 */
	public void getContactDetails2(){
		System.out.println("Contact: "+contactN);
		if (wishlist.size()==0) {
			System.out.println("No interests exist for this contact.\n");
		}
		for (int i=0; i<wishlist.size(); i++) {
			Wish wish = wishlist.get(i);
			System.out.println(i+1 +" - "+ wish.getWishDetails());
		}
		if (events.size()==0) {
			System.out.println("No events exist for this contact.\n");
		}
		for (int i=0; i<events.size(); i++) {
			Event event = events.get(i);
			System.out.println(i+1 +" - "+ event.getEventDetails());
		}
	}
}

