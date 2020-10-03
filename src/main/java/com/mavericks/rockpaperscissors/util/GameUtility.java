package com.mavericks.rockpaperscissors.util;


import com.mavericks.rockpaperscissors.engine.PlayerStatistics;
import com.mavericks.rockpaperscissors.enums.Shapes;

public class GameUtility {
    public static String findWinner(PlayerStatistics playerOneStats, PlayerStatistics playerTwoStats) {
        if(((playerOneStats.getSelection().equals(Shapes.SCISSIORS.getValue())
                && playerTwoStats.getSelection().equals(Shapes.PAPER.getValue()))
                || (playerOneStats.getSelection().equals(Shapes.ROCK.getValue())
                && playerTwoStats.getSelection().equals(Shapes.SCISSIORS.getValue()))
                || (playerOneStats.getSelection().equals(Shapes.PAPER.getValue())
                && playerTwoStats.getSelection().equals(Shapes.ROCK.getValue())))){
            return playerOneStats.getId();
        } else {
            return playerTwoStats.getId();
        }
    }
}

