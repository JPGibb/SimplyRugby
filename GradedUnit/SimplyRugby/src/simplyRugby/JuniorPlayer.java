package simplyRugby;

import java.time.LocalDate;

//This extends the Player Class meaning that it inherits all the public/ protected methods and attributes of the Player class
public class JuniorPlayer extends Player{
	
	//Declares a String that will store the name of the Junior Players guardian
	private String guardian;
	
	//Constructor for the class will be called when an instance of the class is created
	public JuniorPlayer(String fn, String sn, String g, int s, String d) {
		//set personal details of the player to the passed parameters
		firstname = fn;
		surname = sn;
		sru = s;
		guardian = g;
		
		//Take the input String representation of the Players date of birth 
		//and parse it into a LocalDate representation
		dob = LocalDate.parse(d);
		
		//Generate Skill Data for this Player
		generateSkills();
	}
	
	//Returns the details of the player in a String format
	public String getDetails() {
		return "Player SRU: " + sru + "\nPlayer Name: " + firstname + " " + surname + "\nDate of Birth: " + dob + "\nGuardian: " + guardian;
	}
}
