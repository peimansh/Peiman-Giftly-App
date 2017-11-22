package main;

	/**
	 * Reminder that calculates if an event is due to in next 24 hours
	 * 24 hours are calculated and converted into milliseconds.
	 */
	public class Reminder {
	  private long l;
	  
	  public Reminder(long l) {
		  
	   this.l = l; 
	  }
	  
	  public boolean remind(){
	  if(l<= 86400000 && l>= -86400000) {
	    	return true;
	    }
	  return false;
	  }
}
