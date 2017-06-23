package com.example;

import com.example.markers.Failing;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.time.Duration.ofSeconds;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BasicTests {

    @Test
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3).mapToInt(i -> i).sum() > 5,
                () -> "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Not supported");
        });

        assertEquals("Not supported", exception.getMessage());
        // or using hamcrest matchers
        assertThat(exception.getMessage(), is(equalTo("Not supported")));
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        String result = assertTimeout(ofSeconds(2), () -> {
            Thread.sleep(10);
            return "abc";
        });
        assertEquals("abc", result);
    }


    @Failing
    @DisplayName("╯°□°）╯ why !!!")
    void timeoutExceeded() {
        assertTimeout(ofSeconds(3), () -> {
            Thread.sleep(5000);
        });
    }

    @Failing
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(ofSeconds(1), () -> {
            Thread.sleep(5000);
        });
    }

    @Test
    void testFailingOnCI() {
        String env = System.getenv("ENV");
        //env = "CI";

        assumingThat("CI".equals(env),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, 3);
                });

        assertEquals("a string", "a string");
    }

    @Disabled
    @Test
    void testWillBeSkipped() {
        assertTrue(false);
    }

}
