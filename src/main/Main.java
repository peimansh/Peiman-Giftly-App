package main;

public class Main {
	private ArrayList <Contact> contacts;
	
	public Main() {
		contacts = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	InputReader start = new InputReader();
	start.welcomeMsg();
	}
	
	public void addContact(String contactN) {
		contacts.add(contactN);
	}

}
