package com.mavericks.rockpaperscissors.enums;

public enum CommandLineMessage {

    INVALID_INPUT("Please provide valid input\n"),
    TYPE_NOT_SUPPORTED("The entered player type is not supported for now, " +
            "Please enter player type: enter 1 for Human and 2 for Computer "),
    EXCEED_INVALID_ATTEMPTS("Sorry you have made 3 invalid attempts.\n"),
    GAME_OPTIONS("\n enter 1 for ROCK, 2 for PAPER and 3 for SCISSORS:: \n"),
    OUT_OF_RANGE("The entered value is not in range.\n"),
    WELCOME_MSG("Dear user, welcome to rock, paper and scissors game. \n "),
    ENTER_PLAYERS("Dear user, please enter number of players, choose 0 to quit:: "),
    ENTER_ROUNDS("Dear user, please enter number of rounds you want to play:: "),
    ENTER_PLAYER_NAME("Please enter player name:: "),
    ENTER_PLAYER_TYPE("Please enter player type: enter 1 for Human and 2 for Computer "),
    GAME_TIED("The game is tied."),
    WINNER("is the winner. \n"),
    INVALID_ATTEMPTS(""),
    QUITING("Thanks for playing rock paper scissors with us. Hope you enjoyed!!\n");

    private final String value;

    CommandLineMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

