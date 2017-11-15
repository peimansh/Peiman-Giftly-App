package main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Commands {
	private Scanner reader;
	private Contact contact;
	private ArrayList<Contact> contacts;

	public Commands() {
		contacts = new ArrayList<>();
    	reader = new Scanner(System.in);
	}
	public void welcomeMsg() throws IOException {
		
		System.out.println("Welcome to the Gift Management app \"Giftly\" .");
		System.out.println("This App let's you add your loved ones as contacts to the application and add ");
		System.out.println("the items they like to have as wish list and add some important");
		System.out.println("dates like their birthday, anniversaries etc.. and receive suggestions ");
		System.out.println("so at the events you will receive a random suggestion to buy something as a gift.");
		anotherWelcomeMsg();
	}
	public void anotherWelcomeMsg() throws IOException{
		
		boolean b = true;
		System.out.println("Use these numbers to begin :");
		System.out.println("1- Add a contact");
		System.out.println("2- Delete a contact");
		System.out.println("3- Show list of contacts");
		System.out.println("4- Save the info to a file");
		System.out.println("5- Load the info from file");
		System.out.println("6- Quit");
		while (b) {
			try {

				int n = Integer.parseInt(reader.nextLine());
				if (n>0 && n<7) {
					b = false;
					if(n==1){
						addContactMsg() ;
					}
					else if(n==2){
						deleteContactMsg();
					}
					else if(n==3){

						;
					}
					else if(n==4){
						;
					}
				}
				} catch (NumberFormatException e) {
				System.out.println("Enter a 1number between 1 to 6 please...");    
				}
		}        
    
}

	public void addContactMsg() throws IOException {
		Date date = null;
		System.out.println("Enter the name of the contact:");
		String contactN = reader.nextLine();
		contact = new Contact(contactN);
		contacts.add(contact);
		boolean a = true;
		while (a) {
			System.out.println("1-Add an interest for the person\n2-Add an event for the person");
			try {
				int n = Integer.parseInt(reader.nextLine());
                if (n>0&&n<3) {
                    a = true;
                    if(n==1){
                    	System.out.println("Enter the description of the interest item");
                    	String wishname  = reader.nextLine();
                    	System.out.println("Enter the estimated price of the item");
                    	String price = reader.nextLine();
                    	int wishprice = Integer.parseInt(price);
                    	contact.addWish(wishname, wishprice);
                    	System.out.println("Interest successfully added for the contact");
                    	System.out.println("Do you want to add another Interest or Event for the contact? Y/N");
                    	String s = reader.nextLine().toLowerCase();
                    		if (s.equals("y")) {
                    			a = true;
                    			continue;
                    		}else{
                    			a = false;
                    			printL();
                    			anotherWelcomeMsg();
                    	}
                    	}
                    	}
                	if(n==2){
                    	System.out.println("Enter the description of the event");
                    	String description = reader.nextLine();
                    	System.out.println("Enter the date of the event");
                    	SimpleDateFormat mydateformat = new SimpleDateFormat("dd MM yyyy");
                        try {
                            System.out.println("Enter the date of the event (dd mm yyyy):");
                            String date1 = reader.nextLine();
                            date = mydateformat.parse(date1);
                            
                        	} catch (ParseException e) {
                            e.printStackTrace();
                        	}
                    	System.out.println("Enter the address of the event");
                    	String address = reader.nextLine();
                    	contact.addEvent(description, date, address);
                    	System.out.println("Event successfully added for the contact");
                    	System.out.println("Do you want to add another Interest or Event for the contact? Y/N");
                    	String s = reader.nextLine().toLowerCase();
                    	if (s.equals("y")) {
                    		a = true;
                    	}else{
                    		a = false;
                    		printL();
                    		anotherWelcomeMsg();
                    	}
                    	}
                    	else {
                    	System.out.println(n + " Isn't a valid option... please enter a number between 1 and 2");
                    	}    
                    }
			
				catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 to 2 please...");   
		}
		}
	}
	
	public void deleteContactMsg() throws IOException {
		if (contacts.size()==0) {
			System.out.println("There is no contact to delete !");
			anotherWelcomeMsg();
		}
		System.out.println("Write the number of the contact you want to delete:");
		for (int i=0; i<contacts.size(); i++) {
			Contact contact= contacts.get(i);
			System.out.println(i+1 +" - "+ contact.getContactN());
			int input = (reader.nextInt());
			contacts.remove(input-1);
			System.out.println("Contact successfully removed.");
			anotherWelcomeMsg();
		}
	}
	
	public void testWish() {
		Wish w = new Wish("kire boz", 20);
		System.out.println(w.getWishDetails());
	}
	public void printL(){
		for (Contact contact : contacts) {
			contact.getContactDetails2();
		}
	}
}