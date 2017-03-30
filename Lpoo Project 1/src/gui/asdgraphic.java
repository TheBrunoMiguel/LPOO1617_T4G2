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
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import userInterface.ReadInput;

public class asdgraphic {

	private JFrame frmTheDungeonKeeper;
	private JTextField textField;
	private JTextArea textArea;
	private JComboBox comboBox;
	private GameWindow gameWindow;

	private JLabel lblNumberOfOgres;
	private JLabel lblGuardPersonality;
	private JLabel lblIndicationsToThe;

	private JButton btnLeft;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnRight;
	private JButton btnNewGame;
	private JButton btnExitGame;

	private Game game;
	private boolean running;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asdgraphic window = new asdgraphic();
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
	public asdgraphic() {
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

		lblNumberOfOgres = new JLabel("Number of Ogres");
		lblNumberOfOgres.setBounds(0, 13, 106, 21);
		frmTheDungeonKeeper.getContentPane().add(lblNumberOfOgres);

		textField = new JTextField();
		textField.setText("3");
		textField.setBounds(103, 12, 23, 21);
		frmTheDungeonKeeper.getContentPane().add(textField);
		textField.setColumns(10);

		lblGuardPersonality = new JLabel("Guard Personality");
		lblGuardPersonality.setBounds(0, 41, 106, 16);
		frmTheDungeonKeeper.getContentPane().add(lblGuardPersonality);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Rookie", "Drunken", "Suspicious" }));
		comboBox.setBounds(118, 38, 94, 22);
		frmTheDungeonKeeper.getContentPane().add(comboBox);

		btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(324, 215, 97, 25);
		frmTheDungeonKeeper.getContentPane().add(btnExitGame);

		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(10, 70, 243, 151);
		frmTheDungeonKeeper.getContentPane().add(textArea);

		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				move("Left");
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setBounds(284, 73, 63, 21);
		frmTheDungeonKeeper.getContentPane().add(btnLeft);

		btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				move("Up");
			}
		});
		btnUp.setBounds(324, 39, 63, 21);
		frmTheDungeonKeeper.getContentPane().add(btnUp);

		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move("Right");
			}
		});
		btnRight.setEnabled(false);
		btnRight.setBounds(359, 73, 62, 21);
		frmTheDungeonKeeper.getContentPane().add(btnRight);

		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				move("Down");
			}
		});
		btnDown.setEnabled(false);
		btnDown.setBounds(324, 107, 73, 21);
		frmTheDungeonKeeper.getContentPane().add(btnDown);

		lblIndicationsToThe = new JLabel("Insert options and start a new game!");
		lblIndicationsToThe.setBounds(12, 229, 224, 21);
		frmTheDungeonKeeper.getContentPane().add(lblIndicationsToThe);

		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String theIndications;
				int theGuardPersonality = 0;
				int theNumberOfOgres = (int) Double.parseDouble(textField.getText());
				if(theNumberOfOgres<1||theNumberOfOgres>5)
				{
					theIndications = "Invalid number of Ogres!";
					lblIndicationsToThe.setText(theIndications);
					btnLeft.setEnabled(false);
					btnUp.setEnabled(false);
					btnRight.setEnabled(false);
					btnDown.setEnabled(false);
					
				}
				else{
				String theGuardPers = (String) comboBox.getSelectedItem();
				switch(theGuardPers){
				case "Rookie":
					theGuardPersonality = 1;
					break;
				case "Drunken":
					theGuardPersonality = 2;
					break;
				case "Suspicious":
					theGuardPersonality = 3;
					break;
				}
				
				
				btnLeft.setEnabled(true);
				btnUp.setEnabled(true);
				btnRight.setEnabled(true);
				btnDown.setEnabled(true);

				theIndications = "Game started! Escape the prison!";
				lblIndicationsToThe.setText(theIndications);

				game = new Game(theNumberOfOgres,theGuardPersonality);
				
				gameWindow = new GameWindow(game);
				
				textArea.setText(game.returnStringMap());
				}
			}
		});
		btnNewGame.setBounds(324, 181, 97, 25);
		frmTheDungeonKeeper.getContentPane().add(btnNewGame);
	}

	public void move(String movement) {
		String theIndications;
		
		game.update(movement);
		textArea.setText(game.returnStringMap());
		
		theIndications=game.getCurrentMessage();
		lblIndicationsToThe.setText(theIndications);
		
		if (!game.isRunning()) {

			
			
			if (game.isHeroWinner()) {
				theIndications = "You Won!";
				lblIndicationsToThe.setText(theIndications);
			} else {
				theIndications = "You Lost!";
				lblIndicationsToThe.setText(theIndications);
			}

			btnLeft.setEnabled(false);
			btnUp.setEnabled(false);
			btnRight.setEnabled(false);
			btnDown.setEnabled(false);
		}
		game.resetCurrentMessage();

	}
}
