/* hi mo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
are you aight? i'll try to finish sum shi :D*/

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
		choice = JOptionPane.showOptionDialog(null, "Choose One Option: ", "Second Hand Main Menu",
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
		com = (int)(Math.random() * 10);
		int firstOrSecond = (int)(Math.random() * 2) + 1;
		JOptionPane.showMessageDialog(null, "You are player " + firstOrSecond);
		
	} // playerOne
	
	public static void twoPlayer (){
		// declare variables
		String input = "";
		String error = "";
		int userOne = 0;
		int userTwo = 0;
		int numP1 = 0;
		int numP2 = 0;
		int [] result1 = {0, 0, 0, 0, 0, 0};
		int [] result2 = {0, 0, 0, 0, 0, 0};
		int finalScore1 = 0;
		int finalScore2 = 0;
		String won;
		String message = "Player One: select your positive single digit number";
		String message2 = "Player Two: select your positive single digit number";
		String output = "";
		
		// gamemode message
		JOptionPane.showMessageDialog(null, "Two player selected");
		
		// game loop
		for(int f = 0; f < 5; f++) {
			userOne = 0;
			userTwo = 0;
			numP1 = 0;
			numP2 = 0;
			do {
				input = JOptionPane.showInputDialog(null, message);
				if (input == null) {
					System.exit(0);
				} // if
				try {
					numP1 = Integer.parseInt(input);
				} //try
				catch(Exception e) {
					message = "That's not a valid number, enter a positive number. ";
					continue;
				} //catch
				 //check additional validity with if statements
				if (numP1 < 0 || numP1 > 9) {
					message = "The age must be positive and under 10. Please try again. ";
				continue;
				} // if
				break;
			} while(true);

			
			do {
				input = JOptionPane.showInputDialog(null, message2);
				if (input == null) {
					System.exit(0);
				} // if
				try {
					numP2 = Integer.parseInt(input);
				} //try
				catch(Exception e) {
					message2 = "That's not a valid number, enter a positive number. ";
					continue;
				} //catch
				 //check additional validity with if statements
				if (numP2 < 0 || numP2 > 9) {
					message2 = "The age must be positive and under 10. Please try again. ";
				continue;
				} // if
				break;
			} while(true);
			JOptionPane.showMessageDialog(null, "Player One, your number is " + numP1);
			JOptionPane.showMessageDialog(null, "Player Two, your number is " + numP2);

			userTwo = numP1 - numP2;
			if (userTwo < 0) {
				userTwo = Math.abs(userTwo);
			} // if

			if (f == 0) {
				result2[0] = numP2;	
			} // if
			result2[f + 1] = userTwo;
			output = "";
			for(int i = 0; i < result2.length; i++) {
				if (result2[i] != 0) {
					output += (result2[i]);
				}
				
			}
			JOptionPane.showMessageDialog(null, "Player Two, your result is: " + output);
			
			
			
			
			message = "Player One: select your positive single digit number";
			do {
				input = JOptionPane.showInputDialog(null, message);
				if (input == null) {
					System.exit(0);
				} // if
				try {
					numP1 = Integer.parseInt(input);
				} //try
				catch(Exception e) {
					message = "Player One: That's not a valid number. Please enter a positive number. ";
					continue;
				} //catch
				 //check additional validity with if statements
				if (numP1 < 0 || numP1 > 9) {
					message = "Player One: The number must be positive and under 10. Please try again. ";
				continue;
				} // if
				break;
			} while(true);

			
			message = "Player Two: select your positive single digit number";
			do {
				input = JOptionPane.showInputDialog(null, message);
				if (input == null) {
					System.exit(0);
				} // if
				try {
					numP2 = Integer.parseInt(input);
				} //try
				catch(Exception e) {
					message = "Player Two: That's not a valid number, enter a positive number. ";
					continue;
				} //catch
				 //check additional validity with if statements
				if (numP2 < 0 || numP2 > 9) {
					message = "Player Two: The number must be positive and under 10. Please try again. ";
				continue;
				} // if
				break;
			} while(true);
			JOptionPane.showMessageDialog(null, "Player One, your number is " + numP1);
			JOptionPane.showMessageDialog(null, "Player Two, your number is " + numP2);
			
			userOne = numP2 - numP1;
			if (userOne < 0) {
				userOne = Math.abs(userOne);
			} // if
			if (f == 0) {
				result1[0] = numP1;	
			} // if
			result1[f + 1] = userOne;
			output = "";
			for(int i = 0; i < result1.length; i++) {
				if (result1[i] != 0) {
					output += (result1[i]);
				}
				
			}
			JOptionPane.showMessageDialog(null, "Player One, your result is: " + output);

			// calculate the whole score for both players
			for (int i = 0; i < result1.length; i++) {
				finalScore1 += result1[i];
				finalScore2 += result2[i];
			} // for
			
		}

		// determine who won the game
		if (finalScore1 > finalScore2) {
			won = "Player One won!";
		}else {
			won = "Player Two won!";
		} // else
		
		
		// display score for both player
		message = "Player One's score is "; 
		message2 = "Player Two's score is ";
		JOptionPane.showMessageDialog(null, won);
		JOptionPane.showMessageDialog(null, message + finalScore1 + " " +  message2 + finalScore2);

	} // playerTwo
	
} // class



//for (int i = 0; i < 2; i++) {
//do {
//	input = JOptionPane.showInputDialog(null, message);
//	if (input == null) {
//		System.exit(0);
//	} // if
//	try {
//		numP[i] = Integer.parseInt(input);
//		System.out.println(numP[i] + Integer.parseInt(input));
//	} //try
//	catch(Exception e) {
//		message = "That's not a valid number, enter a positive number. ";
//		continue;
//	} //catch
//	 //check additional validity with if statements
//	if (numP[i] < 0 || numP[i] > 9) {
//		message = "The number must be positive and under 10. Please try again. ";
//	continue;
//	} // if
//	break;
//} while(true);
//} // for
