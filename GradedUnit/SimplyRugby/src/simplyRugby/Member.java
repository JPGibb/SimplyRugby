package simplyRugby;

import java.time.LocalDate;
import java.util.Date; 

//Member class
public class Member {
	
	//Delcares Strings that will be used to store the firstname and surname of the member
	//protected means that these attributes will be accessible to any sub-classes
	protected String firstname;
	protected String surname;
	
	//LocalDate object will be used to store the date of birth of the member =
	protected LocalDate dob;
	
	//Default constructor
	public Member() {
		
	}
	
	//getName will return the firstname and surname of the member
	public String getName() {
		return firstname + " " + surname;
	}
	
	//getFirstname will return the firstname of the 
	public String getFirstname() {
		return firstname;
	}
	
	//Returns the surname of the member
	public String getSurname() {
		return surname;
	}
}
