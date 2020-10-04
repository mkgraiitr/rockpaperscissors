package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.strategy.NextMoveStrategy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class FixedMoveStrategy implements NextMoveStrategy {
    private String playerId;
    private Collection<String> playerOneMoves = Arrays.asList("ROCK", "SCISSORS", "ROCK", "SCISSORS", "PAPER");
    private Stack<String> playerOneFixedMoves = new Stack<>();
    private Collection<String> playerTwoMoves = Arrays.asList("ROCK", "PAPER", "SCISSORS", "PAPER", "PAPER");
    private Stack<String> playerTwoFixedMoves = new Stack<>();
    private Collection<String> playerThreeMoves = Arrays.asList("PAPER", "SCISSORS", "ROCK", "SCISSORS", "PAPER");
    private Stack<String> playerThreeFixedMoves = new Stack<>();

    public FixedMoveStrategy(String playerId) {
        this.playerId = playerId;
        playerOneFixedMoves.addAll(playerOneMoves);
        playerTwoFixedMoves.addAll(playerTwoMoves);
        playerThreeFixedMoves.addAll(playerThreeMoves);
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @Override
    public String makeMove() {
        switch (playerId) {
            case "1":
                return playerOneFixedMoves.pop();
            case "2":
                return playerTwoFixedMoves.pop();
            case "3":
                return playerThreeFixedMoves.pop();
            default:
                return "";
        }
    }
}
