package com.kvvssut.rps;

import com.kvvssut.rps.service.Scoreboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for Scoreboard class.
 * Validates proper score tracking and final result messages.
 */
public class ScoreboardTest {

    @Test
    void tracksScoresCorrectly() {
        Scoreboard sb = new Scoreboard();
        sb.recordPlayerWin();
        sb.recordComputerWin();
        sb.recordDraw();

        assertEquals(1, sb.getPlayerWins(), "Player wins should be 1");
        assertEquals(1, sb.getComputerWins(), "Computer wins should be 1");
        assertEquals(1, sb.getDraws(), "Draws should be 1");
    }

    @Test
    void finalResultMessage() {
        Scoreboard sb = new Scoreboard();
        sb.recordPlayerWin();
        sb.recordComputerWin();
        assertEquals("The game ends in a DRAW!", sb.getFinalResult(), "Final result should reflect a draw");
    }

}
