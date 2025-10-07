package com.kvvssut.rps.model;

/**
 * Represents Scissors move.
 * Scissors beat Paper, lose to Rock, draw with Scissors.
 */
public class Scissors implements Move {

    @Override
    public Result compete(Move other) {
        if (other instanceof Paper) return Result.WIN;
        if (other instanceof Rock) return Result.LOSE;
        return Result.DRAW;
    }

    @Override
    public String getName() {
        return "Scissors";
    }

}
