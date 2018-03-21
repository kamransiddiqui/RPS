package com.company.player;

import java.util.Scanner;

public class human extends player{

    public String makeSelection(String prompt) {
        String move;
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        move = input.nextLine();
        if (move.length() == 0) {
            move = "invalid";
            System.out.println("Move Invalid");
        }
        return move;
    }
}
