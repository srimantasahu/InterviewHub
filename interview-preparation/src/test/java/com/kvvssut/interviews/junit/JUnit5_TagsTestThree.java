package com.kvvssut.interviews.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Production")
class JUnit5_TagsTestThree {

    @Test
    void testThree() {
        System.out.println("Test 3");
    }

}