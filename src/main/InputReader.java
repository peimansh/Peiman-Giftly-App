package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
	private Scanner reader;
	private CommandWords commands;
	private ArrayList<Contact> contacts;
	private ArrayList<Wishlist> wishlists;
	
	public InputReader() {
		reader = new Scanner(System.in);
		commands = new CommandWords();
	}
	
	public void welcomeMsg() throws IOException {
		boolean b = true;
		System.out.println("Welcome to the Gift Management app - Giftly .");
		System.out.println("This App let's you add your loved ones as contacts to the app and add ");
		System.out.println("the items they like to have as wish list and add some important");
		System.out.println("dates like their birthday, anniversaries etc.. and receive suggestions ");
		System.out.println("so at the events you will receive a random suggestion to buy something as a gift.");
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
                if (n>0&&n<7) {
                    b = false;
                    if(n==1){
                    	addcontactMsg() ;
                    }
                    else if(n==2){
                    	
                    }
                    else if(n==3){
                    	System.out.println("choose the song track that you want to delete"); 
                    	Scanner scanner = new Scanner(System.in); 
                    	 int N = scanner.nextInt(); 
                    	;
                    }
                    else if(n==4){
                    	;
                    }
                } else {
                    System.out.println(n + " Isn't a valid option... please enter a number between 1 and 5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 to 6 please...");    
            }
        }        
    }
			
	
	public void addcontactMsg() {
		System.out.println("Enter the name of the contact:");
		String contactN  = reader.nextLine();
		Contact contact = new Contact(contactN);
		contacts.add(contact);
		System.out.println("1-Enter the person interest\n2-Enter event for the person");
		boolean a = true;
		while (a) {
			try {
				int n = Integer.parseInt(reader.nextLine());
                if (n>0&&n<3) {
                    a = false;
                    if(n==1){
                    	System.out.println("Enter the description of the interest item");
                    	String wishname  = reader.nextLine();
                    	System.out.println("Enter the estimated price of the item");
                    	String price = reader.nextLine();
                    	int wishprice = Integer.parseInt(price);
                    	Wishlist wishlist = new Wishlist(wishname, wishprice);
                    	wishlists.add(wishlist);
                    }
                    else if(n==2){
                    	System.out.println("Enter the description of the event");
                    	String description = reader.nextLine();
                    	System.out.println("Enter the date of the event");
                    	String date = reader.nextLine();
                    	System.out.println("Enter the address of the event");
                    	String address = reader.nextLine();
                    }
                    else {
                    	System.out.println(n + " Isn't a valid option... please enter a number between 1 and 2");
                    	}    
                    }
			}
			catch (NumberFormatException e) {
                System.out.println("Enter a number between 1 to 2 please...");   
		}
	}
	}
}
