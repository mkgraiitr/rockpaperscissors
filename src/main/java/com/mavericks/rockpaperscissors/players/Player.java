package com.mavericks.rockpaperscissors.players;

import com.mavericks.rockpaperscissors.model.NextMoveStrategy;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    protected String playerId;
    protected String playerName;
    protected int totalScore;
    protected NextMoveStrategy nextMoveStrategy;

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

    @Override
    public String toString() {
        return "Player{" +
                " playerName = '" + playerName + '\'' +
                ", totalScore = " + totalScore +
                '}';
    }

}
