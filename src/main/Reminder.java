package main;


	import java.awt.Toolkit;
	import java.util.Timer;
	import java.util.TimerTask;

	/**
	 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
	 * seconds have passed.
	 */
	public class Reminder {
	  Toolkit toolkit;
	  Contact contact;
	  Timer timer;

	  private long timediff;
	  
	  public Reminder(long l) {
		  /* toolkit = Toolkit.getDefaultToolkit();
	    timer = new Timer();
	    timer.schedule(new RemindTask(), l);
	    */
	   timediff = l; 
	    
	  }
	  public boolean remid(){
	  if(timediff<86400000) {
	    	return true;
	    }
	  return false;
	  }
	  /*
	  class RemindTask extends TimerTask {
	    public void run() {
	      contact.getRandomInterest();
	      toolkit.beep();
	      timer.cancel(); //Not necessary because we call System.exit
	    }}*/
	  
	  
	  

	 
	  {
	}
}
