package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

public class SkillCategory {
	
	//ArrayList of the skills in this category
	private ArrayList<Skill> skills;
	
	//training notes for this category
	private String notes;
	//Name of the category
	private String categoryName;
	
	//Constructor will be called when the class is created
	//takes name, notes and skills list as input
	public SkillCategory(String name, String n, ArrayList<Skill> s) {
		
		//Assigns the name and notes attributes the correct values
		categoryName = name;
		notes = n;
		
		//Creates a new ArrayList of type skill using the passed skill data
		skills = new ArrayList<Skill>(s);
	}	
	
	//getSkillsAsString returns all the skill details in this category as a String
	public String getSkillsAsString() {
		
		//Message variable stores the String that will be returned
		String message = "Skill catergory: " + categoryName + "\nNotes: " + notes + "\n";
		
		//Iterator will be used to iterate through the ArrayList
		Iterator<Skill> it = skills.iterator(); 
		Skill s = null;
		while(it.hasNext()) {
			s = it.next();
			
			//Add the details of the current skill to the message variable
			message += s.getDetails() + "\n";
		}		
		
		//return the message variable
		return message;
	}
	
	//getSkillByName will search for a skill by name and return it
	public Skill getSkillByName(String skillName) {
	
		Iterator<Skill> it = skills.iterator();
		while(it.hasNext()) {
			Skill skill = it.next();
			
			//If the desired skill is found
			if(skill.getName().equals(skillName)) {
				
				//return the skill
				return skill;
			}
		}
		
		//return null if the desired skill is not found
		return null;
	}
	
	//getName returns the name of the category
	public String getName() {
		return categoryName;
	}
	
	//getNotes returns the notes for the category
	public String getNotes() {
		return notes;
	}
}
