package gui;

import gameLogic.Game;
import gameLogic.Hero;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class graphic {

	private JFrame frmTheDungeonKeeper;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphic window = new graphic();
					window.frmTheDungeonKeeper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graphic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheDungeonKeeper = new JFrame();
		frmTheDungeonKeeper.setTitle("The Dungeon Keeper");
		frmTheDungeonKeeper.setBounds(100, 100, 450, 300);
		frmTheDungeonKeeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheDungeonKeeper.getContentPane().setLayout(null);
		
		JLabel lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(0, 13, 106, 21);
		frmTheDungeonKeeper.getContentPane().add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setText("3");
		textField.setBounds(103, 12, 23, 21);
		frmTheDungeonKeeper.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setBounds(0, 41, 106, 16);
		frmTheDungeonKeeper.getContentPane().add(lblGuardPersonality);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Drunken", "Suspicious"}));
		comboBox.setBounds(118, 38, 94, 22);
		frmTheDungeonKeeper.getContentPane().add(comboBox);
		
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(324, 215, 97, 25);
		frmTheDungeonKeeper.getContentPane().add(btnExitGame);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setBounds(10, 70, 243, 151);
		frmTheDungeonKeeper.getContentPane().add(textArea);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(284, 73, 63, 21);
		frmTheDungeonKeeper.getContentPane().add(btnLeft);
		
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUp.setBounds(324, 39, 63, 21);
		frmTheDungeonKeeper.getContentPane().add(btnUp);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRight.setEnabled(false);
		btnRight.setBounds(359, 73, 62, 21);
		frmTheDungeonKeeper.getContentPane().add(btnRight);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDown.setEnabled(false);
		btnDown.setBounds(324, 107, 73, 21);
		frmTheDungeonKeeper.getContentPane().add(btnDown);
		
		JLabel lblIndicationsToThe = new JLabel("Indications to the Player");
		lblIndicationsToThe.setBounds(12, 229, 224, 21);
		frmTheDungeonKeeper.getContentPane().add(lblIndicationsToThe);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int theGuardPersonality = 0;
				int theNumberOfOgres = (int)Double.parseDouble(textField.getText());
				String theGuardPers = (String) comboBox.getSelectedItem();
				if(theGuardPers == "Rookie")
					theGuardPersonality = 1;
				else if(theGuardPers == "Drunken")
					theGuardPersonality = 2;
				else
					theGuardPersonality = 3;
			
				btnLeft.setEnabled(true);
				btnUp.setEnabled(true);
				btnRight.setEnabled(true);
				btnDown.setEnabled(true);
				
				String theIndications = "Game ON!";
				lblIndicationsToThe.setText(theIndications);
				
				Hero hero = new Hero(0, 0);
				
				//test
				
				Game game = new Game(theGuardPersonality, theNumberOfOgres, hero);
				
				textArea.setText(game.getfirstMap().printMap2(hero));
				
				game.play();
				
			}
		});
		btnNewGame.setBounds(324, 181, 97, 25);
		frmTheDungeonKeeper.getContentPane().add(btnNewGame);
	}
}
