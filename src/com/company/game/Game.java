package com.company.game;
import com.company.player.*;
import java.util.Scanner; //import scanner in


public class Game {
    player playerOne, playerTwo;
//    private int userScore;
//    private int computerScore;
//    private int numberOfGames;


    private void startGame() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (option != 3) {
            System.out.println("Type a number to select an option:");
            System.out.println(" 1. Play Rock Paper Scissors");
            System.out.println(" 2. Go to Game History");
            System.out.println(" 3. Return to Main Menu");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    newGame();
                    break;
                case 2:
                    getGameStats();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Entry, Chose either 1, 2, or 3 ");
                    break;
            }
        }
    }

    //to initialize main menu
    public void startGamescreen() {
        Scanner userInput = new Scanner(System.in); // Creating Scanner

        //  String play = "play";
        // int i = play.length();

        int play = 0;

        while (play != 4) {

            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("MAIN MENU");
            System.out.println("=====");
            System.out.println("1. Type '1' to play human");
            System.out.println("1. Type '2' to play computer");
            System.out.println("2. Type '3' to view your game history");
            System.out.println("Type '4' to stop playing");

            play = userInput.nextInt();
            userInput.nextLine();
//switch statement for menu control
            switch (play) {
                case 1:
                    this.human();
                    break;
                case 2:
                    this.computer();
                    break;
                case 3:
                    this.history();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }
    }


    private void human() {
        initPlay(false);
        startGame();
    }

    private void computer() {
        initPlay(true);
        startGame();

    }

    private void history() {

    }

    private void initPlay(boolean compPlayer) {
        playerOne = new human();
        playerOne.playerName();
        if (compPlayer) {
            playerTwo = new computer();
            playerTwo.playerName();
        } else {
            playerTwo = new human();
            playerTwo.playerName();
        }
    }


    private void getGameStats() {
        try {
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            System.out.printf("| %6s | %6s | %6s | %6s | %12s | %14s |\n",
                    "Player", "Wins", "Losses", "Player","Wins", "Losses");
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            System.out.printf("| %6s | %6s | %6s | %6s | %12s | %14s |\n",
                    playerOne.name, playerOne.winGame, playerTwo.winGame, playerTwo.name, playerTwo.winGame, playerOne.winGame);
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            System.out.printf("%s has won %s time(s) and has lost %s time(s).\n" +
                            "%s has won %s time(s) and has lost %s time(s).\n\n",
                    playerOne.name, playerOne.winGame, playerTwo.winGame, playerTwo.name, playerTwo.winGame, playerOne.winGame);
        } catch (NullPointerException npe) {
            System.out.println("Don't have any players");
        }
    }
    // Table Made for game history
    private void printDashes(int numberOfDashes) {
        for (int i = 0; i < numberOfDashes; i++) {
            System.out.print("-");
        }
    }
    //Space made so next player cant see first player move
    private void bigSpace(int biggerSpace){
        for (int i = 0; i < biggerSpace; i++) {
            System.out.print("                                            \n " + "                                            \n" + "                                            \n"+ "                                            \n"

            );

        }

    }

    private void newGame() {
        String gamerOne = playerOne.name + " please type Rock, Paper, Scissors to make your play";
        String gamerTwo = playerTwo.name + " please type Rock, Paper, Scissors to make your play";
        String moveOne = makeMove(playerOne, gamerOne);
        String moveTwo = makeMove(playerTwo, gamerTwo);


        if (moveOne == moveTwo) {
            System.out.printf("You both chose %s - it's a tie.\n\n", moveOne);

        } else if ((moveOne.equals("Rock") && moveTwo.equals("Scissors")) || (moveOne.equals("Scissors") && moveTwo.equals("Paper")) || (moveOne.equals("Paper") && moveTwo.equals("Rock"))) {
            System.out.printf("%s's %s BEATS %s's %s\n\n", playerOne.name, moveOne, playerTwo.name, moveTwo);
            playerOne.selectWin(true);
            playerTwo.selectWin(false);
        } else {
            System.out.printf("%s's %s BEATS %s's %s\n\n", playerTwo.name, moveTwo, playerOne.name, moveOne);
            playerOne.selectWin(false);
            playerTwo.selectWin(true);
        }
    }

    private String makeMove(player x, String prompt) {

        Boolean madeIn = true;
        String substr = "";

        while (madeIn) {
            substr = x.makeSelection(prompt);
            substr = substr.substring(0, 1).toUpperCase();
            if (substr.equals("R") || substr.equals("P") || substr.equals("S")) {
                madeIn = false;
                System.out.printf("%s just went.\n\n", x.name);
                System.out.print("+");
                bigSpace(20);
                System.out.println("+");
            } else {
                System.out.println("Please choose valid entry of R, P, S");
            }
        }
        switch (substr) {
            case "R":
                substr = "Rock";
                break;
            case "P":
                substr = "Paper";
                break;
            case "S":
                substr = "Scissors";
                break;
        }
        return substr;
    }

    private void exit() {
        System.out.println(" Goodbye Fraaands");

    }
}




