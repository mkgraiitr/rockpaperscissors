package com.mavericks.rockpaperscissors.model;

import com.mavericks.rockpaperscissors.enums.Shapes;

public class ScoringEngine {

    public int getCurrentRoundScore(String playerOneShape, String playerTwoShape) {
        return playerOneShape.equals(playerTwoShape) ? 0 : isPlayerOneWinner(playerOneShape, playerTwoShape) ? 1 : -1;
    }

    private boolean isPlayerOneWinner(String playerOneShape, String playerTwoShape) {
        return ((playerOneShape.equals(Shapes.SCISSIORS.getValue()) && playerTwoShape.equals(Shapes.PAPER.getValue()))
                || (playerOneShape.equals(Shapes.ROCK.getValue()) && playerTwoShape.equals(Shapes.SCISSIORS.getValue()))
                || (playerOneShape.equals(Shapes.PAPER.getValue()) && playerTwoShape.equals(Shapes.ROCK.getValue())));
    }

}
