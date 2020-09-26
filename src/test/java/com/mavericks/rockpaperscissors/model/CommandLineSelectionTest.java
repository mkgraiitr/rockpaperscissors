package com.mavericks.rockpaperscissors.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class CommandLineSelectionTest {
private Scanner scanner;
//    @Before
//    public void setUp() {
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//
//       scanner = new Scanner(in);
//    }
//    @InjectMocks
//    private CommandLineSelection commandLineSelection = new CommandLineSelection(scanner);
//    @Test
//    @Ignore
//    void test_makeMove() {
//        String playerSelection = commandLineSelection.makeMove();
//        assertNotNull(playerSelection);
//    }
}