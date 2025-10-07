package com.kvvssut.rps.service;

/**
 * Tracks scores for player and computer.
 */
public class Scoreboard {
    private int playerWins = 0;
    private int computerWins = 0;
    private int draws = 0;

    /**
     * Player wins a round.
     */
    public void recordPlayerWin() {
        playerWins++;
    }

    /**
     * Computer wins a round.
     */
    public void recordComputerWin() {
        computerWins++;
    }

    /**
     * Round is a draw.
     */
    public void recordDraw() {
        draws++;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getDraws() {
        return draws;
    }

    /**
     * Returns final result message.
     */
    public String getFinalResult() {
        if (playerWins > computerWins) return "You are the final WINNER!";
        if (computerWins > playerWins) return "Computer is the final WINNER!";
        return "The game ends in a DRAW!";
    }

    /**
     * Returns formatted scoreboard string.
     */
    @Override
    public String toString() {
        return String.format("Scoreboard -> You: %d | Computer: %d | Draws: %d",
                playerWins, computerWins, draws);
    }

}
