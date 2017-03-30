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

public class GameWindow {

	private JFrame frmTheDungeonKeeper;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public GameWindow(Game game) {
		initialize(game);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Game game) {
		frmTheDungeonKeeper = new JFrame();
		frmTheDungeonKeeper.setTitle("The Dungeon Keeper");
		frmTheDungeonKeeper.setResizable(false);
		frmTheDungeonKeeper.setBounds(100, 100, 800, 600);
		frmTheDungeonKeeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GamePanel(game);
		frmTheDungeonKeeper.getContentPane().add(panel);
		frmTheDungeonKeeper.setVisible(true);
		panel.requestFocus();
	}
}
