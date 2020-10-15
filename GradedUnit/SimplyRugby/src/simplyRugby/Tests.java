package simplyRugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Tests {

	//Test if the system can successfully add new squads, should pass
	@Test 
	void testGenerateSquadsShouldPass() {
		Model dataModel = new Model();
		
		dataModel.generateSquads();
		
		ArrayList<Squad> squads = dataModel.getSquads();
		
		int size = squads.size();
		
		assertNotEquals(0, size);
	}
	
	//Test if the system successfully creates players,  should pass
	@Test
	void testGeneratePlayersShouldPass() {
		Model dataModel = new Model();
		
		dataModel.generateSquads();
		dataModel.generatePlayers();
		
		ArrayList<Player> players = dataModel.getAllPlayers();
		
		int size = players.size();
		assertNotEquals(0, size);
	}
	
	//Test generation of players, should fail
	@Test
	void testGeneratePlayersShouldFail() {
		Model dataModel = new Model();
		 
		dataModel.generatePlayers();
		
		ArrayList<Player> players = dataModel.getAllPlayers();;
		int size = players.size();
		
		assertNotEquals(0, size);
	}
	
	//Test getting the details of all players in a squad by the name of the squad, should pass
	@Test
	void testGetPlayerBySquadNameShouldPass() {
		Controller ctrl = new Controller();
		
		String s = ctrl.getSquadPlayersByName("A-Team");
	
		boolean success = false;
	
		if(!s.equals("")) {
			success = true;
		}
		
		assertTrue(success);
	}
	
	//Test getting  the details of all players in a squad by the name of the squad, should fail
	@Test
	void testGetPlayerBySquadNameShouldFail() {
		Controller ctrl = new Controller();
		
		String s = ctrl.getSquadPlayersByName("w");
		
		boolean success = false;
		
		if(!s.equals("")) {
			success = true;
		}
		
		assertTrue(success);
	}
	
	//Test getting the name of a player, should pass
	@Test
	void testGetPlayerNameBySruShouldPass() {
		Controller ctrl = new Controller();
		
		try {
			String name = ctrl.getPlayerNameBySru(1000);
			assertEquals("Adam West", name);
		
		}catch(UnfoundPlayer e) {
			assertTrue(false);
		}
	}
	
	//Test getting the name of a player, should fail
	@Test
	void testGetPlayerNameBySruShouldFail() {
		Controller ctrl = new Controller();
		
		try {
			String name = ctrl.getPlayerNameBySru(99999999);
			assertEquals("Adam West", name);
		
		}catch(UnfoundPlayer e) {
			assertTrue(false);
		}
	}
	
	//Test getting a players skill levels, should pass
	@Test
	void testGetPlayerSkillsShouldPass() {
		Controller ctrl = new Controller();
		
		int sru = 1000;
		
		//Passing
		int standard = ctrl.getSkillRatingByName(sru, "Standard");
		int spin= ctrl.getSkillRatingByName(sru, "Spin");
		int pop = ctrl.getSkillRatingByName(sru, "Pop");
		
		//Tackling
		int front = ctrl.getSkillRatingByName(sru, "Front");
		int rear = ctrl.getSkillRatingByName(sru, "Rear");
		int side = ctrl.getSkillRatingByName(sru, "Side");
		int scrabble = ctrl.getSkillRatingByName(sru, "Scrabble");
		
		//Kicking
		int drop = ctrl.getSkillRatingByName(sru, "Drop");
		int punt = ctrl.getSkillRatingByName(sru, "Punt");
		int grubber = ctrl.getSkillRatingByName(sru, "Grubber");
		int goal = ctrl.getSkillRatingByName(sru, "Goal");
		
		boolean success = false;
		
		if(standard == 1 && spin == 1 && pop == 1 && front == 1 && rear == 1 && side == 1 
				&& scrabble == 1 && drop == 1 && punt == 1 && grubber == 1 && goal == 1) {
			success = true;
		}
		
		assertTrue(success);
	}
	
	//Test getting a players skill levels, should fail
	@Test
	void testGetPlayerSkillsShouldFail() {
		Controller ctrl = new Controller();
		
		int sru = 99999999;
		
		//Passing
		int standard = ctrl.getSkillRatingByName(sru, "Standard");
		int spin= ctrl.getSkillRatingByName(sru, "Spin");
		int pop = ctrl.getSkillRatingByName(sru, "Pop");
		
		//Tackling
		int front = ctrl.getSkillRatingByName(sru, "Front");
		int rear = ctrl.getSkillRatingByName(sru, "Rear");
		int side = ctrl.getSkillRatingByName(sru, "Side");
		int scrabble = ctrl.getSkillRatingByName(sru, "Scrabble");
		
		//Kicking
		int drop = ctrl.getSkillRatingByName(sru, "Drop");
		int punt = ctrl.getSkillRatingByName(sru, "Punt");
		int grubber = ctrl.getSkillRatingByName(sru, "Grubber");
		int goal = ctrl.getSkillRatingByName(sru, "Goal");
		
		boolean success = false;
		
		if(standard == 1 && spin == 1 && pop == 1 && front == 1 && rear == 1 && side == 1 
				&& scrabble == 1 && drop == 1 && punt == 1 && grubber == 1 && goal == 1) {
			success = true;
		}
		
		assertTrue(success);
	}
	
	//Test updating players skill, should pass
	@Test
	void testUpdateSkillRecordShouldPass() {
		Controller ctrl = new Controller();
		
		int playerSru = 1000;
		
		//Passing
		int standardLevel = 5;
		int spinLevel = 4;
		int popLevel = 3;
		String passingNotes = "Passing";
		
		//Tackling
		int frontLevel= 4;
		int rearLevel = 4;
		int sideLevel = 3;
		int scrabbleLevel = 2;
		String tacklingNotes = "Tackling";
		
		//Kicking
		int dropLevel= 4;
		int puntLevel = 5;
		int grubberLevel = 3;
		int goalLevel = 3;
		String kickingNotes = "Kicking";
	
		boolean successful = ctrl.createNewSkillRecord(playerSru, standardLevel, spinLevel,  popLevel, passingNotes,
				frontLevel, rearLevel, sideLevel, scrabbleLevel, tacklingNotes,
				dropLevel, puntLevel, grubberLevel, goalLevel,  kickingNotes);
		
		assertTrue(successful);
	}
	
	//Test updating players skill, should pass
	@Test
	void testUpdateSkillRecordShouldFail() {
		Controller ctrl = new Controller();
		
		int playerSru = 99999999;
		
		//Passing
		int standardLevel = 5;
		int spinLevel = 4;
		int popLevel = 3;
		String passingNotes = "Passing";
		
		//Tackling
		int frontLevel= 4;
		int rearLevel = 4;
		int sideLevel = 3;
		int scrabbleLevel = 2;
		String tacklingNotes = "Tackling";
		
		//Kicking
		int dropLevel= 4;
		int puntLevel = 5;
		int grubberLevel = 3;
		int goalLevel = 3;
		String kickingNotes = "Kicking";
	
		boolean successful = ctrl.createNewSkillRecord(playerSru, standardLevel, spinLevel,  popLevel, passingNotes,
				frontLevel, rearLevel, sideLevel, scrabbleLevel, tacklingNotes,
				dropLevel, puntLevel, grubberLevel, goalLevel,  kickingNotes);
		
		assertTrue(successful);	
	}
}
