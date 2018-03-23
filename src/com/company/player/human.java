package com.company.player; //import package

import java.util.Scanner; // import scanner

public class human extends player{ // human extends player class

    public String makeSelection(String prompt) {   //make selection is a string that takes in only string args
        String move;                     // initialize move
        Scanner input = new Scanner(System.in); // new scanner
        System.out.println(prompt);  // prints out the prompt arg
        move = input.nextLine();  //sets  our move string to take in an input to next line
        if (move.length() == 0) {   //  checking if a move was made if not return move invalid
            move = "invalid";
            System.out.println("Move Invalid");
        }
        return move;  // need this reutrn statement
    }
}
