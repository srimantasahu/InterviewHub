package com.kvvssut.rps;

import com.kvvssut.rps.ui.GameRunner;

/**
 * Entry point for the Rock–Paper–Scissors console game.
 */
public class Main {

    /**
     * Starts the game by delegating to {@link GameRunner}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new GameRunner().start();
    }

}
