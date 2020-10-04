package com.mavericks.rockpaperscissors.util;

import com.mavericks.rockpaperscissors.players.Player;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.GameUtility.getPlayerName;

public class CommandUtility {

    public static void exitCommandLine(Scanner scanner) {
        scanner.close();
        System.out.println(QUITING.getValue());
        System.exit(0);
    }

    public static void printPlayerScores(List<Player> players, Map<String, Integer> playerScores, int currentRound) {
        playerScores.entrySet().forEach(player -> {
            System.out.println("At the end of round " + currentRound + ", Player " + getPlayerName(players, player.getKey()) + " scored :: " + player.getValue());
        });
    }

    public static void printGameWinner(List<Player> players, Map<String, Integer> playerScores) {
        Optional<String> playerId = GameUtility.getGameWinner(playerScores);
        if (playerId.isPresent()) {
            System.out.println(getPlayerName(players, playerId.get()) + WINNER.getValue());
        } else {
            System.out.println(GAME_TIED.getValue());
        }
    }

}
