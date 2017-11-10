package main;

public class CommandWords {
	private static final int[] validCommands = new int[] {1,2,3,4};
	
	public CommandWords() {
		
	}
	
	public boolean isCommand(int intx) {
		for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i] == intx) 
                return true;
        }
        return false;
	}
	
	public void showAll() 
    {
        for(int command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
