package main;

public class Wishlist {
	private String wishname;
	private int wishprice;
	
	public Wishlist(String wishname, int wishprice) {
		this.wishname=wishname;
		this.wishprice = wishprice;
	}
	
	public String getWishlistDetails( ) {
		return ("The "+wishname+" costs "+wishprice+".");
	}
	
	public int getWishPrice() {
		return wishprice;
	}
	
	public String getWishName( ) {
		return wishname;
	}
		
}
