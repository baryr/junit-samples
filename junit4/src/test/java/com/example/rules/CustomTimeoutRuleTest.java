package com.example.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.example.rules.customRules.CustomTimeoutRule;


public class CustomTimeoutRuleTest {
	
	@Rule
	public TestRule expectedFastTest = new CustomTimeoutRule(3000);

	@Test
	public void fastTest() {
		assertThat("True is true", "true", is("true"));
	}
	
	@Test
	public void averageTest() {
		try { Thread.sleep(2000); } catch (InterruptedException e) { }
		assertThat("True is true", "true", is("true"));
	}

	@Test
	public void slowTest() {
		try { Thread.sleep(5000); } catch (InterruptedException e) { }
		assertThat("True is true", "true", is("true"));
	}
	
}
