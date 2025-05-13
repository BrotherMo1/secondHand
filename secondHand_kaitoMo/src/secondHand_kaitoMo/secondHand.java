package secondHand_kaitoMo;

import java.io.BufferedReader;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.Color;
import java.io.*;

public class secondHand {

    public static void main(String[] args) {

        UIManager UI = new UIManager();
        UIManager.put("OptionPane.background", Color.white);
        UIManager.put("Panel.background", Color.white);

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
        String menu = "";

        // prepare menu for HTML
        JEditorPane outputScreen = new JEditorPane();
        outputScreen.setContentType("text/html");
        outputScreen.setEditable(false);
        outputScreen.setText(menu);


        menu = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
            "Second Hand Main Menu <br> choose an option:</div>";
        outputScreen.setText(menu);
        Object[] options = {
            "Instructions",
            "1P",
            "2P",
            "Quit"
        };
        choice = JOptionPane.showOptionDialog(null, outputScreen, "Choose something...",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        return choice;
    } // mainMenu

    public static void instructions() {

        String instructions = "";

        // prepare instructions for use of HTML
        JEditorPane outputScreen = new JEditorPane();
        outputScreen.setContentType("text/html");
        outputScreen.setEditable(false);
        outputScreen.setText(instructions);

        instructions =
            "<div style=\"background-color:;border-radius:20px;font-family:verdana\">" +
            "<h1><b>Second Hand</b></h1>\r" +
            "\r\n" +
            "<h2>Players: 1-2</h2>\r" +
            "\r" +
            "<h3>Objective</h3>\r" +
            "Build a several-digit number with a higher digit sum than your opponent.\r<br>" +
            "\r<br>" +
            "<h3>How to Play:</h3>\r" +
            "• Player A declares a one-digit number.\r<br>" +
            "• Player B subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r<br>" +
            "• Then Player B submits a number, and Player A does the same.\r<br>" +
            "• Player A then subtracts that number from the last digit on their calculator, takes the absolute value, and appends the result.\r<br>" +
            "• This process is then repeated until each player has the right amount of number. \r<br>" +
            "\r<br>" +
            "<h3>Example:</h3>\r" +
            "• Player A calls 4. Player B has 9 → |9 - 4| = 5 → B’s display: 95\r<br>" +
            "• Player B calls 9. Player A has 6 → |6 - 9| = 3 → A’s display: 63\r<br>" +
            "3. Continue alternating until both players have designated amount of numbers.\r<br>" +
            "4. Scoring: Add the digits of each digit. The player with the higher total wins.\r<br>" +
            "\r<br>" +
            "<h3>Example:</h3>\r" +
            "123456 → 1 + 2 + 3 + 4 + 5 + 6 = 21\r<br>" +
            "Winning the Game\r<br>" +
            "• Highest digit sum wins the game.\r<br>" +
            "\r<br>" +
            "<h3>Strategy Tips</h3>\r" +
            "• Watch your opponent’s pattern and try to disrupt it.\r<br>" +
            "• Choose numbers that either maximize your own total or minimize the opponent’s next move.\r<br>" +
            "\r<br>" +
            "</div>";
        outputScreen.setText(instructions);
        JOptionPane.showMessageDialog(null, outputScreen);

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
        int[] resultCom;
        String message = "";
        String won = "";
        String input = "";
        String output = "";
        String userName = "";
        String error = "";

        // make sure result1 has an odd length
        if (result1.length % 2 == 0) {
            result1 = new int[result1.length + 1];
        }
        resultCom = new int[result1.length];

        // prepare instructions for use of HTML
        JEditorPane outputScreen = new JEditorPane();
        outputScreen.setContentType("text/html");
        outputScreen.setEditable(false);




        outputScreen.setText(message);
        do {
            message = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                error + "What is your name?</div>";
            outputScreen.setText(message);
            userName = JOptionPane.showInputDialog(null, outputScreen);
            if (userName == null) {
                System.exit(0);
            } // if

            if (userName.length() == 0) {
                error = "Your name can't be empty <br>";
                continue;
            } // if
            break;
        } while (true);



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
        message = "There will be " + (result1.length - 1) + " turns";
        outputScreen.setText(message);
        JOptionPane.showMessageDialog(null, outputScreen);

        for (int i = 1; i < result1.length; i++) {

            // player input

            message = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                userName + " please select your positive single digit number.<br>This will be subtracted from the bot's number<brThe result will be your score.</div>";
            outputScreen.setText(message);
            do {

                input = JOptionPane.showInputDialog(null, outputScreen);
                outputScreen.setText(message);
                if (input == null) {
                    System.exit(0);
                } // if
                try {
                    numP = Integer.parseInt(input);
                } //try
                catch (Exception e) {
                    message = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                        "That's not a valid number, please enter a positive number. </div>";
                    continue;
                } //catch
                //check additional validity with if statements
                if (numP < 0 || numP > 9) {
                    message = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                        userName + "your number must be positive and under 10. Please try again. </div>";
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

                message = "<div style=\"color:#000;font-family:verdana;font-size:10px\">" +
                    "The Bot chose: " + com + "<br>" + userName + " you chose: " + numP + "<br>The bot's number is: " + output + "</div>";
                outputScreen.setText(message);
                JOptionPane.showMessageDialog(null, outputScreen);
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

                message = "<div style=\"color:#000;font-family:verdana;font-size:10px\">" +
                    "The Bot chose: " + com + "<br>" + userName + " you chose: " + numP + "<br>Your number is: " + output + "</div>";
                outputScreen.setText(message);
                JOptionPane.showMessageDialog(null, outputScreen);
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

        message = "<div style=\"color:#000;font-family:verdana;font-size:10px\">" +
            won + "<br>" + userName + ", your final score is : " + finalScoreP + "<br>The bot's final score is: " + finalScoreCom + "</div>";
        outputScreen.setText(message);
        JOptionPane.showMessageDialog(null, outputScreen);
    } // onePlayer



    public static void twoPlayer() {
        String input = "";
        int userOne = 0;
        int userTwo = 0;
        int numP1 = 0;
        int numP2 = 0;
        int[] result1 = new int[6];
        int[] result2 = new int[6];
        int finalScore1 = 0;
        int finalScore2 = 0;
        int turn = 0;
        String won = "";
        String userName1 = "";
        String userName2 = "";
        String msg1 = "";
        String msg2 = "";
        String summary = "";
        String error = "";

        JEditorPane outputScreen = new JEditorPane();
        outputScreen.setContentType("text/html");
        outputScreen.setEditable(false);

        // gamemode message
        outputScreen.setText("<div style='color:#000;font-family:verdana;font-size:10px'>Two player selected</div>");
        JOptionPane.showMessageDialog(null, outputScreen);

        // get player names - error checking as well
        outputScreen.setText(msg1);
        do {
            userName1 = "temp";
            msg1 = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                error + "Player one: What is your name?</div>";
            outputScreen.setText(msg1);
            userName1 = JOptionPane.showInputDialog(null, outputScreen);
            if (userName1 == null) {
                System.exit(0);
            } // if

            if (userName1.length() == 0) {
                error = "Your name can't be empty <br>";
                continue;
            } // if
            break;
        } while (true);

        error = "";
        outputScreen.setText(msg2);
        do {
            userName2 = "temp";
            msg2 = "<div style=\"color:#0000;font-family:verdana;font-size:10px\">" +
                error + "Player two: What is your name?</div>";
            outputScreen.setText(msg2);
            userName2 = JOptionPane.showInputDialog(null, outputScreen);
            if (userName2 == null) {
                System.exit(0);
            } // if

            if (userName2.length() == 0) {
                error = "Your name can't be empty <br>";
                continue;
            } // if
            break;

            // player input
        } while (true);

        for (int f = 0; f < 5; f++) {
            numP1 = 0;
            numP2 = 0;

            if (turn % 2 == 0) {
                msg1 = "<div style='color:#000;font-family:verdana;font-size:10px'>" + userName1 +
                    ", select your number to stop " + userName2 + " from scoring a high number.</div>";
                msg2 = "<div style='color:#000;font-family:verdana;font-size:10px'>" + userName2 +
                    ", select your number to be subtracted against " + userName1 + " to score.</div>";
            } else {
                msg1 = "<div style='color:#000;font-family:verdana;font-size:10px'>" + userName1 +
                    ", select your number to be subtracted against " + userName2 + " to score.</div>";
                msg2 = "<div style='color:#000;font-family:verdana;font-size:10px'>" + userName2 +
                    ", select your number to stop " + userName1 + " from scoring a high number.</div>";
            }

            // Player 1 input
            do {
                outputScreen.setText(msg1);
                input = JOptionPane.showInputDialog(null, outputScreen);
                if (input == null) System.exit(0);

                try {
                    numP1 = Integer.parseInt(input);
                    if (numP1 < 0 || numP1 > 9) throw new NumberFormatException();
                    break;
                } catch (Exception e) {
                    outputScreen.setText("<div style='color:#000;font-family:verdana;font-size:10px'>Invalid input. Enter a digit from 0 to 9.</div>");
                    JOptionPane.showMessageDialog(null, outputScreen);
                }
            } while (true);

            // Player 2 input
            do {
                outputScreen.setText(msg2);
                input = JOptionPane.showInputDialog(null, outputScreen);
                if (input == null) System.exit(0);

                try {
                    numP2 = Integer.parseInt(input);
                    if (numP2 < 0 || numP2 > 9) throw new NumberFormatException();
                    break;
                } catch (Exception e) {
                    outputScreen.setText("<div style='color:#000;font-family:verdana;font-size:10px'>Invalid input. Enter a digit from 0 to 9.</div>");
                    JOptionPane.showMessageDialog(null, outputScreen);
                }
            } while (true);

            // First scoring
            userTwo = Math.abs(numP1 - numP2);
            if (f == 0) result2[0] = numP2;
            result2[f + 1] = userTwo;

            String output = "";
            for (int i = 0; i < result2.length; i++) {
                if (result2[i] != 0) output += result2[i];
            }

            outputScreen.setText("<div style='color:#000;font-family:verdana;font-size:10px'>" + userName2 + ", your result is: " + output + "</div>");
            JOptionPane.showMessageDialog(null, outputScreen);

            // Reverse roles for second scoring
            int userOneScore = Math.abs(numP2 - numP1);
            if (f == 0) result1[0] = numP1;
            result1[f + 1] = userOneScore;

            output = "";
            for (int i = 0; i < result1.length; i++) {
                if (result1[i] != 0) output += result1[i];
            }

            outputScreen.setText("<div style='color:#000;font-family:verdana;font-size:10px'>" + userName1 + ", your result is: " + output + "</div>");
            JOptionPane.showMessageDialog(null, outputScreen);

            turn++;
        }

        // Calculate scores
        for (int i = 0; i < result1.length; i++) {
            finalScore1 += result1[i];
            finalScore2 += result2[i];
        }

        if (finalScore1 > finalScore2) {
            won = userName1 + " wins!";
        } else if (finalScore2 > finalScore1) {
            won = userName2 + " wins!";
        } else {
            won = "It's a tie!";
        }

        summary = "<div style='color:#000;font-family:verdana;font-size:10px'>" +
            won + "<br>" + userName1 + "'s score: " + finalScore1 +
            "<br>" + userName2 + "'s score: " + finalScore2 + "</div>";
        outputScreen.setText(summary);
        JOptionPane.showMessageDialog(null, outputScreen);
    }


} // class