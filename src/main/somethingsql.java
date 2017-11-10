package main;

import java.sql.*;
public class somethingsql {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/afs/kth.se/home/tmp/1016/tmp-sda-1130/Desktop/pemidb.db");
			System.out.println("Database Opened");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
