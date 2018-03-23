package com.company.player;

import java.util.concurrent.ThreadLocalRandom; // Random number generator for shared random objects, threadlocalrandom is ususally for muti threading bt here we use it for bounds


public class computer extends player{  //extention of playerclass
    public String makeSelection(String prompt) {   //makeSelection method takes in a string and returns a string
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);  // new int variable set to random number between 1-4, using threadlocalrandom so there is no confusion of our bounds
        switch (randomNum) {  // using randomly generated number we return one of the case switches
            case 1:
                return "R";
            case 2:
                return "P";
            default:
                return "S";
        }
    }

    public void playerName() { // playerName is a method that ronly contains the name for the ccompOlayer which is always computer, cant change it in abstract
        name = "Computer";
    }
}

