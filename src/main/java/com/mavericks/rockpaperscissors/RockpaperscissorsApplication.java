package com.mavericks.rockpaperscissors;

import com.mavericks.rockpaperscissors.handler.CommandHandler;
import com.mavericks.rockpaperscissors.handler.Handler;

public class RockpaperscissorsApplication {
    public static void main(String[] args) {
        Handler handler = new CommandHandler();
        handler.handle();
    }

}
