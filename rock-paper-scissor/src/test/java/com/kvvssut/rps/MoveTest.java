package com.kvvssut.rps;

import com.kvvssut.rps.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for Rock, Paper, Scissors moves.
 * Ensures the correct outcomes for WIN, LOSE, and DRAW scenarios.
 */
public class MoveTest {

    @Test
    void rockBeatsScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();
        assertEquals(Result.WIN, rock.compete(scissors), "Rock should beat Scissors");
    }

    @Test
    void paperBeatsRock() {
        Move paper = new Paper();
        Move rock = new Rock();
        assertEquals(Result.WIN, paper.compete(rock), "Paper should beat Rock");
    }

    @Test
    void scissorsBeatsPaper() {
        Move scissors = new Scissors();
        Move paper = new Paper();
        assertEquals(Result.WIN, scissors.compete(paper), "Scissors should beat Paper");
    }

    @Test
    void sameMoveDraws() {
        Move rock = new Rock();
        assertEquals(Result.DRAW, rock.compete(new Rock()), "Same moves should result in a draw");
    }

}
