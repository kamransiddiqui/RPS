package com.company;

import com.company.game.Game;//importing from the game file in the path ./com.company/game/Game

public class Main extends Game {   // Main is an extension of the game class, whole program is run through the main method

    public static void main(String[] args) {  // Main method is what brings everything together, Necessary
        Game gamer = new Game(); // Game class is creating a new game named gamer
        gamer.startGamescreen(); // gamer initializes startGamescreen from Game.java

        }
}


/* referenced Logic :

https://code.sololearn.com/ck4WKO9NppjW/#java
https://gist.github.com/forty8bits/1793829
http://www.chegg.com/homework-help/questions-and-answers/making-game-rock-paper-scissors-assigment-create-roshambo-rock-paper-scissors-game-console-q8022909
https://stackoverflow.com/questions/13321627/adding-a-while-loop-to-make-a-user-input-rock-paper-scissors-game-repeat-until-t
etc.  lot more stackoverflow

*/
