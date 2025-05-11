
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
            int choice = mainMenu();

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
        } while (true);

    } // main

    public static int mainMenu() {
        int choice = 0;

        Object[] options = {
            "Instructions",
            "1P",
            "2P",
            "Quit"
        };
        choice = JOptionPane.showOptionDialog(null, "Choose One Option: ", "Second Hand Main Menu",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        return choice;
    } // mainMenu

    public static void instructions() {

        String instructions = "<b>" + "Second Hand </b> \r\n" +
            "\r\n" +
            "Players: 1-2\r\n" +
            "\r\n" +
            "Objective\r\n" +
            "Build a several-digit number with a higher digit sum than your opponent.\r\n" +
            "\r\n" +
            "How to Play:\r\n" +
            "• Player A declares a one-digit number.\r\n" +
            "• Player B subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r\n" +
            "• Then Player B submits a number, and Player A does the same.\r\n" +
            "• Player A then subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r\n" +
            "• This process is then repeated until each player has the right amount of number. \r\n" +
            "\r\n" +
            "Example:\r\n" +
            "• Player A calls 4. Player B has 9 → |9 - 4| = 5 → B’s display: 95\r\n" +
            "• Player B calls 9. Player A has 6 → |6 - 9| = 3 → A’s display: 63\r\n" +
            "3. Continue alternating until both players have designated amount of numbers.\r\n" +
            "4. Scoring: Add the digits of each digit. The player with the higher total wins.\r\n" +
            "\r\n" +
            "Example:\r\n" +
            "123456 → 1 + 2 + 3 + 4 + 5 + 6 = 21\r\n" +
            "Winning the Game\r\n" +
            "• Highest digit sum wins the game.\r\n" +
            "\r\n" +
            "Strategy Tips\r\n" +
            "• Watch your opponent’s pattern and try to disrupt it.\r\n" +
            "• Choose numbers that either maximize your own total or minimize the opponent’s next move.\r\n" +
            "\r\n" +
            "";
        JOptionPane.showMessageDialog(null, instructions);

    } // instructions



    public static void singlePlayer() {
        int choice = 0;
        int rand = 0;
        int user = 0;
        int user2 = 0;
        int numP = 0;
        int com = 0;
        int temp = 0;
        int finalScoreCom = 0;
        int finalScoreP = 0;
        int turn = 0;
        int[] result1 = new int[(int)(Math.random() * 7) + 7];
        int[] resultCom = new int[result1.length];
        String message = "";
        String won = "";
        String input = "";
        String output = "";
        String userName = "";
        
  
        JOptionPane.showMessageDialog(null, "Single player selected \nYou are going first");
        
        userName = JOptionPane.showInputDialog(null, "What is your name");
        // difficulty
        Object[] options = {
            "Easy",
            "Medium",
            "Hard",
            "Quit"
        };
        choice = JOptionPane.showOptionDialog(null, "Choose One Option: ", "Difficulty selection",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);

        // if user wants to quit
        if (choice == -1 || choice == 3) {
            System.exit(0);
        } // if 
        
        // turns message
        JOptionPane.showMessageDialog(null, "There will be " + (result1.length - 1) + " turns");
        
        for (int i = 1; i < result1.length; i++) {

            // player input
            message = userName + " please select your positive single digit number \nto be subtracted against the bot's number to receive your point";
            do {
                input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message = "That's not a valid number, please enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP < 0 || numP > 9) {
                    message = userName + "your number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);

            // computer input
            rand = (int)(Math.random() * 11);
            switch (choice) {
                case 2:
                    // if rand = between 0 and 2 choose best num
                    // if rand = between 3 and 5 choose med num
                    // if rand = between 6 and 10 choose worst num
                    switch (rand) {
                        case 0:
                        case 1:
                        case 2:
                            temp = (int)(Math.random() * (numP - (numP - 2) + 1)) + (numP - 2); // max user number   min user number-2
                            break;
                        case 3:
                        case 4:
                        case 5:
                            temp = (int)(Math.random() * ((numP - 3) - (numP - 5) + 1)) + (numP - 5); // max user number-3   min user number-5
                            break;
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            temp = (int)(Math.random() * ((numP - 6) - (numP - 10) + 1)) + (numP - 10); // max user number-6   min user number-10
                            break;
                    } // switch
                    break;
                case 1:

				// if rand = between 0 and 4 choose best num
                    // if rand = between 5 and 8 choose med num
                    // if rand = between 9 and 10 choose worst num
                    switch (rand) {
                        case 0:
                        case 1:
                        case 2:
                            temp = (int)(Math.random() * (numP - (numP - 4) + 1)) + (numP - 4); // max user number   min user number-2
                            break;
                        case 3:
                        case 4:
                        case 5:
                            temp = (int)(Math.random() * ((numP - 5) - (numP - 8) + 1)) + (numP - 8); // max user number-3   min user number-5
                            break;
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            temp = (int)(Math.random() * ((numP - 9) - (numP - 10) + 1)) + (numP - 10); // max user number-6   min user number-10
                            break;
                    } // switch
                    break;

                case 0:
                    // if rand = between 0 and 7 choose best num
                    // if rand = between 8 and 9 choose med num
                    // if rand = between 10 choose worst num
                    switch (rand) {
                        case 0:
                        case 1:
                        case 2:
                            temp = (int)(Math.random() * (numP - (numP - 7) + 1)) + (numP - 7); // max user number   min user number-2
                            break;
                        case 3:
                        case 4:
                        case 5:
                            temp = (int)(Math.random() * ((numP - 8) - (numP - 9) + 1)) + (numP - 9); // max user number-3   min user number-5
                            break;
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            temp = numP - 10; // user number-10
                            break;
                    } // switch
            } // switch

            temp = Math.abs(temp);
            com = numP - temp;
            com = Math.abs(com);
            if (turn == 0) {

                resultCom[0] = com;
                result1[0] = numP;

            } // if

            // if turn even then it's the players turn to score points
            if (turn % 2 == 0) {

                user = com - numP;
                if (user < 0) {
                    user = Math.abs(user);
                } // if
                result1[i] = user;
                output = "";
                for (int f = 0; f < result1.length; f++) {
                    if (result1[f] != 0) {
                        output += (result1[f]);
                    } // if

                } // for

                JOptionPane.showMessageDialog(null, "The Bot chose: " + com + "\n" + userName + " you chose: " + numP + "\nThe bot's number is: " + output);
            } // if

            // if turn odd then it's the bot's turn to score points
            else {

                user2 = numP - com;
                if (user2 < 0) {
                    user2 = Math.abs(user2);
                } // if
                resultCom[i] = user2;
                output = "";
                for (int f = 0; f < resultCom.length; f++) {
                    if (resultCom[f] != 0) {
                        output += resultCom[f];
                    } // if

                } // for

                JOptionPane.showMessageDialog(null, "The Bot chose: " + com + "\n" + userName + " you chose: " + numP + "\nYour number is: " + output);
            } // else

            turn++;

        } // for

        // calculate the whole score for both players
        for (int f = 0; f < result1.length; f++) {
            finalScoreP += result1[f];
            finalScoreCom += resultCom[f];
        } // for
        
        // provide winning message
        if (finalScoreP > finalScoreCom) {
        	won = userName + " won! ";
        } else {
        	won = "The bot won!";
        } // else
        
        JOptionPane.showMessageDialog(null, won + "\n" + userName + ", your final score is : " + finalScoreP + "\nThe bot's final score is: " + finalScoreCom);
    } // onePlayer



    public static void twoPlayer() {
        // declare variables
        String input = "";
        int userOne = 0;
        int userTwo = 0;
        int numP1 = 0;
        int numP2 = 0;
        int[] result1 = new int[6];
        int[] result2 = new int[6];
        int finalScore1 = 0;
        int finalScore2 = 0;
        String won;
        String userName1 = "";
        String userName2 = "";
        String message = "Player One: select your positive single digit number";
        String message2 = "Player Two: select your positive single digit number";
        String output = "";

        // gamemode message
        JOptionPane.showMessageDialog(null, "Two player selected");
        userName1 = JOptionPane.showInputDialog(null, "What is your name, player one");
        userName2 = JOptionPane.showInputDialog(null, "What is your name, player two");
        // game loop
        for (int f = 0; f < 5; f++) {
            userOne = 0;
            userTwo = 0;
            numP1 = 0;
            numP2 = 0;
            
           if (f % 2 == 0) {
               message = userName1 + ": select your positive single digit number \n to be subtracted against " + userName2 + " to receive your point";
               message2 = userName2 + ": select your positive single digit number \n to stop " + userName1 + " from getting a good score";
           } // if
           
           if (f % 2 == 1) {
               message = userName1 + ": select your positive single digit number \n to stop " + userName2 + " from getting a good score";
               message2 = userName2 + ": select your positive single digit number \n to be subtracted against " + userName1 + " to receive your point";
           } // if

            do {
                input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP1 = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message = "That's not a valid number, enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP1 < 0 || numP1 > 9) {
                    message = "The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);


            do {
                input = JOptionPane.showInputDialog(null, message2);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP2 = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message2 = "That's not a valid number, enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP2 < 0 || numP2 > 9) {
                    message2 = "The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);
            JOptionPane.showMessageDialog(null, userName1 + ", your number is " + numP1);
            JOptionPane.showMessageDialog(null, userName2 + ", your number is " + numP2);

            userTwo = numP1 - numP2;
            if (userTwo < 0) {
                userTwo = Math.abs(userTwo);
            } // if

            if (f == 0) {
                result2[0] = numP2;
            } // if
            result2[f + 1] = userTwo;
            output = "";
            for (int i = 0; i < result2.length; i++) {
                if (result2[i] != 0) {
                    output += (result2[i]);
                } // if

            } // for
            JOptionPane.showMessageDialog(null, userName2 + ", your result is: " + output);

            message = userName1 + ": select your positive single digit number \n to be subtracted against " + userName2 + " to receive your point";
            
            do {
                input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP1 = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message = userName1 + ": That's not a valid number. Please enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP1 < 0 || numP1 > 9) {
                    message = userName1 + ": The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);


            message2 = userName2 + ": select your positive single digit number \nto stop " + userName1 + " from getting a good score";
            do {
                input = JOptionPane.showInputDialog(null, message2);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP2 = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message2 = userName2 + ": That's not a valid number, enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP2 < 0 || numP2 > 9) {
                    message2 = userName2 + ": The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);
            JOptionPane.showMessageDialog(null, userName1 + ", your number is " + numP1);
            JOptionPane.showMessageDialog(null, userName2 + ", your number is " + numP2);

            userOne = numP2 - numP1;
            if (userOne < 0) {
                userOne = Math.abs(userOne);
            } // if
            if (f == 0) {
                result1[0] = numP1;
            } // if
            result1[f + 1] = userOne;
            output = "";
            for (int i = 0; i < result1.length; i++) {
                if (result1[i] != 0) {
                    output += (result1[i]);
                }

            }
            JOptionPane.showMessageDialog(null, userName1 + ", your result is: " + output);

            // calculate the whole score for both players
            for (int i = 0; i < result1.length; i++) {
                finalScore1 += result1[i];
                finalScore2 += result2[i];
            } // for

        } // for

        // determine who won the game
        if (finalScore1 > finalScore2) {
            won = userName1 + " won!";
        } else {
            won = userName2 + " won!";
        } // else


        // display score for both player
        message = userName1 + "'s score is ";
        message2 = userName2 + "'s score is ";
        JOptionPane.showMessageDialog(null, won + "\n" + message + finalScore1 + " \n" + message2 + finalScore2);

    } // playerTwo

} // class