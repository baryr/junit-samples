package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuiltInParameterResolversTests {

    @Test
    @DisplayName("TEST 1")
    @Tag("my tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my tag"));
    }

    @RepeatedTest(value = 10, name = "running {currentRepetition} of {totalRepetitions} iterations")
    @DisplayName("Repeated Test ")
    void test2(RepetitionInfo repetitionInfo) {
        assertTrue(true);
    }
}
