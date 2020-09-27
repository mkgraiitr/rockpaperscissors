package com.mavericks.rockpaperscissors.controller;

import com.mavericks.rockpaperscissors.engine.ScoreBoard;
import com.mavericks.rockpaperscissors.enums.Score;
import com.mavericks.rockpaperscissors.strategy.CommandLineSelection;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;
import com.mavericks.rockpaperscissors.service.GameHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class Game {

    private static Scanner scanner;
    private ScoreBoard scoreBoard = new ScoreBoard();

    public static void runUserCommands() {
        List<Player> players = new ArrayList<>();
        scanner = new Scanner(System.in);
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
                    } else {
                        player = new Robot();
                        player.setNextMoveStrategy(new CommandLineSelection(scanner));
                        player.setPlayerName(userName);
                    }
                    players.add(player);
                }
                GameHandler gameHandler = new GameHandler();
                gameHandler.playGame(players);

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

}
