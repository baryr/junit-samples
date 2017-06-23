package com.example.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import com.example.rules.customRules.CustomTimeoutRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {
    private static final Logger LOG = Logger.getLogger(FibonacciTest.class.getName());


    @Parameters(name = "{index}: fib({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }, { 7, 13 }
           });
    }

    
    // You can use parameter injection using @Parameter annotation
    ///*
    @Parameter(0)
    public int fInput;
    @Parameter(1)
    public int fExpected;
    //*/

    // Or you can use constructor injection
    /*
    private int fInput;
    private int fExpected;
    public FibonacciTest(int input, int expected) {
        fInput= input;
        fExpected= expected;
    }
    */

    @Test
    public void test() {
        LOG.info("Running Fibonacci test for fInput=" + fInput + ", fExpected=" + fExpected);
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}
