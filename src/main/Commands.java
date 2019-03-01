package main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;

/**
 * 
 * @author Pemi
 *This class contains all the commands to interact with the user
 *it is used to get the input from the user to create, manage, modify, check the status of the events, get a suggestion
 *without the event being in the next 24 hours etc..
 */
public class Commands implements Serializable {
	private Scanner reader;
	private Contact contact;
	private ArrayList<Contact> contacts;
	
	public Commands() {
		contacts = new ArrayList<>();
    	reader = new Scanner(System.in);
	}
	
	/**
	 * the main welcome screen with info about the app and some instruction
	 * this is only shown once when the app starts.
	 * @throws IOException
	 */
	public void welcomeMsg() throws IOException {	
		System.out.println("Welcome to the Gift Management app \"Giftly\" .");
		System.out.println("This App let's you add your loved ones as contacts to the application and add ");
		System.out.println("the items they like to have as wish list and add some important");
		System.out.println("dates like their birthday, anniversaries etc.. and receive suggestions ");
		System.out.println("so at the events you will receive a random suggestion to buy something as a gift.");
		anotherWelcomeMsg();
	}
	
	/**
	 * the main welcome screen which includes the main menu options
	 * @throws IOException
	 */
	public void anotherWelcomeMsg() throws IOException{	
		boolean b = true;
		System.out.println("Use these numbers to begin :");
		System.out.println("1- Add a contact");
		System.out.println("2- Modify a contact");
		System.out.println("3- Delete a contact");
		System.out.println("4- Show list of contacts");
		System.out.println("5- Get a random suggestor for a contact event");
		System.out.println("6- Search");
		System.out.println("7- Save the info to a file");
		System.out.println("8- Load the info from file");
		System.out.println("9- Check if events exist in the next 24 hours and get suggestion");
		System.out.println("10- Quit");
		
				while (b) {
			try {
				int readerInt = Integer.parseInt(reader.nextLine());
				if (readerInt>0 && readerInt<11) {
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
					else if(readerInt==5){
						randomSuggestorMsg();
					}
					else if(readerInt==6){
						searchContactMsg();
					}
					else if(readerInt==7){
						saveProcess();
					}
					else if(readerInt==8){
						loadProcess();
					}
					else if(readerInt==9){
						getReminderMsg();
					}
					else if(readerInt==10){
						System.exit(0);
					}
					
				}
				else {
					System.out.println(readerInt + " Isn't a valid option... please enter a number between 1 and 10");
				}
				} catch (NumberFormatException e) {
					System.out.println("Enter a number between 1 to 10 please...");
					anotherWelcomeMsg();
				}
		}        
	}

	//Method for adding contacts by getting the data from the user and input them into the app
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
                        	} 
                        catch (ParseException e) {
                            System.out.println("Please enter a valid date");
                        	continue;
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
	
	//Method for deleting a contact, first shows the list of all contacts and then the user can delete a specific contact
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
	
	//Method for modifying a contact, such as event edits or interests edits
	public void modifyContactMsg() throws IOException {
		Date date = null;	
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
						try {
							contacts.get(input-1);
						}
						catch (IndexOutOfBoundsException e) {
							System.out.println("You entered an invalid number");
							modifyContactMsg();
							break;
						}
						System.out.println("What do you want to do with this contact ?");
						System.out.println("1- Change name of the contact\n2- Add Interests\n3- Delete Interests\n4- Add Events\n5- Delete Events\n6- Go to Main page");
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
                		System.out.println("Enter the description of the interest item:");
                    	String wishname  = reader.nextLine();
                    	System.out.println("Enter the estimated price of the item:");
                    	String price = reader.nextLine();
                    	int wishprice = Integer.parseInt(price);
                    	contacts.get(input-1).addWish(wishname, wishprice);
                    	System.out.println("Interest successfully added for the contact");
                		System.out.println("Do you want to further modify this contact? Y/N");
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
                		if(contacts.get(input-1).wishlist.size() == 0) {
                			System.out.println("There is no interest to delete !");
                			break;
                		}
                		System.out.println("Which Interest do you want to delete?");
                		contacts.get(input-1).getInterestsList();
                		int readerInt2 = Integer.parseInt(reader.nextLine());
                		try {
                			contacts.get(input-1).removeInterest(readerInt2-1);
                		}
                		catch (IndexOutOfBoundsException e) {
                			System.out.println("Enter a valid number");
                			continue;
                		}
                		System.out.println("Interest successfully removed.\nDo you want to further modify this contact? Y/N");
                		String s21 = reader.nextLine().trim().toLowerCase();
                		if (s21.equals("y")) {
                			c = true;
                			break;
                		}else if(s21.equals("n")) {
                			c = false;
                			modifyContactMsg();
                			break;
                		}
                	}
                	case 4: {
                		System.out.println("Enter the description of the event");
                    	String description = reader.nextLine();
                    	SimpleDateFormat mydateformat = new SimpleDateFormat("dd MM yyyy");
                        try {
                            System.out.println("Enter the date of the event (dd mm yyyy):");
                            String date1 = reader.nextLine();
                            date = mydateformat.parse(date1);
                        	} 
                        catch (ParseException e) {
                            System.out.println("Please enter a valid date");
                        	continue;
                        	}
                    	System.out.println("Enter the address of the event");
                    	String address = reader.nextLine();
                    	contacts.get(input-1).addEvent(description, date, address);
                    	System.out.println("Event successfully added for the contact");
                    	System.out.println("Do you want to further modify this contact? Y/N");
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
                	case 5: {
                		if(contacts.get(input-1).events.size() == 0) {
                			System.out.println("There is no event to delete !");
                			break;
                		}
                		System.out.println("Which Event do you want to delete?");
                		contacts.get(input-1).getEventList();
                		int readerInt2 = Integer.parseInt(reader.nextLine());
                		try {
                			contacts.get(input-1).removeEvent(readerInt2-1);
                		}
                		catch (IndexOutOfBoundsException e) {
                			System.out.println("Enter a valid number");
                			continue;
                		}
                		System.out.println("Event successfully removed.\nDo you want to further modify this contact? Y/N");
                		String s21 = reader.nextLine().trim().toLowerCase();
                		if (s21.equals("y")) {
                			c = true;
                			break;
                		}else if(s21.equals("n")) {
                			c = false;
                			modifyContactMsg();
                			break;
                		}	
                	}
                	case 6: {
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
	
	//viewing list of all contacts
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
			try {
				contacts.get(readerInt2-1).getContactDetail();
				listOfContactsMsg();
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("You entered an invalid number");
				listOfContactsMsg();
			}
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
	
	//method for searching the contacts and viewing information about them
	public void searchContactMsg() throws IOException {
		System.out.println("Enter the name of the contact you want to search:");
		String search = reader.nextLine().trim();
		int i = 0;
		boolean a = true;
		while(i<contacts.size() && a) {
			String temp = contacts.get(i).getContactN();
			if(temp.contains(search)) {
				System.out.println(temp+"\n");
				a = false;
				System.out.println("Do you want to show the contact details ? Y/N");
				switch(reader.nextLine().trim().toLowerCase()) {
				case "y": {
					contacts.get(i).getContactsDetails2();
					anotherWelcomeMsg();
					break;
				}
				case "n": {
					anotherWelcomeMsg();
					break;
				}
				default : {
					a = true;
					System.out.println("Enter a valid command Y or N");
					continue;
				}
				}
			}
			i++;
		}
			System.out.println("No match found");
			anotherWelcomeMsg();
	}
	
	//Method for saving the data inserted by the user into a text file loadable by the app later
	public void saveProcess() throws IOException {
		try{
			FileOutputStream saveOut = new FileOutputStream("savedInfo");
	        ObjectOutputStream save = new ObjectOutputStream(saveOut);
	        save.writeObject(contacts);
	        save.close();
	        saveOut.close();
	        System.out.println("Contacts saved successfully");	           
            }
	        catch(IOException e) {
	           e.printStackTrace();
	        }
	        anotherWelcomeMsg();
	}
	
	//method for loading the saved file and data into the app again
	public void loadProcess() throws IOException {
		try{
	        FileInputStream loadIn = new FileInputStream("savedInfo");
	        ObjectInputStream load = new ObjectInputStream(loadIn);
	        try {
	             contacts = (ArrayList<Contact>) load.readObject();
	             load.close();
	             loadIn.close();
	             System.out.println("Contacts loaded successfully");
	             } catch (ClassNotFoundException e) { 
	                e.printStackTrace();
	                }
	             }
	        catch(IOException e){
	           e.printStackTrace();
	           }
	            anotherWelcomeMsg();
	}
	
	/**
	 * this method suggests randomly an interest from the user to be bought for an event
	 * @throws IOException
	 */
	public void randomSuggestorMsg() throws IOException {
		if (contacts.size()==0) {
			System.out.println("There is no contact stored in the app");
			anotherWelcomeMsg();
			}
		System.out.println("Write the number of the contact:");
		listOfContactN();
		int readerInt1 = Integer.parseInt(reader.nextLine().trim());
		try {
				contacts.get(readerInt1-1);
		}
		catch (IndexOutOfBoundsException e) {
								System.out.println("You entered an invalid number");
								randomSuggestorMsg();
		}
		if (contacts.get(readerInt1-1).wishlist.size()==0) {
			System.out.println("There is no interest added for this contact so , No Suggestion !");
			anotherWelcomeMsg();
		}
		if (contacts.get(readerInt1-1).events.size() !=0) {
			System.out.println("Write the number of the event that you want to get suggestion for:");
			contacts.get(readerInt1-1).getEventList();
			int readerInt2 = Integer.parseInt(reader.nextLine().trim());
			try {
				contacts.get(readerInt1-1).getEvent(readerInt2-1);
			}
			catch (IndexOutOfBoundsException e) {
									System.out.println("You entered an invalid number");
									randomSuggestorMsg();
			}
			contacts.get(readerInt1-1).getRandomInterest();
			System.out.println("Press any key to go the main page");
			reader.nextLine();
			anotherWelcomeMsg();
		}
		System.out.println("No events exist for this contact");
		anotherWelcomeMsg();
	}
	
	//Checking if an event exists in the next 24 hours or not
	public void getReminderMsg() throws IOException {
		if(contacts.size()==0) {
			System.out.println("There is no contact in the application!");
			anotherWelcomeMsg();
		}
		for (Contact contact:contacts) {
			contact.ifEvent24();
		}
		anotherWelcomeMsg();
	}

	public void testWish() {
		Wish w = new Wish("something", 20);
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
