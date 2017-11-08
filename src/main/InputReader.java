package main;

import java.util.Scanner;

public class InputReader {
	private Scanner reader;
	
	public InputReader() {
		reader = new Scanner(System.in);
	}
	
	public void welcomeMsg() {
		System.out.println("Welcome to the Gift Management app - Giftly .");
		System.out.println("This App let's you add your loved ones as contacts to the app and add ");
		System.out.println("the items they like to have as wish list and add some important");
		System.out.println("dates like their birthday, anniversaries etc.. and receive suggestions ");
		System.out.println("so at the events you will receive a random suggestion to buy as a gift.");
		System.out.println("Use these numbers to begin :");
		System.out.println("1- Add a contact");
		System.out.println("2- Delete a contact");
		System.out.println("3- Show list of contacts");
		System.out.println("4- Quit");
	}
}
