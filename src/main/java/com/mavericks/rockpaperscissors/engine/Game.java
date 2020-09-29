package com.mavericks.rockpaperscissors.engine;

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
            System.out.println(round);
            //round.getPlayerStatistics().get().forEach(System.out::println);
            scoreBoard.setRounds(round);
            isGameOn = checkIfGameOn(round);
        }
        int lastRound = scoreBoard.getRounds().size() - 1;
        String winner = scoreBoard.getRounds().get(lastRound).getPlayerStatistics().stream().max(Comparator.comparing(PlayerStatistics::getTotalScore)).get().getPlayerId();
        if (winner != null) {
            System.out.println(winner + " is the winner.");
        } else {
            System.out.println(" The game is the tied.");
        }
    }

    private boolean checkIfGameOn(Round round) {
        return round.getPlayerStatistics().stream().allMatch(player -> player.getTotalScore() < WINNING_SCORE.getValue());
    }

}
