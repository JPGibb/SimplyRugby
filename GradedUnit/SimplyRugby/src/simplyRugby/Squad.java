package simplyRugby;

import java.util.ArrayList;
import java.util.Iterator;

public class Squad {
	
	//Name of the squad
	private String name;
	
	//ArrayList of type that will store all the players in the squad
	private ArrayList<Player> players = new ArrayList<Player>();
	
	//Constructor that is called when an instance of the object is created
	public Squad(String n) {
		name = n;
	}
	
	//will add a new player to the players ArrayList
	public void addPlayer(Player p) {
		players.add(p);	
	}
	
	//returns the players ArrayList
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	//returns the name of the squad
	public String getName() {
		return name;
	}
	
	//Returns the details of all the players in the squad as a String
	public String getPlayerDetails() {
		String message = "";
		Iterator<Player> it = players.iterator();
		while(it.hasNext()) {
			message += it.next().getDetails();
			message += "\n========================================\n";
		}
		
		return message;
	}
}
