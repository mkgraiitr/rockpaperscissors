package com.mavericks.rockpaperscissors.util;


import com.mavericks.rockpaperscissors.engine.PlayerSelection;
import com.mavericks.rockpaperscissors.enums.Shapes;

public class GameUtility {
    public static String findWinner(PlayerSelection playerOneSelection, PlayerSelection playerTwoSelection) {
        if(((playerOneSelection.getPlayerSelection().equals(Shapes.SCISSIORS.getValue())
                && playerTwoSelection.getPlayerSelection().equals(Shapes.PAPER.getValue()))
                || (playerOneSelection.getPlayerSelection().equals(Shapes.ROCK.getValue())
                && playerTwoSelection.getPlayerSelection().equals(Shapes.SCISSIORS.getValue()))
                || (playerOneSelection.getPlayerSelection().equals(Shapes.PAPER.getValue())
                && playerTwoSelection.getPlayerSelection().equals(Shapes.ROCK.getValue())))){
            return playerOneSelection.getPlayerId();
        } else {
            return playerTwoSelection.getPlayerId();
        }
    }
}

