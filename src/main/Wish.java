package main;

import java.io.Serializable;

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
