package com.kvvssut.rps.model;

/**
 * Interface representing a Move in Rock–Paper–Scissors.
 * Strategy pattern is applied to allow adding new moves in the future.
 */
public interface Move {

    /**
     * Competes against another move.
     *
     * @param other the opponent's move
     * @return the outcome (WIN, LOSE, DRAW)
     */
    Result compete(Move other);

    /**
     * Returns the move's name.
     *
     * @return move name
     */
    String getName();

}
