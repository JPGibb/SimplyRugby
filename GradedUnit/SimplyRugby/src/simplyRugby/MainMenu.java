package simplyRugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	//Creates a Controller object that will be used to allow the form to access methods in the controller
	private Controller ctrl;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//prevents the window from being resized
		setResizable(false);
		
		//Creates a button called btnViewSquads
		JButton btnViewSquads = new JButton("View Squads");
		btnViewSquads.addActionListener(new ActionListener() {
			//This method will run when the user clicks on the button
			public void actionPerformed(ActionEvent arg0) {
				//Calls the showViewSquads method in the controller
				ctrl.showViewSquads();
				
				//Disposes of this form
				dispose();
			}
		});
		btnViewSquads.setBounds(111, 73, 153, 23);
		contentPane.add(btnViewSquads);
		
		//Creates a button called btnCreateSkillRecord
		JButton btnCreateSkillRecord = new JButton("Create Skill record");
		btnCreateSkillRecord.addActionListener(new ActionListener() {
			//Method get called when the user clicks on  the button
			public void actionPerformed(ActionEvent e) {
				//Calls the showCreateSkillRecord method in the controller
				ctrl.showCreateSkillRecord();
				//Disposes of this form
				dispose();
			}
		});
		btnCreateSkillRecord.setBounds(111, 141, 153, 23);
		contentPane.add(btnCreateSkillRecord);
	}
	
	//setController method will set the ctrl variable to the passed Controller object
	public void setController(Controller c) {
		ctrl = c;
	}
}
