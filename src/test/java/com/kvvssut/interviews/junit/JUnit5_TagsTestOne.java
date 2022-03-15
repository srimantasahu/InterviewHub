package com.kvvssut.interviews.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Development")
class JUnit5_TagsTestOne {

    @Test
    void testOne() {
        System.out.println("Test 1");
    }

}