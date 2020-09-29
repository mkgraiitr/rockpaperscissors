package com.mavericks.rockpaperscissors.engine;

import com.mavericks.rockpaperscissors.engine.PlayerScore;
import com.mavericks.rockpaperscissors.engine.Round;
import com.mavericks.rockpaperscissors.engine.ScoreBoard;
import com.mavericks.rockpaperscissors.engine.ScoringEngine;
import com.mavericks.rockpaperscissors.players.Player;

import java.util.Comparator;
import java.util.List;

import static com.mavericks.rockpaperscissors.enums.Score.WINNING_SCORE;

public class Game {

    private ScoreBoard scoreBoard = new ScoreBoard();
    private ScoringEngine scoringEngine = new ScoringEngine();

    public void playGame(List<Player> players) {
        boolean isGameOn = true;

        while (isGameOn) {
            Round round = scoringEngine.getPlayersWithRoundScore(players);
            List<PlayerScore> playerScores = round.getPlayerScores();
            for(PlayerScore playerScore:playerScores){

            }
            scoreBoard.setRounds(round);
            isGameOn = isGameOpen(round);
        }
        int lastRound = scoreBoard.getRounds().size() - 1;
        String winner = scoreBoard.getRounds().get(lastRound).getPlayerScores().stream().max(Comparator.comparing(PlayerScore::getTotalScore)).get().getPlayerId();
        if (winner != null) {
            System.out.println(winner + " is the winner.");
        } else {
            System.out.println(" The game is the tied.");
        }
    }

    private boolean isGameOpen(Round round) {
        return round.getPlayerScores().stream().allMatch(player -> player.getTotalScore() < WINNING_SCORE.getValue());
    }

}
