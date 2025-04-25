package secondHand_kaitoMo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;

import java.io.*;

public class secondHand {

	public static void main(String[] args) {
		
		do {
			int choice  = mainMenu ();
			
			if (choice == 0) {
				instructions();
			} // if 
			
			if (choice == 1) {
				singlePlayer();
			} // if 
			
			if (choice == 2) {
				twoPlayer();
			} // if 
			
			if (choice == 3 || choice == -1) {
				System.exit(0);
			} // if
		}while (true);
		
	} // main

	public static int mainMenu () {
		int choice = 0;	
		
		Object[] options = { "Instructions", "1P", "2P", "Quit" };
		choice = JOptionPane.showOptionDialog(null, "Choose One Option: ", "Main Menu",
		JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
		null, options, options[0]);
		return choice;
	} // mainMenu
	
	public static void instructions () {
		
		String instructions = "Second Hand\r\n"
				+ "\r\n"
				+ "Players: 2\r\n"
				+ "Tools: 2 Calculators\r\n"
				+ "\r\n"
				+ "Objective\r\n"
				+ "Build a six-digit number with a higher digit sum than your opponent.\r\n"
				+ "\r\n"
				+ "How to Play\r\n"
				+ "1. Start: Each player enters a single-digit number into their calculator.\r\n"
				+ "(e.g., Player A enters 6, Player B enters 9.)\r\n"
				+ "2. Turns:\r\n"
				+ "• Player A calls out a one-digit number.\r\n"
				+ "• Player B subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r\n"
				+ "• Then Player B calls out a digit, and Player A does the same.\r\n"
				+ "\r\n"
				+ "Example:\r\n"
				+ "• Player A calls 4. Player B has 9 → |9 - 4| = 5 → B’s display: 95\r\n"
				+ "• Player B calls 9. Player A has 6 → |6 - 9| = 3 → A’s display: 63\r\n"
				+ "3. Continue alternating until both players have six-digit numbers.\r\n"
				+ "4. Scoring: Add the digits of each six-digit number. The player with the higher total wins.\r\n"
				+ "\r\n"
				+ "Example:\r\n"
				+ "123456 → 1 + 2 + 3 + 4 + 5 + 6 = 21\r\n"
				+ "Winning the Game\r\n"
				+ "• Highest digit sum wins the round.\r\n"
				+ "\r\n"
				+ "• For extended play, continue until a player reaches 350 points total.\r\n"
				+ "\r\n"
				+ "Strategy Tips\r\n"
				+ "• Watch your opponent’s pattern and try to disrupt it.\r\n"
				+ "• Choose numbers that either maximize your own total or minimize the opponent’s next move.\r\n"
				+ "\r\n"
				+ "";
		JOptionPane.showMessageDialog(null, instructions);
	
	} // instructions
	
	public static void singlePlayer (){
		JOptionPane.showMessageDialog(null, "Single player selected");
		int com = 0;
		int user = 0;
		int com = (int)(Math.random() * 10);
		int firstOrSecond = (int)(Math.random() * 2);
		JOptionPane.showMessageDialog(null, "You are going" + firstOrSecond);
		
	} // playerOne
	
	public static void twoPlayer (){
		JOptionPane.showMessageDialog(null, "Two player selected");
		
	} // playerOne
	
} // class
