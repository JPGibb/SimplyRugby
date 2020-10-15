package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller {
	
	//Creates an instance of the Model class called datModel, this will be used to store the data for the program
	private Model dataModel = new Model();
	
	//Constructor for the class, will be called when the class is instantiated
	public Controller() {
		//Calls the generateSquads method in the dataModel
		dataModel.generateSquads();
		
		//Calls the generatePlayers method in the dataModel
		dataModel.generatePlayers();
		
		//Calls the showMainMenu method
		showMainMenu();
	}
	
	//Show main menu method creates and displays an instance of the MainMenu class
	public void showMainMenu() {
		MainMenu mm = new MainMenu();
		
		//Sets the title of the window to Main Menu
		mm.setTitle("Main Menu");
		
		//Calls the set controller method and passes it a reference to this instance of the controller
		mm.setController(this);
		
		//Displays the main menu
		mm.setVisible(true);
	}
	
	//showViewSquads creates an instance of the ViewSquadDetails class and displays it
	public void showViewSquads() {
		ViewSquadDetails sd = new ViewSquadDetails();
		sd.setTitle("View Squad Details");
		sd.setController(this);
		sd.setVisible(true);
	}
	
	//showCreateSkilRecord creates and instance of the SkillRecordScreen and displays it
	public void showCreateSkillRecord() {
		SkillRecordScreen sr = new SkillRecordScreen();
		sr.setTitle("Create Skill Record");
		sr.setController(this);
		sr.setVisible(true);
	}
	
	//getPlayerBySru iterates through all the players in all the squads until it finds the player with the matching sru
	//returns a Player object and takes an int as input
	//The method will also throw an UnfoundPlayer exception if it cannot find a player with a matching sru
	private Player getPlayerBySru(int sru) throws UnfoundPlayer {
		
		//Creates an ArrayList of type Player and assigns it the value of what is returned from the dataModel.getAllPlayers call
		ArrayList<Player> players = dataModel.getAllPlayers();
		Player p = null;
		
		//Iterator will iterate through the players list
		Iterator<Player> it = players.iterator(); 
		while(it.hasNext()) {
			p = it.next();
			
			//if the sru of the current player equals the desired sru the player will be returned
			if(p.getSru() == sru) {
				return p;
			}
		}
		
		//If the desired player is not found throw a new UnfoundPlayer exception
		throw new UnfoundPlayer();
	}
	
	//getPlayerNameBySru will iterate through all the players in all the squads until it finds the player with the desired sru
	//returns the name of the player as a String
	//Throws an UnfoundPlayer exception
	public String getPlayerNameBySru(int sru) throws UnfoundPlayer {
		ArrayList<Player> players = dataModel.getAllPlayers();
		Player p = null;
		
		//Iterator will iterate through the players list
		Iterator<Player> it = players.iterator(); 
		while(it.hasNext()) {
			p = it.next();
			if(p.getSru() == sru) {
				//Returns the name of the player
				return p.getName();
			}
		}
		
		//Throw a new UnfoundPlayer exception
		throw new UnfoundPlayer();
	}
	
	
	//createNewSkillRecord will create a new skill record using the data passed to it
	//Returns if the creation was successful or not
	public boolean createNewSkillRecord(int playerSru, int standardLevel, int spinLevel, int popLevel, String passingNotes,
			int frontLevel, int rearLevel, int sideLevel, int scrabbleLevel, String tacklingNotes,
			int dropLevel, int puntLevel, int grubberLevel, int goalLevel, String kickingNotes) {
		
		//Ensures that no entered data is above the maximum limit
		if(standardLevel > 5 || spinLevel > 5 || popLevel > 5 || frontLevel > 5 || rearLevel > 5 || sideLevel > 5 ||
				scrabbleLevel > 5 || dropLevel > 5 || puntLevel > 5 || grubberLevel > 5 || goalLevel > 5) {
			return false;
		}
		//Ensures that no entered data is bellow the minimum limit
		else if(standardLevel < 0 || spinLevel < 0 || popLevel < 0 || frontLevel < 0 || rearLevel < 0 || sideLevel < 0 ||
				scrabbleLevel < 0 || dropLevel < 0 || puntLevel < 0 || grubberLevel < 0 || goalLevel < 0) {
			return false;
		}
		else { //If the passed data is valid the code in this block will run
			
			//Creates an ArrayList of type Skill that will store skills so they can be passed to their relevant skill category constructor
			ArrayList<Skill> s = new ArrayList<Skill>();
			//Create passing skills
			s.add(new Skill("Standard", standardLevel));
			s.add(new Skill("Spin", spinLevel));
			s.add(new Skill("Pop", popLevel));
			
			//Creates the passing skill category
			SkillCategory passing = new SkillCategory("Passing", passingNotes, s);
			System.out.println(passing.getSkillsAsString());
			
			//Will clear the array of all data items so that it can be reused 
			//to create the next skill category
			s.clear();
			
			//Create Tackling skills
			s.add(new Skill("Front", frontLevel));
			s.add(new Skill("Rear", rearLevel));
			s.add(new Skill("Side", sideLevel));
			s.add(new Skill("Scrabble", scrabbleLevel));
			SkillCategory tackling = new SkillCategory("Tackling", tacklingNotes, s);
			System.out.println(tackling.getSkillsAsString());
			s.clear();
			
			//Create Kicking skills
			s.add(new Skill("Drop", dropLevel));
			s.add(new Skill("Punt", puntLevel));
			s.add(new Skill("Grubber", grubberLevel));
			s.add(new Skill("Goal", goalLevel));
			SkillCategory kicking = new SkillCategory("Kicking", kickingNotes, s);
			System.out.println(kicking.getSkillsAsString());
			s.clear();
			
			//try catch block is used when code might throw an error, this will allow the error to be caught 
			//and handled as needed
			try {
				Player p = getPlayerBySru(playerSru);
				p.updateSkillRecord(passing, tackling, kicking);
				
			//Catch block will run if the error is encountered
			//In this case it is used to catch the UnfoundPlayer error
			}catch(UnfoundPlayer e) {
				System.out.println("unfound Player!");
				return false;
			}
			
			//return true as the skill record was successfully created
			return true;
		}
	}
	
	//getSkillRatingByName will return the level of the desired skill for the desired player
	public int getSkillRatingByName(int sru, String skillName) {
		int skillLevel = 0;
		
		//try catch block is used to handle errors that may be generated by this code
		try {
			
			//Will get the desired player using their sru
			Player p = getPlayerBySru(sru);
			
			//Gets the ArrayList skillCategories from the player object
			ArrayList<SkillCategory> skillCats = p.getSkillCategories();
			
			//Iterator will iterate through the skillCats ArrayList
			Iterator<SkillCategory> it = skillCats.iterator();
			while(it.hasNext()) {
				SkillCategory sc = it.next();
				
				//Will get the desired skill from the current SkillCategory being searched,
				//if the current SkillCategory does not contain the desire skill null will be returned
				Skill skill = sc.getSkillByName(skillName);
				
				//If the desired skill has been found
				if(skill != null) {
					
					//Return skill level of the skill
					return skill.getRating();
				}
			}
		
		//Catch and handle an UnfoundPlayer exception
		}catch(UnfoundPlayer e) {
			System.out.println("Unfound Player");
		}
		return skillLevel;
	}
	
	//getSKillCategoryNotes will return the notes for the desired SkillCategory as a String
	public String getSkillCategoryNotes(int sru, String skillCatName) {
		
		//Declare and initialise a blank String
		String notes = "";
		
		//try catch block used to handle errors
		try {
			
			//Get the desired player by sru
			Player p = getPlayerBySru(sru);
			
			//Get the ArrayList of SkillCategory from the player
			ArrayList<SkillCategory> skillCats = p.getSkillCategories();
		
			//Iterator will iterate through the skillCats ArrayList
			Iterator<SkillCategory> it = skillCats.iterator();
			while(it.hasNext()) {
				SkillCategory sc = it.next();
				
				//if the current SkillCategory name matches the desired skillcat
				if(sc.getName().equals(skillCatName)) {
					
					//Returns the notes for that skill category
					return sc.getNotes();
				}	
			}
		//Catch UnfoundPlayer exception
		}catch(UnfoundPlayer e) {
			System.out.println("Unfound Player");
		}
		
		return notes;
	}
	
	//getSquadPlayersByName returns the details of all the player in a desired squad as a String
	public String getSquadPlayersByName(String squadName) {
		String message = "";
		
		//Get the squad ArrayList from the dataModel
		ArrayList<Squad> squads = dataModel.getSquads();
		
		//Iterator will iterate through all the squads in the squads ArrayList
		Iterator<Squad> it = squads.iterator();
		while(it.hasNext()) {
			Squad s = it.next();
			if(s.getName().equals(squadName)) {
				message += s.getPlayerDetails();
			}
		}
		return message;
	}
}