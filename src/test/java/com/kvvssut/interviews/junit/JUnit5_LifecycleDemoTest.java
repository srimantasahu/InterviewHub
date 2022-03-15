package com.kvvssut.interviews.junit;

import org.junit.jupiter.api.*;

public class JUnit5_LifecycleDemoTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Connect to the database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Disconnect from the database");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Load the schema");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Drop the schema");
    }

    @Test
    void testOne() {
        System.out.println("Test One");
    }

    @Test
    void testTwo() {
        System.out.println("Test Two");
    }
}