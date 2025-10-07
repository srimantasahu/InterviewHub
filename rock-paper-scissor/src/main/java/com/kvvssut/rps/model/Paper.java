package com.kvvssut.rps.model;

/**
 * Represents Paper move.
 * Paper beats Rock, loses to Scissors, draws with Paper.
 */
public class Paper implements Move {

    @Override
    public Result compete(Move other) {
        if (other instanceof Rock) return Result.WIN;
        if (other instanceof Scissors) return Result.LOSE;
        return Result.DRAW;
    }

    @Override
    public String getName() {
        return "Paper";
    }

}
