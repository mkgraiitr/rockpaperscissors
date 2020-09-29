package com.mavericks.rockpaperscissors.util;


import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.enums.Shapes;

public class GameUtility {
    public static String findWinner(PlayerStatistics playerOneStats, PlayerStatistics playerTwoStats) {
        if(((playerOneStats.getPlayerSelection().equals(Shapes.SCISSIORS.getValue())
                && playerTwoStats.getPlayerSelection().equals(Shapes.PAPER.getValue()))
                || (playerOneStats.getPlayerSelection().equals(Shapes.ROCK.getValue())
                && playerTwoStats.getPlayerSelection().equals(Shapes.SCISSIORS.getValue()))
                || (playerOneStats.getPlayerSelection().equals(Shapes.PAPER.getValue())
                && playerTwoStats.getPlayerSelection().equals(Shapes.ROCK.getValue())))){
            return playerOneStats.getPlayerId();
        } else {
            return playerTwoStats.getPlayerId();
        }
    }
}

