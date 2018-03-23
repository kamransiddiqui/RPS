package com.company.game;
import com.company.player.*;// import whole player package
import java.util.Scanner; //import scanner in from java util


public class Game {
    player playerOne, playerTwo;
//    private int userScore;
//    private int computerScore;
//    private int numberOfGames;


    private void startGame() {
        int option = 0;  //initialize an int variable and set it to zero
        Scanner input = new Scanner(System.in);  // create a new scanner and call it input, System.in(inputstream) is the keyboard entry which is held in our input variable.
        while (option != 3) { //as long as option does not equal 3, run this while loop
            System.out.println("Type a number to select an option:");// print these lines out
            System.out.println(" 1. Play Rock Paper Scissors");
            System.out.println(" 2. Go to Game History");
            System.out.println(" 3. Return to Main Menu");
            option = input.nextInt(); // this waits for our users input
            input.nextLine(); //go to next line
            switch (option) {   ///This is our switch statement it takes in our option input
                case 1:
                    newGame();  // if we chose 1 it executes new game method
                    break;
                case 2:
                    getGameStats(); // if we chose 2 it executes getGameStats method
                    break;
                case 3:         // else it for 3 it will break out back to menu
                    break;
                default:
                    System.out.println("Invalid Entry, Chose either 1, 2, or 3 ");  // any other option it will return default message
                    break;
            }
        }
    }

    //to initialize main menu
    public void startGamescreen() {
        Scanner userInput = new Scanner(System.in); // Creating Scanner

        //  String play = "play";
        // int i = play.length();

        int play = 0;  // initialize our int play variable 0

        while (play != 4) {  // as long as it isn't 4  run while loop

            System.out.println("Welcome to Rock Paper Scissors!"); // printing out menu here
            System.out.println("MAIN MENU");
            System.out.println("=====");
            System.out.println("1. Type '1' to play human");
            System.out.println("1. Type '2' to play computer");
            System.out.println("2. Type '3' to view your game history");
            System.out.println("Type '4' to stop playing");

            play = userInput.nextInt();  // here we set our play variable to the input we get from our users input
            userInput.nextLine(); //goes to nextline
                            //switch statement for menu control, takes in play
            switch (play) {
                case 1:               // if play is 1 it will execute the following
                    this.human();    // this.human calls the human method using the this operator which signifies that it isnt local
                    break;
                case 2:               // if play is 2 it will execute the following
                    this.computer();
                    break;
                case 3:               // if play is 3 it will execute the following
                    this.history();
                    break;
                case 4:               //if play is 4 it will execute the following
                    this.exit();
                    break;
                default:              // else input is invalid
                    System.out.println("Invalid Entry");
                    break;
            }
        }
    }


    private void human() {
        initPlay(false);            // human method calls initPlay first and passes false boolean operator for argument
        startGame();                            // after which it executes startGame method
    }

    private void computer() {
        initPlay(true);            // computer method calls initPlay first and passes true boolean operator for argument
        startGame();                           // after which it executes startGame method

    }

    private void history() {

    }

    private void initPlay(boolean compPlayer) {      // Init play is a method that takes in a boolean arg
        playerOne = new human();                     // we created a new variable called player one and  set it to the human method
        playerOne.playerName();                      // using the dot operator we set the player one variable to the call the method playername on player one
        if (compPlayer) {                            // so if the compPlayer argument is true we will instantiate a new Player which is a computer, as seen in computer method above
            playerTwo = new computer();
            playerTwo.playerName();
        } else {                                    // otherwise we set it to human and run the playername method on this new human player
            playerTwo = new human();
            playerTwo.playerName();
        }
    }


    private void getGameStats() {                                    // this is to create history
        try {                                      // try catch statement to make sure we have two players
            System.out.print("+");                  // creating a table using + and dashes
            printDashes(68);
            System.out.println("+");
            System.out.printf("| %6s | %6s | %6s | %6s | %12s | %14s |\n",                 // print f statement to replace the variables listed below and populate that info in table
                    "Player", "Wins", "Losses", "Player","Wins", "Losses");
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            System.out.printf("| %6s | %6s | %6s | %6s | %12s | %14s |\n",
                    playerOne.name, playerOne.winGame, playerTwo.winGame, playerTwo.name, playerTwo.winGame, playerOne.winGame); // this will populate lower half of table with player win and loss info
            System.out.print("+");
            printDashes(68);
            System.out.println("+");
            System.out.printf("%s has won %s time(s) and has lost %s time(s).\n" +
                            "%s has won %s time(s) and has lost %s time(s).\n\n",
                    playerOne.name, playerOne.winGame, playerTwo.winGame, playerTwo.name, playerTwo.winGame, playerOne.winGame);   // also prints out new statement which is populated about more info
        } catch (NullPointerException npe) {
            System.out.println("Don't have any players");    // returns if NPE
        }
    }
    // Table Made for game history
    private void printDashes(int numberOfDashes) {
        for (int i = 0; i < numberOfDashes; i++) {
            System.out.print("-");
        }
    }
    //Space made so next player cant see first player move, primitive solution to  not allowing first players move get revelaed
    private void bigSpace(int biggerSpace){
        for (int i = 0; i < biggerSpace; i++) {
            System.out.print("                                            \n " + "                                            \n" + "                                            \n"+ "                                            \n"

            );

        }

    }

    private void newGame() {                                  // new game method takes two players and  initiates the game
        String gamerOne = playerOne.name + " please type Rock, Paper, Scissors to make your play";
        String gamerTwo = playerTwo.name + " please type Rock, Paper, Scissors to make your play";
        String moveOne = makeMove(playerOne, gamerOne); // string moveOne variable is set equal to make move method taking the player variable as first arg and the two new variables are going to be passed as the string prompt for the make move method below
        String moveTwo = makeMove(playerTwo, gamerTwo);


        if (moveOne == moveTwo) {                           // if both the moves are the same we give tie notice
            System.out.printf("You both chose %s - it's a tie.\n\n", moveOne);

        } else if ((moveOne.equals("Rock") && moveTwo.equals("Scissors")) || (moveOne.equals("Scissors") && moveTwo.equals("Paper")) || (moveOne.equals("Paper") && moveTwo.equals("Rock"))) {
            System.out.printf("%s's %s BEATS %s's %s\n\n", playerOne.name, moveOne, playerTwo.name, moveTwo);// otherwise, using OR function we check all possible winning circumstances and return winner for player 1
            playerOne.selectWin(true);  // then we run select win essentilly incrementing our history through this
            playerTwo.selectWin(false);
        } else {
            System.out.printf("%s's %s BEATS %s's %s\n\n", playerTwo.name, moveTwo, playerOne.name, moveOne);
            playerOne.selectWin(false); // in all other scenarios  player 2 wins
            playerTwo.selectWin(true);
        }
    }

    private String makeMove(player x, String prompt) {   // make move takes two arguments one is a player variable and the othe is a string prompt

        Boolean madeIn = true; // instantiate made in as boolean value as true
        String substr = "";    // empty string

        while (madeIn) {        //as long as made in is true run while
            substr = x.makeSelection(prompt);         // string substr variable takes the player in make move args and runs the make selection prompt
            substr = substr.substring(0, 1).toUpperCase();     // this variable has an uppercase letter, which signifies the choosing
            if (substr.equals("R") || substr.equals("P") || substr.equals("S")) {     // runs if u chose RPS
                madeIn = false;     // sets made in false so next person can go
                System.out.printf("%s just went.\n\n", x.name);  // shows u who went
                System.out.print("+");
                bigSpace(20);   // just line and dashes
                System.out.println("+");
            } else {
                System.out.println("Please choose valid entry of R, P, S");   // otherwise you mustve entered a wrong input mesage
            }
        }
        switch (substr) {   // this sweitch statement looks for the first letter and returns the result
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

    private void exit() {          // exit statement runs as long input of 4 from the startgamescreen method
        System.out.println(" Goodbye Fraaands");

    }
}




