package simplyRugby;

//Exception class defines an error that can be thrown else where in the project
//This will be used to handle the event that the program is unable to find player
public class UnfoundPlayer extends Exception {
	
	//Constructor method is called when the error is thrown
	public UnfoundPlayer() {
		
		//Outout a message to the console for debug purposes
		System.out.println("Undound Player Exception");;
	}
}
