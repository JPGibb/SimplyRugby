package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;

//This extends the member Class meaning that it inherits all the public/ protected methods and attributes of the Member class
public class Player extends Member {
	
	//ArrayList of type SkillCategory will be used to store the skill categories for the players skills
	//private means that the attribute will not be accessible from outside an instance of this class
	private ArrayList<SkillCategory> skillCategories = new ArrayList<SkillCategory>();
	protected int sru;
	
	
	//Default Constructor
	public Player(){
		
	}
	
	//Constructor, is called when the class is instanciated
	public Player(String fn, String sn, int s, String d) {
		
		//uses the passed parameters to assign values to the Players details
		firstname = fn;
		surname = sn;
		sru = s;
		
		//Take the input String representation of the Players date of birth 
		//and parse it into a LocalDate representation
		dob = LocalDate.parse(d);
		//Calls the generateSkill() method
		generateSkills();
	}
	
	//updateSkillRecord method will update the skillCatergories ArrayList with the new up to date information
	//Takes the new skill data as parameters
	public void updateSkillRecord(SkillCategory passing, SkillCategory tackling, SkillCategory kicking) {
		
		//Will clear the skillCatergories ArrayList of all values
		skillCategories.clear();
		
		//Adds the new skills details to the skillCatergories ArrayList
		skillCategories.add(passing);
		skillCategories.add(tackling);
		skillCategories.add(kicking);

//		System.out.println(skillCatergories.get(0).getSkillsAsString());
//		System.out.println(skillCatergories.get(1).getSkillsAsString());
//		System.out.println(skillCatergories.get(2).getSkillsAsString());
	}
	
	//getSru returns the Players sru number as an int
	public int getSru() {
		return sru;
	}
	
	//getSkillCategories returns the skillCategories ArrayList
	public ArrayList<SkillCategory> getSkillCategories(){
		return skillCategories;
	}
	
	//generateSkills method will generate skills for the player, this is called when the constructor is called
	//and generates placeholder data
	protected void generateSkills() {
		
		//Creates an ArrayList of type Skill that will be used to store the skills before they are 
		//passed the relevant category's constructor
		ArrayList<Skill> s = new ArrayList<Skill>();
		//Create passing skills
		s.add(new Skill("Standard", 1));
		s.add(new Skill("Spin", 1));
		s.add(new Skill("Pop", 1));
		
		SkillCategory passing = new SkillCategory("Passing", "", s);
		
		System.out.println(passing.getSkillsAsString());

		//Clears all the data in the s ArrayList
		s.clear();
		
		//Create Tackling skills
		s.add(new Skill("Front", 1));
		s.add(new Skill("Rear", 1));
		s.add(new Skill("Side", 1));
		s.add(new Skill("Scrabble", 1));
		SkillCategory tackling = new SkillCategory("Tackling", "", s);
		
		System.out.println(tackling.getSkillsAsString());
		
		//Clears all the data in the s ArrayList
		s.clear();
		
		//Create Kicking skills
		s.add(new Skill("Drop", 1));
		s.add(new Skill("Punt", 1));
		s.add(new Skill("Grubber", 1));
		s.add(new Skill("Goal", 1));
		SkillCategory kicking = new SkillCategory("Kicking", "", s);
		
		System.out.println(kicking.getSkillsAsString());
		
		//Clears all the data in the s ArrayList
		s.clear();
		updateSkillRecord(passing, tackling, kicking);
	}
	
	//getDetails returns the players details as a String
	public String getDetails() {
		return "Player SRU: " + sru + "\nPlayer Name: " + firstname + " " + surname + "\nDate of Birth: " + dob;
	}
}
