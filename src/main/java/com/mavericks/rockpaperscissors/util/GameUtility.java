package com.mavericks.rockpaperscissors.util;


import com.mavericks.rockpaperscissors.enums.Shapes;

public class GameUtility {
    public static void printOnConsole(String value){
        System.out.println(value);
    }

    public static boolean isPlayerOneWinner(String playerOneShape, String playerTwoShape) {
        return ((playerOneShape.equals(Shapes.SCISSIORS.getValue()) && playerTwoShape.equals(Shapes.PAPER.getValue()))
                || (playerOneShape.equals(Shapes.ROCK.getValue()) && playerTwoShape.equals(Shapes.SCISSIORS.getValue()))
                || (playerOneShape.equals(Shapes.PAPER.getValue()) && playerTwoShape.equals(Shapes.ROCK.getValue())));
    }
}

