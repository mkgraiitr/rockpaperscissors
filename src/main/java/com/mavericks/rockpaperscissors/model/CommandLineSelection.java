package com.mavericks.rockpaperscissors.model;

import com.mavericks.rockpaperscissors.enums.CommandLineMessage;
import com.mavericks.rockpaperscissors.enums.Shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.*;
import static com.mavericks.rockpaperscissors.util.CommandUtility.exitCommandLine;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class CommandLineSelection implements NextMoveStrategy {
    private Scanner scanner;

    public CommandLineSelection() {

    }

    public CommandLineSelection(Scanner userCommand) {
        this.scanner = userCommand;
    }

    @Override
    public String makeMove() {
        int userSelection = 0;
        int invalidAttempts = 0;
        boolean isCommandLineActive = true;
        while(isCommandLineActive && invalidAttempts<4){
            try{
                if(invalidAttempts ==3){
                    printOnConsole(EXCEED_INVALID_ATTEMPTS.getValue());
                    exitCommandLine(scanner);
                }
                printOnConsole(GAME_OPTIONS.getValue());
                userSelection = scanner.nextInt();
                if(userSelection>3 || userSelection<1){
                    printOnConsole(OUT_OF_RANGE.getValue());
                    invalidAttempts++;
                    scanner.nextLine();
                    isCommandLineActive = true;
                } else {
                    isCommandLineActive = false;
                }

            } catch(InputMismatchException inputException){
                invalidAttempts++;
                printOnConsole(INVALID_INPUT.getValue());
                scanner.nextLine();
            }
        }
        return userSelection == 1 ? Shapes.ROCK.getValue() : userSelection == 2 ? Shapes.PAPER.getValue() : Shapes.SCISSIORS.getValue();
    }


}
