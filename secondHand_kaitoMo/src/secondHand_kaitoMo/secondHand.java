
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

        String instructions = "Second Hand\r\n" +
            "\r\n" +
            "Players: 1-2\r\n" +
            "\r\n" +
            "Objective\r\n" +
            "Build a six-digit number with a higher digit sum than your opponent.\r\n" +
            "\r\n" +
            "How to Play:\r\n" +
            "• Player A declares a one-digit number.\r\n" +
            "• Player B subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r\n" +
            "• Then Player B submits a number, and Player A does the same.\r\n" +
            "• Player A then subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r\n" +
            "• This process is then repeated until each player has a six-digit number. \r\n" +
            "\r\n" +
            "Example:\r\n" +
            "• Player A calls 4. Player B has 9 → |9 - 4| = 5 → B’s display: 95\r\n" +
            "• Player B calls 9. Player A has 6 → |6 - 9| = 3 → A’s display: 63\r\n" +
            "3. Continue alternating until both players have six-digit numbers.\r\n" +
            "4. Scoring: Add the digits of each six-digit number. The player with the higher total wins.\r\n" +
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
        int difficulty = 0;
        int finalScoreCom = 0;
        int finalScoreP = 0;
        int turn = 0;
        int[] result1 = new int[11];
        int[] resultCom = new int[11];
        String message = "";
        String input = "";
        String output = "";

        JOptionPane.showMessageDialog(null, "Single player selected \n You are going first");

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

        for (int i = 0; i < result1.length; i++) {

            // player input
            message = "Player: please select your positive single digit number";
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
                    message = "Your number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);

            // computer input
            rand = (int)(Math.random() * 11);
            switch (choice) {
                case 0:

                    // user picked easy
                    difficulty = 1;
                    if (turn % 2 == 1) {
                        difficulty = 3;
                    }

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

                    // user picked medium
                    difficulty = 2;

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

                case 2:
                    // user picked hard
                    difficulty = 3;
                    if (turn % 2 == 1) {
                        difficulty = 1;
                    }
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
            System.out.println("com is " + com);
            System.out.println("diff is " + Math.abs((numP - com)));
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
                result1[i + 1] = user;
                output = "";
                for (int f = 0; f < result1.length; f++) {
                    if (result1[f] != 0) {
                        output += (result1[f]);
                    } // if

                } // for

                JOptionPane.showMessageDialog(null, "The Bot chose: " + com + "\nYou chose: " + numP + "\nYour number is: " + output);
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

                JOptionPane.showMessageDialog(null, "The Bot chose: " + com + "\nYou chose: " + numP + "\nThe bot's score is: " + output);
            } // else

            turn++;

        } // for

        // calculate the whole score for both players
        for (int f = 0; f < result1.length; f++) {
            finalScoreP += result1[f];
            finalScoreCom += resultCom[f];
        } // for

        JOptionPane.showMessageDialog(null, "Your final score is : " + finalScoreP + "\nThe bot's final score is: " + finalScoreCom);
    } // onePlayer



    public static void twoPlayer() {
        // declare variables
        String input = "";
        int userOne = 0;
        int userTwo = 0;
        int numP1 = 0;
        int numP2 = 0;
        int[] result1 = new int[5];
        int[] result2 = new int[5];
        int finalScore1 = 0;
        int finalScore2 = 0;
        String won;
        String message = "Player One: select your positive single digit number";
        String message2 = "Player Two: select your positive single digit number";
        String output = "";

        // gamemode message
        JOptionPane.showMessageDialog(null, "Two player selected");

        // game loop
        for (int f = 0; f < 5; f++) {
            userOne = 0;
            userTwo = 0;
            numP1 = 0;
            numP2 = 0;
            message = "Player One: select your positive single digit number";
            message2 = "Player Two: select your positive single digit number";
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

            message = "Player One: select your positive single digit number";
            message2 = "Player Two: select your positive single digit number";
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
            for (int i = 0; i < result2.length; i++) {
                if (result2[i] != 0) {
                    output += (result2[i]);
                } // if

            } // for
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
                catch (Exception e) {
                    message = "Player One: That's not a valid number. Please enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP1 < 0 || numP1 > 9) {
                    message = "Player One: The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);


            message = "Player Two: select your positive single digit number";
            do {
                input = JOptionPane.showInputDialog(null, message);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP2 = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message = "Player Two: That's not a valid number, enter a positive number. ";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP2 < 0 || numP2 > 9) {
                    message = "Player Two: The number must be positive and under 10. Please try again. ";
                    continue;
                } // if
                break;
            } while (true);
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
            for (int i = 0; i < result1.length; i++) {
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

        } // for

        // determine who won the game
        if (finalScore1 > finalScore2) {
            won = "Player One won!";
        } else {
            won = "Player Two won!";
        } // else


        // display score for both player
        message = "Player One's score is ";
        message2 = "Player Two's score is ";
        JOptionPane.showMessageDialog(null, won);
        JOptionPane.showMessageDialog(null, message + finalScore1 + " " + message2 + finalScore2);

    } // playerTwo

} // class