package main;

import java.io.IOException;

public class Main {

	private static Commands command;

	public Main() {
	}

	/**
	 * This is the main method.
	 * And will start the program.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		command = new Commands();
		command.welcomeMsg();
	}

}
