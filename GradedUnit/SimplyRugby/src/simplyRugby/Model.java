package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

public class Model {
	
	//Creates a private ArrayList of the type squad that will hold all the squads
	private ArrayList<Squad> squads = new ArrayList<Squad>();
	
	//Creates a private int variable called nextSru that will store the next sru value to be used in the creation of players
	private int nextSru = 1000;

	//Default constructor for the Model Class
	public Model() {
		
	}
	
	//getSquads method will return a reference to the squads ArrayList
	public ArrayList<Squad> getSquads(){
		return squads;
	}
	
	//addNewPlayerToSquad adds a new player to squad, the methods is passed the name of the squad that the player is to be added to as well as a Player object
	public void addNewPlayerToSquad(String squadName, Player p) {
		//Creates an Iterator for the squads ArrayList, this will be used to iterate through the list
		Iterator<Squad> it = squads.iterator();
		while(it.hasNext()) {
			//Gets the next squad
			Squad s = it.next();
			
			//Check if the name of the current squad is the same as the name passed to the method
			if(s.getName().equals(squadName)) {
				
				//Will add the player to the desired squad
				s.addPlayer(p);
			}
		}
	}
	
	//generateSquads will generate squad to be used for testing purposes
	public void generateSquads() {
		squads.add(new Squad("A-Team"));
		squads.add(new Squad("B-Team"));
	}
	
	//generatePlayers will generate players and add them squads for testing purposes
	public void generatePlayers() {
		//Senior players
		addNewPlayerToSquad("A-Team", new Player("Adam", "West", nextSru, "1998-05-12"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Sharon", "Lamb", nextSru, "1999-09-05"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Jacob", "Man", nextSru, "1997-04-16"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Paul", "Gate", nextSru, "1997-06-09"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Morton", "Brooks", nextSru, "1998-10-30"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Toney", "Crane", nextSru, "1996-06-26"));
		++nextSru;
		addNewPlayerToSquad("A-Team", new Player("Justin", "Dunlap", nextSru, "1999-03-15"));
		++nextSru;
		
		//Junior players
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Rafael", "Crawfrod", "Desmond Liu", nextSru,"2003-05-08"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Brenton", "Sloan", "Velma Marshall", nextSru, "2004-09-11"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Peggy", "Bates", "Logan Huynh", nextSru, "2004-12-13"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Vern", "Arellano", "Cassandra Mullen", nextSru,"2006-08-30"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Ronald", "Mullins", "Brendon Carlson", nextSru, "2002-02-16"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Duncan", "Jones", "Kelly  Bowers", nextSru, "2001-01-01"));
		++nextSru;
		addNewPlayerToSquad("B-Team", new JuniorPlayer("Liz", "Davies", "Collette Montgomery", nextSru, "2003-07-09"));
		++nextSru;
	}
	
	//getAllPlayers returns an ArrayList of type Player that contains all players from all the squads
	public ArrayList<Player> getAllPlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		Iterator<Squad> it = squads.iterator(); 
		while(it.hasNext()) {
			players.addAll(it.next().getPlayers());
		}
		return players;
	}
}
