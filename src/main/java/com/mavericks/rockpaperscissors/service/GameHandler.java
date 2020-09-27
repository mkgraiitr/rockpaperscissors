package com.mavericks.rockpaperscissors.service;

import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.model.ScoringEngine;

import java.util.*;

import static com.mavericks.rockpaperscissors.enums.Score.*;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class GameHandler {
    private List<Player> gamePlayers = new ArrayList<>();
    public void playGame(List<Player> players) {
        ScoringEngine scoringEngine = new ScoringEngine();
        int round = 1;

        while (isGameOn(players)) {
            gamePlayers = scoringEngine.getPlayersWithRoundScore(players);
            //How to add round here??
            //gamePlayers.stream().map(player -> player.setCurrentRound(round)).forEach(System.out::println);
            for(Player player:players){
                player.setCurrentRound(round);
            }
            gamePlayers.forEach(System.out::println);
            round++;
        }

        Optional<Player> winner = gamePlayers.stream().max(Comparator.comparing(Player::getTotalScore));
        if(winner.isPresent()){
            printOnConsole(winner.get().getPlayerName() + " is the winner.");
        } else {
            printOnConsole(" The game is the tied.");
        }
    }

    public List<Player> getPlayers(){
        return gamePlayers;
    }

    private boolean isGameOn(List<Player> players){
        return players.stream().allMatch(player -> player.getTotalScore()< WINNING_SCORE.getValue());
    }

}
