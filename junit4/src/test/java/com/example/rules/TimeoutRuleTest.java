package com.example.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {
	public static String log;

	@Rule
	public final TestRule globalTimeout = Timeout.millis(20);

	@Test
	public void testInfiniteLoop1() {
		for (;;) {}
	}

	@Test
	public void testInfiniteLoop2() {
		for (;;) {}
	}
}
