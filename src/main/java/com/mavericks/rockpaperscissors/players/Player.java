package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.strategy.NextMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerId;
    private String playerName;
    private int currentRound;
    private int totalScore;
    private NextMoveStrategy nextMoveStrategy;
    private String currentMove;
    private List<String> historicalMove = new ArrayList<>();

    public void updateScore(int currentRoundScore) {
        totalScore += currentRoundScore;
    }

    public void setNextMoveStrategy(NextMoveStrategy nextMoveStrategy) {
        this.nextMoveStrategy = nextMoveStrategy;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerMove(){
        return nextMoveStrategy.makeMove();
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<String> getHistoricalMove() {
        return historicalMove;
    }

    public void updateHistoricalMove(String move) {
        this.currentMove = move;
        historicalMove.add(move);
    }

    public String getCurrentMove() {
        return currentMove;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    @Override
    public String toString() {
        return " player '" + playerName + '\'' +
                " selected " + getCurrentMove() +
                " and scored in total = " + totalScore +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
