package com.example.assumptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Test;

public class AssumptionTests {

	@Test
	public void testNotFailOnFriday() {
		LocalDate date = LocalDate.now();
		DayOfWeek today = date.getDayOfWeek();
		assumeThat(today, is(DayOfWeek.FRIDAY));
		
		assertThat("Test not fail on friday", "true", is("false"));
	}
	
	@Test
	public void testPassesOnEveryDay() {
		assertThat("Test passes on every day", "true", is("true"));
	}

}
