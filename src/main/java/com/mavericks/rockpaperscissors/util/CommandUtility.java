package com.mavericks.rockpaperscissors.util;

import java.util.Scanner;

import static com.mavericks.rockpaperscissors.enums.CommandLineMessage.QUITING;
import static com.mavericks.rockpaperscissors.util.GameUtility.printOnConsole;

public class CommandUtility {

    public static void exitCommandLine(Scanner scanner) {
        scanner.close();
        printOnConsole(QUITING.getValue());
        System.exit(0);
    }

}
