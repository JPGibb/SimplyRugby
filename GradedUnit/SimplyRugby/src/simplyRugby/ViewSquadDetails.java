package simplyRugby;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ViewSquadDetails extends JFrame {
	
	private Controller ctrl;
	
	private JPanel contentPane;
	private JTextField txtSquadName;
	private JButton btnMainMenu;
	private JTextPane txtPlayers;
	private JLabel lblPlayers;
	private JButton btnRefresh;
	/**
	 * Create the frame.
	 */
	public ViewSquadDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//prevents the window from being resized
		setResizable(false);
		
		txtSquadName = new JTextField();
		txtSquadName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySquadDetails();
			}
		});
		txtSquadName.setBounds(104, 113, 129, 20);
		contentPane.add(txtSquadName);
		txtSquadName.setColumns(10);
		
		JLabel lblSquadName = new JLabel("Squad Name");
		lblSquadName.setBounds(10, 116, 82, 14);
		contentPane.add(lblSquadName);
		
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.showMainMenu();
				dispose();
			}
		});
		
		btnMainMenu.setBounds(10, 11, 100, 23);
		contentPane.add(btnMainMenu);
		
		txtPlayers = new JTextPane();
		txtPlayers.setEditable(false);
		txtPlayers.setBounds(369, 32, 387, 388);
		contentPane.add(txtPlayers);
		
		JScrollPane scroll = new JScrollPane(txtPlayers);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(369, 32, 387, 388);
		contentPane.add(scroll);

		
		lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(369, 15, 94, 14);
		contentPane.add(lblPlayers);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySquadDetails();
			}
		});
		btnRefresh.setBounds(257, 111, 89, 23);
		contentPane.add(btnRefresh);
	}
	
	//sets the ctrl attribute to the passed controller object
	public void setController(Controller c) {
		ctrl = c;
	}
	
	//displays the details for all the players in the squad
	private void displaySquadDetails() {
		String squadName = txtSquadName.getText();
		
		if(squadName.length() < 1) {
			displayMessage("You need to enter a squad name");
		}else {
			String details = ctrl.getSquadPlayersByName(squadName);
			if(details.equals("")) {
				displayMessage("Unable to find a squad with that name");
			}
			else {
				txtPlayers.setText(details);
			}
		}
	}
	
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
