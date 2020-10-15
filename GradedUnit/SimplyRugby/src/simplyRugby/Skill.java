package simplyRugby;

public class Skill {


	//Creates a private attribute of the type SkillNames
	//This means that only the values specified in the enum declaration can be stored here.
	private SkillNames skillName;
	
	//rating is the skill rating
	private int rating;
	
	//Constructor method is called when an instance of the class is created
	public Skill(String name, int r){
		
		//Sets the skillName variable to the value of the name parameter 
		//by converting the String value to its representation in the SkillNames enum
		//If the value of name is not declared in the SkillNames enum an IllegalArgumnetException will be thrown
		try{
			skillName = SkillNames.valueOf(name);
		}catch(IllegalArgumentException e) {
			System.out.println("Value: " + name + " is not declared in the SkillNames enum");
		}
		//Sets rating to the value of r
		rating = r;
	}
	
	//getName method returns the name of the skill as a string
	public String getName() {
		return skillName.name();
	}
	
	//setRating method will set the value of rating to the passed parameter 
	public void setRating(int r) {
		rating = r;
	}
	
	//getRating returns rating as an int
	public int getRating() {
		return rating;
	}
	
	//getDetails will return the name and rating of the skill as a String
	public String getDetails() {
		return "Skill name: " + skillName + "\nRating: " + rating;
	}
}
