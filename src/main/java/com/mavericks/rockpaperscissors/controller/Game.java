package com.mavericks.rockpaperscissors.controller;

import com.mavericks.rockpaperscissors.engine.PlayerScore;
import com.mavericks.rockpaperscissors.engine.Round;
import com.mavericks.rockpaperscissors.engine.ScoreBoard;
import com.mavericks.rockpaperscissors.engine.ScoringEngine;
import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;

import java.util.*;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.enums.Score.WINNING_SCORE;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class Game {

    private static Scanner scanner = new Scanner(System.in);
    private ScoreBoard scoreBoard = new ScoreBoard();

    public static void runUserCommands() {
        List<Player> players = new ArrayList<>();
        System.out.println(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                System.out.println(CHOOSE_PLAYERS.getValue());
                int userInput = scanner.nextInt();
                for (int playerDeatils = 0; playerDeatils < userInput; playerDeatils++) {
                    System.out.println(ENTER_USERNAME.getValue());
                    String userName = scanner.next();
                    System.out.println(ENTER_USERTYPE.getValue());
                    int userType = scanner.nextInt();
                    Player player;
                    if (userType == 1) {
                        player = new Human();
                        player.setPlayerName(userName);
                        player.setNextMoveStrategy(new CommandLineSelection(scanner));
                    } else {
                        player = new Robot();
                        player.setPlayerName(userName);
                    }
                    players.add(player);
                }
                Game game = new Game();
                game.playGame(players);

                if (userInput == 3) {
                    isCommandLineActive = false;
                    exitCommandLine(scanner);
                }

            } catch (InputMismatchException e) {
                printOnConsole(INVALID_INPUT.getValue());
                scanner.nextLine();
            } catch (Exception e) {
                printOnConsole(e.getMessage());
                exitCommandLine(scanner);
            }
        }
    }

    public void playGame(List<Player> players) {
        ScoringEngine scoringEngine = new ScoringEngine();
        ScoreBoard scoreBoard = new ScoreBoard();
        Round round = new Round();
        while (isGameOn(round)) {
            round = scoringEngine.getPlayersWithRoundScore(players);
            //How to add round here??
            //gamePlayers.stream().map(player -> player.setCurrentRound(round)).forEach(System.out::println);
            scoreBoard.setRounds(round);
        }
        int lastRound = scoreBoard.getRounds().size();
        String winner = scoreBoard.getRounds().get(lastRound).getPlayerScores().stream().max(Comparator.comparing(PlayerScore::getTotalScore)).get().getPlayerId();
        if (winner != null) {
            System.out.println(winner + " is the winner.");
        } else {
            System.out.println(" The game is the tied.");
        }
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    private boolean isGameOn(Round round) {
        return round.getPlayerScores().stream().allMatch(player -> player.getTotalScore() < WINNING_SCORE.getValue());
    }

}
