package com.kvvssut.rps.utils;

import com.kvvssut.rps.model.Move;
import com.kvvssut.rps.model.Paper;
import com.kvvssut.rps.model.Rock;
import com.kvvssut.rps.model.Scissors;

/**
 * Converts hand signals to game moves.
 * Supported signals:
 * FIST -> Rock
 * OPEN_HAND -> Paper
 * INM_FINGERS -> Scissors
 */
public class HandSignalTranslator {

    /**
     * Translates user input into a Move.
     *
     * @param signal input string
     * @return corresponding Move or null if invalid
     */
    public static Move translate(String signal) {
        return switch (signal.toUpperCase()) {
            case "FIST" -> new Rock();
            case "OPEN_HAND" -> new Paper();
            case "INM_FINGERS" -> new Scissors();
            default -> null;
        };
    }

}
