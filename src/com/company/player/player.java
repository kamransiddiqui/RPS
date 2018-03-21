package com.company.player;

import java.util.Scanner;

public abstract class player {
       public String name;

    abstract public String makeSelection(String prompt);
    //public int consecWin = 0;
    public int winGame = 0;
    boolean winner = false;

    public void playerName() {
        Scanner input = new Scanner(System.in);
        System.out.println("What's your name?");
        name = input.nextLine();
        if (name.length() == 0) {
            name = "Human";
        }
    }

    public void selectWin(boolean result) {
        winner = result;
        if (result) {
            winGame++;
        }
    }
}







