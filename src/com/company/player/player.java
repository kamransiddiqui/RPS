package com.company.player;

import java.util.Scanner;
/*
The super class of all the players.
        * All players should reference or extend this class for incrementing winning state and name. */

public abstract class player {   // abstract class so you cant instantiate anywhere else, we also must have a subclass that implement it , in our case this is the main player
       public String name;  // create a public string variable called name

    abstract public String makeSelection(String prompt); // make selection method is also abstract for similar reasons as above
    public int winGame = 0;    // new integer variable set to zero
    boolean winner = false;   // winner boolean started off as false

    public void playerName() {                    // player name method has a new scanner called input
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");      //askiing our name
        name = input.nextLine();                      // which is taken and put on nextline
        if (name.length() == 0) {                   // Error catching so we have a default name if you dont chose one
            name = "Human";
        }
    }

    public void selectWin(boolean result) {     // method that is incrementing a counter for respective player
        winner = result;
        if (result) {
            winGame++;
        }
    }
}







