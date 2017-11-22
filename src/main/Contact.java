package main;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Pemi
 *The contact class contains an ArrayList of interests name wishlist, an ArrayList of events and name for the contact.
 */
public class Contact implements Serializable {
	ArrayList<Wish> wishlist;
	ArrayList<Event> events;
	private String contactN;
	private Random randomGenerator;
	
	/**making a contact object.
	 * 
	 * @param contactN : Contact Name
	 */
	public Contact(String contactN) {
		wishlist = new ArrayList<>();
		events = new ArrayList<>();
		setContactN(contactN);
		randomGenerator = new Random();
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
	
	public void getContactDetail() {
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
	 * print the List of interests of the contact
	 * @throws IOException 
	 */
	public void getInterestsList() {
		for (int i=0; i<wishlist.size(); i++) {
			Wish wish= wishlist.get(i);
			System.out.println(i+1 +" - "+ wish.getWishName()+" - Price: "+wish.getWishPrice());
		}
	}
	
	public void removeInterest(int index) {
		wishlist.remove(index);
	}
	
	public void removeEvent(int index) {
		events.remove(index);
	}
	
	public Event getEvent(int index) {
		return events.get(index);
	}
	
	public ArrayList<Event> getAllEvents() {
		return events;
	}
	
	public void getEventList () {
		for (int i=0; i<events.size(); i++) {
			Event event= events.get(i);
			System.out.println(i+1 +" - "+ event.getDescription()+" - Date: "+event.getDate()+" - Address: "+event.getAddress());
		}
	}
	
	/**
	 * returns contacts details without the index number.
	 */
	public void getContactsDetails(){
		System.out.println("Contact: "+contactN);
		if (wishlist.size()==0) {
			System.out.println("No interests exist for this contact.");
		}
		for (Wish wish : wishlist) {
			System.out.println(wish.getWishDetails());
		}
		if (events.size()==0) {
			System.out.println("No events exist for this contact.\n");
		}
		for(Event event:events){
			System.out.println(event.getEventDetails()+"\n");
		}
	}
	
	/**
	 * returns contacts details with the index number beside them.
	 * it is used when it is needed to show number of contacts near them 
	 * so the user can write the number of them for further modification and use
	 */
	public void getContactsDetails2(){
		System.out.println("Contact: "+contactN);
		if (wishlist.size()==0) {
			System.out.println("No interests exist for this contact.");
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
	
	/**
	 * this method handles the processes which are needed to determine if an event exists for today and
	 * next 24 hours or not.
	 * goes through all of the events of all of the contacts and will act depended on the situation .
	 */
	public void ifEvent24() {
		for (int i=0; i<events.size(); i++) {
			Event event= events.get(i);
			if (wishlist.size()==0 && events.size()!=0 && event.getReminder()) {
				System.out.println("There exists an event for the contact: \""+getContactN()+"\" but there are no interests added!");
				break;
			}
			if (event.getReminder() && wishlist.size()!=0) {
				System.out.println(event.getEventDetails());
				getRandomInterest();
				break;
			}
		}
	}
	
	/**
	 * randomly chooses in interest of the contact to make a random suggestion to the user
	 * based on the contact interests
	 */
	public void getRandomInterest() {
		int index = randomGenerator.nextInt(wishlist.size());
		System.out.println("Random Suggestor for \""+getContactN()+"\", suggests you to buy: "+wishlist.get(index).getWishName()+" and its estimated price is: "+wishlist.get(index).getWishPrice()+"\n");
	}
}