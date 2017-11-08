package main;

public class Wishlist {
	private String wishname;
	private int wishprice;
	
	public Wishlist(String wishname, int wishprice) {
		this.wishname=wishname;
		this.wishprice = wishprice;
	}
	
	public void getWishlistDetails( ) {
		System.out.println("The "+wishname+" costs "+wishprice+".");
	}
		
}
