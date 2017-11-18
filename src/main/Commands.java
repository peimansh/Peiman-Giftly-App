package main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		System.out.println("2- Modify a contact");
		System.out.println("3- Delete a contact");
		System.out.println("4- Show list of contacts");
		System.out.println("5- Save the info to a file");
		System.out.println("6- Load the info from file");
		System.out.println("7- Quit");
		while (b) {
			try {
				int readerInt = Integer.parseInt(reader.nextLine());
				if (readerInt>0 && readerInt<8) {
					b = false;
					if(readerInt==1){
						addContactMsg() ;
					}
					else if(readerInt==2){
						modifyContactMsg();
					}
					else if(readerInt==3){
						deleteContactMsg();
					}
					else if(readerInt==4){
						listOfContactsMsg();
					}
					else if(readerInt==5) {
						
					}
				}
				else {
					System.out.println(readerInt + " Isn't a valid option... please enter a number between 1 and 7");
				}
				} catch (NumberFormatException e) {
					System.out.println("Enter a number between 1 to 7 please...");
					anotherWelcomeMsg();
				}
		}        
    
	}

	public void addContactMsg() throws IOException {
		Date date = null;
		System.out.println("Enter the name of the contact:");
		String contactN = reader.nextLine().trim();
		contact = new Contact(contactN);
		contacts.add(contact);
		boolean a = true;
			while (a) {
						System.out.println("1-Add an interest for the person\n2-Add an event for the person");
				try {
					int readerInt = Integer.parseInt(reader.nextLine());
					if (readerInt>0 && readerInt<3) {
                    a = true;
                    if (readerInt==1) {
                    	System.out.println("Enter the description of the interest item:");
                    	String wishname  = reader.nextLine();
                    	System.out.println("Enter the estimated price of the item:");
                    	String price = reader.nextLine();
                    	int wishprice = Integer.parseInt(price);
                    	contact.addWish(wishname, wishprice);
                    	System.out.println("Interest successfully added for the contact");
                    	System.out.println("Do you want to add another Interest or Event for the contact? Y/N");
                    	String s = reader.nextLine().trim().toLowerCase();
                    		if (s.equals("y")) {
                    			a = true;
                    			continue;
                    		}else if(s.equals("n")) {
                    			a = true;
                    			printL();
                    			anotherWelcomeMsg();
                    			break;
                    	}
                    	}
                    	}
                	if(readerInt==2){
                    	System.out.println("Enter the description of the event");
                    	String description = reader.nextLine();
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
                    	String s = reader.nextLine().trim().toLowerCase();
                    		if (s.equals("y")) {
                    			a = true;
                    			continue;
                    		}else if(s.equals("n")) {
                    			a = true;
                    			printL();
                    			anotherWelcomeMsg();
                    			break;
                    		}
                	}
				}	
                    
			
					catch (NumberFormatException e) {
						System.out.println("isn't a valid option. Please enter a number between 1 and 2 ...");   
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
			}
			try {
				int input = Integer.parseInt(reader.nextLine());
				contacts.remove(input-1);
				System.out.println("Contact successfully removed.");
				anotherWelcomeMsg();
			}
			catch (NumberFormatException e) {
			System.out.println(" isn't a valid option. Please enter a valid number ...");
		}
	}
	
	public void modifyContactMsg() throws IOException {
			if (contacts.size()==0) {
			System.out.println("There is no contact to modify !");
			anotherWelcomeMsg();
			}
			System.out.println("Write the number of the contact you want to modify:");
			for (int i=0; i<contacts.size(); i++) {
				Contact contact= contacts.get(i);
				System.out.println(i+1 +" - "+ contact.getContactN());
			}
			int input = Integer.parseInt(reader.nextLine());
			boolean x = true;
			while (x) {
				try {
					boolean c = true;
					while (c) {
						System.out.println("What do you want to do with this contact ?");
						System.out.println("1- Change name of the contact\n2- Modify Interests\n3- Modify Events\n4- Go to main page");
						c = false;
					int readerInt = Integer.parseInt(reader.nextLine());
					switch(readerInt) {
					case 1: {
						System.out.println("Enter the new name:");
						String temp = reader.nextLine().trim();
						contacts.get(input-1).setContactN(temp);
						System.out.println("Contact name successfully changed.\nDo you want to further modify the contact? Y/N");
						String s1 = reader.nextLine().trim().toLowerCase();
                		if (s1.equals("y")) {
                			c = true;
                			break;
                		}else if(s1.equals("n")) {
                			c = false;
                			anotherWelcomeMsg();
                			break;
                		}
					}
                	case 2: {
                		if(contacts.get(input-1).wishlist.size() == 0) {
                			System.out.println("There is no interest to modify !");
                			break;
                		}
                		System.out.println("Which Interest do you want to delete?");
                		contacts.get(input-1).getInterestsList();
                		int readerInt2 = Integer.parseInt(reader.nextLine());
                		contacts.get(input-1).removeInterest(readerInt2-1);
                		System.out.println("Interest successfully removed.\nDo you want to further modify the contact? Y/N");
                		String s2 = reader.nextLine().trim().toLowerCase();
                		if (s2.equals("y")) {
                			c = true;
                			break;
                		}else if(s2.equals("n")) {
                			c = false;
                			modifyContactMsg();
                			break;
                		}
                	}
                	case 3: {
                		if(contacts.get(input-1).events.size() == 0) {
                			System.out.println("There is no event to modify !");
                			break;
                		}
                		System.out.println("Which Event do you want to delete?");
                		contacts.get(input-1).getEventList();
                		int readerInt2 = Integer.parseInt(reader.nextLine());
                		contacts.get(input-1).removeEvent(readerInt2-1);
                		System.out.println("Event successfully removed.\nDo you want to further modify the contact? Y/N");
                		String s2 = reader.nextLine().trim().toLowerCase();
                		if (s2.equals("y")) {
                			c = true;
                			break;
                		}else if(s2.equals("n")) {
                			c = false;
                			modifyContactMsg();
                			break;
                		}
                	}
                	case 4: {
                		anotherWelcomeMsg();
                		break;
                	}
                	default: {
                		c = true;
                		System.out.println("You enetered an invalid command.");
                		break;
                	}
					}
					}
				}catch (NumberFormatException e) {
					System.out.println(" isn't a valid option. Please enter a valid number ...");
			}
			}
	}
	
	public void listOfContactsMsg() throws IOException {
		if (contacts.size()==0) {
			System.out.println("There is no contact to show !");
			anotherWelcomeMsg();
			}
		System.out.println("1- Show details of all contacts\n2- Show details of a specific contact\n3- Show number of contacts\n4- Go to the main page");
		int readerInt = Integer.parseInt(reader.nextLine().trim());
		switch(readerInt) {
		case 1: {
			printL2();
			listOfContactsMsg();
			break;
		}
		case 2: {
			System.out.println("Write the number of the contact to show details");
			listOfContactN();
			int readerInt2 = Integer.parseInt(reader.nextLine().trim());
			contacts.get(readerInt2-1).getContactDetail();
			listOfContactsMsg();
			break;
		}
		case 3: {
			System.out.println("Total : "+numberOfContacts());
			listOfContactsMsg();
			break;
		}
		case 4: {
			anotherWelcomeMsg();
			break;
		}
		default : {
			System.out.println("You enetered an invalid command.");
    		listOfContactsMsg();
			break;
		}
		}
	}

	public void testWish() {
		Wish w = new Wish("dashagh", 20);
		System.out.println(w.getWishDetails());
	}
	
	public int numberOfContacts() {
		return contacts.size();
	}
	
	public void listOfContactN() {
		for (int i=0; i<contacts.size(); i++) {
			Contact contact = contacts.get(i);
			System.out.println(i+1 +" - "+ contact.getContactN());
		}
	}
	
	public void printL(){
		for (Contact contact : contacts) {
			contact.getContactsDetails2();
		}
	}
		
	public void printL2(){
		for (Contact contact : contacts) {
			contact.getContactsDetails();
		}
		System.out.println(numberOfContacts()+" contacts found");
		}
}