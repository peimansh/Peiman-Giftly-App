package main;

import java.io.IOException;


public class InputReader {
	private Commands command;
	
	public InputReader() {
		command = new Commands();
	}
	
	public void welcome() throws IOException {
		command.welcomeMsg();
	}
}
