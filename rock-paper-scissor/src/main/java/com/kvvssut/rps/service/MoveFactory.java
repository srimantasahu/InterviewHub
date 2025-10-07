package com.kvvssut.rps.service;

import com.kvvssut.rps.model.Move;
import com.kvvssut.rps.model.Paper;
import com.kvvssut.rps.model.Rock;
import com.kvvssut.rps.model.Scissors;

import java.util.Random;

/**
 * Factory to generate random moves for the computer.
 */
public class MoveFactory {
    private static final Random random = new Random();

    /**
     * Generates a random move: Rock, Paper, or Scissors.
     *
     * @return a Move instance
     */
    public static Move randomMove() {
        int choice = random.nextInt(3);
        return switch (choice) {
            case 0 -> new Rock();
            case 1 -> new Paper();
            default -> new Scissors();
        };
    }

}
