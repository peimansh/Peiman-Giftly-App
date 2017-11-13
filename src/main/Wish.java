package main;

public class Wish {
	private String wishname;
	private int wishprice;
	
	public Wish(String wishname, int wishprice) {
		this.wishname=wishname;
		this.wishprice = wishprice;
	}
	
	public String getWishDetails( ) {
		return ("The "+wishname+" costs "+wishprice+".");
	}
	
	public int getWishPrice() {
		return wishprice;
	}
	
	public String getWishName( ) {
		return wishname;
	}
		
}
