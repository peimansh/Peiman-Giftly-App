package main;

import java.io.Serializable;
/**
 * 
 * @author Pemi
 * This class represents interests of a contact
 * it contains a description and an estimated price for the interest
 */
public class Wish implements Serializable {
	private String wishname;
	private int wishprice;

	public Wish(String wishname, int wishprice) {
		this.wishname=wishname;
		this.wishprice = wishprice;
	}

	public String getWishDetails() {
		return ("Likes to have \""+wishname+"\" and it costs around "+wishprice+".");
	}

	public int getWishPrice() {
		return wishprice;
	}

	public String getWishName() {
		return wishname;
	}
}
