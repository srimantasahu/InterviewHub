package com.kvvssut.rps.ui;

import com.kvvssut.rps.service.GameService;
import com.kvvssut.rps.service.GameServiceImpl;

import java.util.Scanner;

/**
 * Handles console input/output and starts the game.
 */
public class GameRunner {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the game.
     */
    public void start() {
        System.out.println("=== Welcome to Rock-Paper-Scissors ===");
        System.out.print("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // consume newline

        GameService game = new GameServiceImpl();
        game.play(rounds);

        System.out.println("\nThanks for playing!");
    }

}
