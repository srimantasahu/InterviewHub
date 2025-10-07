package com.kvvssut.rps;

import com.kvvssut.rps.model.Paper;
import com.kvvssut.rps.model.Rock;
import com.kvvssut.rps.model.Scissors;
import com.kvvssut.rps.utils.HandSignalTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests translation from hand signals to Move objects.
 */
public class HandSignalTranslatorTest {

    @Test
    void translatesFistToRock() {
        assertInstanceOf(Rock.class, HandSignalTranslator.translate("FIST"), "FIST should translate to Rock");
    }

    @Test
    void translatesOpenHandToPaper() {
        assertInstanceOf(Paper.class, HandSignalTranslator.translate("OPEN_HAND"), "OPEN_HAND should translate to Paper");
    }

    @Test
    void translatesInmFingersToScissors() {
        assertInstanceOf(Scissors.class, HandSignalTranslator.translate("INM_FINGERS"), "INM_FINGERS should translate to Scissors");
    }

    @Test
    void invalidInputReturnsNull() {
        assertNull(HandSignalTranslator.translate("INVALID"), "Invalid input should return null");
    }

}
