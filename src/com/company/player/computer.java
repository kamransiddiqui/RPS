package com.company.player;

import java.util.concurrent.ThreadLocalRandom; // Random number generator for shared random objects

public class computer extends player{
    public String makeSelection(String prompt) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        switch (randomNum) {
            case 1:
                return "R";
            case 2:
                return "P";
            default:
                return "S";
        }
    }

    public void playerName() {
        name = "Computer";
    }
}

