package simplyRugby;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextArea;

public class SkillRecordScreen extends JFrame {

	//Stores reference to controller object, allowing this screen to call methods in the controller
	private Controller ctrl;
	
	//Declare ui elements
	private JPanel contentPane;
	private JTextField txtStandard;
	private JTextField txtSpin;
	private JTextField txtPop;
	private JTextField txtFront;
	private JTextField txtRear;
	private JTextField txtSide;
	private JTextField txtDrop;
	private JTextField txtPunt;
	private JTextField txtGrubber;
	private JTextField txtGoal;
	private JTextField txtScrabble;
	private JTextField txtSru;
	private JTextField txtPlayerName;
	private JTextPane txtPassingNotes;
    private JTextPane txtTacklingNotes;
	private JTextPane txtKickingNotes;


	/**
	 * Create the frame.
	 */
	public SkillRecordScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//prevents the window from being resized
		setResizable(false);
		
		JLabel lblPassing = new JLabel("Passing");
		lblPassing.setBounds(35, 221, 86, 14);
		contentPane.add(lblPassing);
		
		txtStandard = new JTextField();
		txtStandard.setBounds(180, 269, 86, 20);
		contentPane.add(txtStandard);
		txtStandard.setColumns(10);
		
		txtSpin = new JTextField();
		txtSpin.setColumns(10);
		txtSpin.setBounds(180, 300, 86, 20);
		contentPane.add(txtSpin);
		
		txtPop = new JTextField();
		txtPop.setColumns(10);
		txtPop.setBounds(180, 331, 86, 20);
		contentPane.add(txtPop);
		
		JLabel lblTackling = new JLabel("Tackling");
		lblTackling.setBounds(35, 389, 86, 14);
		contentPane.add(lblTackling);
		
		JLabel lblKicking = new JLabel("Kicking");
		lblKicking.setBounds(35, 569, 71, 14);
		contentPane.add(lblKicking);
		
		txtFront = new JTextField();
		txtFront.setColumns(10);
		txtFront.setBounds(180, 422, 86, 20);
		contentPane.add(txtFront);
		
		txtRear = new JTextField();
		txtRear.setColumns(10);
		txtRear.setBounds(180, 453, 86, 20);
		contentPane.add(txtRear);
		
		txtSide = new JTextField();
		txtSide.setColumns(10);
		txtSide.setBounds(180, 484, 86, 20);
		contentPane.add(txtSide);
		
		txtDrop = new JTextField();
		txtDrop.setColumns(10);
		txtDrop.setBounds(180, 591, 86, 20);
		contentPane.add(txtDrop);
		
		txtPunt = new JTextField();
		txtPunt.setColumns(10);
		txtPunt.setBounds(180, 628, 86, 20);
		contentPane.add(txtPunt);
		
		txtGrubber = new JTextField();
		txtGrubber.setColumns(10);
		txtGrubber.setBounds(180, 659, 86, 20);
		contentPane.add(txtGrubber);
		
		JLabel lblStandard = new JLabel("Standard");
		lblStandard.setBounds(99, 272, 71, 14);
		contentPane.add(lblStandard);
		
		JLabel lblSpin = new JLabel("Spin");
		lblSpin.setBounds(99, 303, 46, 14);
		contentPane.add(lblSpin);
		
		JLabel lblPop = new JLabel("Pop");
		lblPop.setBounds(99, 334, 46, 14);
		contentPane.add(lblPop);
		
		JLabel lblFront = new JLabel("Front");
		lblFront.setBounds(99, 425, 46, 14);
		contentPane.add(lblFront);
		
		JLabel lblRear = new JLabel("Rear");
		lblRear.setBounds(99, 456, 46, 14);
		contentPane.add(lblRear);
		
		JLabel lblSide = new JLabel("Side");
		lblSide.setBounds(99, 487, 46, 14);
		contentPane.add(lblSide);
		
		JLabel lblDrop = new JLabel("Drop");
		lblDrop.setBounds(99, 594, 46, 14);
		contentPane.add(lblDrop);
		
		JLabel lblPunt = new JLabel("Punt");
		lblPunt.setBounds(99, 628, 46, 14);
		contentPane.add(lblPunt);
		
		JLabel lblGrubber = new JLabel("Grubber");
		lblGrubber.setBounds(99, 662, 46, 14);
		contentPane.add(lblGrubber);
		
		JLabel lblScrabble = new JLabel("Scrabble");
		lblScrabble.setBounds(99, 528, 71, 14);
		contentPane.add(lblScrabble);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(99, 707, 46, 14);
		contentPane.add(lblGoal);
		
		txtGoal = new JTextField();
		txtGoal.setColumns(10);
		txtGoal.setBounds(180, 701, 86, 20);
		contentPane.add(txtGoal);
		
		txtScrabble = new JTextField();
		txtScrabble.setColumns(10);
		txtScrabble.setBounds(180, 525, 86, 20);
		contentPane.add(txtScrabble);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(384, 221, 100, 14);
		contentPane.add(lblComments);
		
		//JTextPane txtPassingNotes = new JTextPane();
		txtPassingNotes = new JTextPane();
		txtPassingNotes.setBounds(321, 257, 203, 94);
		contentPane.add(txtPassingNotes);
		
		txtTacklingNotes = new JTextPane();
		txtTacklingNotes.setBounds(321, 416, 203, 126);
		contentPane.add(txtTacklingNotes);
		
		txtKickingNotes = new JTextPane();
		txtKickingNotes.setBounds(321, 591, 203, 130);
		contentPane.add(txtKickingNotes);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			//method will run if the button is clicked
			//used to update the skill information for a given Player
			public void actionPerformed(ActionEvent arg0) {
				
				//try catch block used to handle errors
				try {
					//get the player sru number from the txtSru field and parse it to an int
					int playerSru = Integer.parseInt(txtSru.getText());
					
					//Passing
					int standardLevel = Integer.parseInt(txtStandard.getText());
					int spinLevel = Integer.parseInt(txtSpin.getText());
					int popLevel = Integer.parseInt(txtPop.getText());
					String passingNotes = txtPassingNotes.getText();
					
					//Tackling
					int frontLevel= Integer.parseInt(txtFront.getText());
					int rearLevel= Integer.parseInt(txtRear.getText());
					int sideLevel = Integer.parseInt(txtSide.getText());
					int scrabbleLevel = Integer.parseInt(txtScrabble.getText());
					String tacklingNotes = txtTacklingNotes.getText();
					
					//Kicking
					int dropLevel= Integer.parseInt(txtDrop.getText());
					int puntLevel = Integer.parseInt(txtPunt.getText());
					int grubberLevel= Integer.parseInt(txtGrubber.getText());
					int goalLevel = Integer.parseInt(txtGoal.getText());
					String kickingNotes = txtKickingNotes.getText();
				
					boolean successful = ctrl.createNewSkillRecord(playerSru, standardLevel, spinLevel,  popLevel, passingNotes,
							frontLevel, rearLevel, sideLevel, scrabbleLevel, tacklingNotes,
							dropLevel, puntLevel, grubberLevel, goalLevel,  kickingNotes);
					if(successful) {
						displayMessage("Successfully Created new skill reocord");
					}
					else {
						displayMessage("Error: Unable to create new skill record, ensure the correct SRU is entered for the player and entered skill levels are between 0 and 5 inclusive");
					}
					
				}catch(NumberFormatException e) {
					displayMessage("Failed to parse data, you must enter whole numbers in the skill level inputs");
				}
			}
		});
		btnSave.setBounds(180, 778, 119, 40);
		contentPane.add(btnSave);
		
		//button that leads to the main menu when clicked
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.showMainMenu();
				dispose();
			}
		});
		btnMainMenu.setBounds(14, 11, 104, 23);
		contentPane.add(btnMainMenu);
		
		txtSru = new JTextField();
		txtSru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySkillDetails();
			}
		});
		txtSru.setBounds(177, 69, 86, 20);
		contentPane.add(txtSru);
		txtSru.setColumns(10);
		
		JLabel lblSru = new JLabel("Player SRU");
		lblSru.setBounds(58, 72, 89, 14);
		contentPane.add(lblSru);
		
		//button that will refresh the details on the screen
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySkillDetails();
			}
		});
		btnRefresh.setBounds(321, 68, 89, 23);
		contentPane.add(btnRefresh);
		
		JLabel lblPlayerName = new JLabel("Player Name");
		lblPlayerName.setBounds(58, 112, 85, 14);
		contentPane.add(lblPlayerName);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setBackground(Color.WHITE);
		txtPlayerName.setEditable(false);
		txtPlayerName.setBounds(177, 109, 122, 20);
		contentPane.add(txtPlayerName);
		txtPlayerName.setColumns(10);
	}
	
	//Will display a message box onscreen containing the passed String
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	//setController will set the ctr variable to the passed data
	public void setController(Controller c) {
		ctrl = c;
	}
	
	//displaySkillDetials will get the player name and skill details using the sru number
	//and fill the fields with the data
	private void displaySkillDetails() {
		try{
			int sruNum = Integer.parseInt(txtSru.getText());
			txtPlayerName.setText(ctrl.getPlayerNameBySru(sruNum));
			
			//Passing
			txtStandard.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Standard")));
			txtSpin.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Spin")));
			txtPop.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Pop")));
			txtPassingNotes.setText(ctrl.getSkillCategoryNotes(sruNum, "Passing"));
			
			//Tackling
			txtFront.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Front")));
			txtRear.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Rear")));
			txtSide.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Side")));
			txtScrabble.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Scrabble")));
			txtTacklingNotes.setText(ctrl.getSkillCategoryNotes(sruNum, "Tackling"));
			
			//Kicking
			txtDrop.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Drop")));
			txtPunt.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Punt")));
			txtGrubber.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Grubber")));
			txtGoal.setText(Integer.toString(ctrl.getSkillRatingByName(sruNum, "Goal")));
			txtKickingNotes.setText(ctrl.getSkillCategoryNotes(sruNum, "Kicking"));
			
			//Catch and unfound player exception
		}catch(UnfoundPlayer exception) {
			//Display the message onscreen
			displayMessage("Error, That player does not exist");
			
			//catch a number format exception
		}catch(NumberFormatException exception) {
			//display a message onscreen
			displayMessage("Error, You need to enter a number into the SRU field");
		}
	}
}
