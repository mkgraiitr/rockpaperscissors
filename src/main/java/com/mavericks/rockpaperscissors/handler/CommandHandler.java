package com.mavericks.rockpaperscissors.handler;

import com.mavericks.rockpaperscissors.engine.Game;
import com.mavericks.rockpaperscissors.enums.Type;
import com.mavericks.rockpaperscissors.players.Human;
import com.mavericks.rockpaperscissors.players.Player;
import com.mavericks.rockpaperscissors.players.Robot;

import java.util.*;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;
import static com.mavericks.rockpaperscissors.util.CommandUtility.printGameWinner;

public class CommandHandler implements Handler {
    private static Scanner scanner = new Scanner(System.in);

    public void handle() {
        System.out.println(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                System.out.println(ENTER_PLAYERS.getValue());
                String userInput = scanner.next();
                if (userInput.equals("q")) {
                    isCommandLineActive = false;
                    exitCommandLine(scanner);
                }
                List<Player> players = getPlayerDetails(Integer.parseInt(userInput));
                System.out.println(ENTER_ROUNDS.getValue());
                int rounds = scanner.nextInt();
                playRockPaperScissors(players, rounds);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getValue());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("error occurred " + e.getMessage() + ", " + INVALID_INPUT.getValue());
                scanner.nextLine();
            }
        }
    }

    private List<Player> getPlayerDetails(int userInput) {
        List<Player> players = new ArrayList<>();
        for (int playerNumber = 1; playerNumber <= userInput; playerNumber++) {
            System.out.println(ENTER_PLAYER_NAME.getValue());
            String playerName = scanner.next();
            System.out.println(ENTER_PLAYER_TYPE.getValue());
            int selectedPlayerType = scanner.nextInt();
            Type type = Type.getPlayerType(selectedPlayerType);
            Player player;
            switch (type) {
                case HUMAN:
                    player = new Human(String.valueOf(playerNumber), playerName, scanner);
                    players.add(player);
                    break;
                case ROBOT:
                    player = new Robot(String.valueOf(playerNumber), playerName);
                    players.add(player);
                    break;
                default:
                    System.out.println(TYPE_NOT_SUPPORTED.getValue());
                    scanner.nextLine();
            }
        }
        return players;
    }

    private void playRockPaperScissors(List<Player> players, int rounds) {
        Game game = new Game();
        Map<String, Integer> scores = game.play(players, rounds);
        printGameWinner(players, scores);
    }
}
