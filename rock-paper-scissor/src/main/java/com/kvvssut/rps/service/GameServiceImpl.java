package com.kvvssut.rps.service;

import com.kvvssut.rps.model.Move;
import com.kvvssut.rps.model.Result;
import com.kvvssut.rps.utils.HandSignalTranslator;

import java.util.Scanner;

/**
 * Concrete implementation of GameService.
 * Handles game loop, input, and scoring.
 */
public class GameServiceImpl implements GameService {
    private final Scanner scanner = new Scanner(System.in);
    private final Scoreboard scoreboard = new Scoreboard();

    @Override
    public void play(int rounds) {
        for (int i = 1; i <= rounds; i++) {
            System.out.printf("%nRound %d/%d%n", i, rounds);
            System.out.print("Enter your move (FIST, OPEN_HAND, INM_FINGERS): ");
            String input = scanner.nextLine().trim();
            Move playerMove = HandSignalTranslator.translate(input);

            if (playerMove == null) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            Move computerMove = MoveFactory.randomMove();
            System.out.println("You chose: " + playerMove.getName());
            System.out.println("Computer chose: " + computerMove.getName());

            Result result = playerMove.compete(computerMove);
            switch (result) {
                case WIN -> {
                    System.out.println("You WIN this round!");
                    scoreboard.recordPlayerWin();
                }
                case LOSE -> {
                    System.out.println("Computer WINS this round!");
                    scoreboard.recordComputerWin();
                }
                case DRAW -> {
                    System.out.println("It's a DRAW!");
                    scoreboard.recordDraw();
                }
            }

            System.out.println(scoreboard);
        }

        System.out.println("\n=== FINAL RESULT ===");
        System.out.println(scoreboard.getFinalResult());
        System.out.println(scoreboard);
    }

}
