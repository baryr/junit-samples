package com.example.rules;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

import com.example.rules.customRules.LoggingRule;

public class RuleChainTest {
	@Rule
	public final TestRule chain = RuleChain.outerRule(new LoggingRule("outer rule"))
			.around(new LoggingRule("middle rule"))
			.around(new LoggingRule("inner rule"));

	@Test
	public void example() {
		assertTrue(true);
	}
}
