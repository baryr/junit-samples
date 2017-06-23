package com.example;

import com.example.markers.FailingFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTests {

    //@FailingFactory
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("A", "B", "C", "E" , "F").map(
                str -> dynamicTest("testing uppercase of " + str, () -> {
                    assertThat("Input should be upper cased ",  str.toUpperCase(), is(equalTo(str)));
                }));
    }
}
