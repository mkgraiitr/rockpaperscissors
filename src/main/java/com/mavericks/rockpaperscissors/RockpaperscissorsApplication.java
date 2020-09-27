package com.mavericks.rockpaperscissors;

import com.mavericks.rockpaperscissors.controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class
RockpaperscissorsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RockpaperscissorsApplication.class, args);
        GameController.runUserCommands();
    }

}
