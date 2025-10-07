package com.kvvssut.rps.service;

/**
 * Defines the contract for the game service.
 */
public interface GameService {

    /**
     * Runs the game for n rounds.
     *
     * @param rounds total rounds
     */
    void play(int rounds);

}
