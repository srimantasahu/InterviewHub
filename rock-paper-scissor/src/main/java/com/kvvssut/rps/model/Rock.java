package com.kvvssut.rps.model;

/**
 * Represents Rock move.
 * Rock beats Scissors, loses to Paper, draws with Rock.
 */
public class Rock implements Move {

    @Override
    public Result compete(Move other) {
        if (other instanceof Scissors) return Result.WIN;
        if (other instanceof Paper) return Result.LOSE;
        return Result.DRAW;
    }

    @Override
    public String getName() {
        return "Rock";
    }

}
