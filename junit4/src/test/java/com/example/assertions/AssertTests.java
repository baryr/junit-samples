package com.example.assertions;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertTests {

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "abc".getBytes();
		byte[] actual = "abc".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		assertEquals("failure - values are not same", "true", "true");
	}

	@Test
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertTrue() {
		assertTrue("failure - should be true", true);
	}
	
	@Test
	public void testAssertNull() {
		assertNull("should be null", null);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull("should not be null", new Object());
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	
	// Hamcrest Matchers with assertThat
	@Test
	public void testAssertThatBothContainsString() {
		String string = "album";
		assertThat(string, both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThatHasItems() {
		List<String> list = Arrays.asList("one", "two", "three");
		assertThat(list, is(not(empty())));
		assertThat(list, hasItems("one", "three"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		List<String> list = Arrays.asList("fun", "ban", "net");
		assertThat(list, everyItem(containsString("n")));
	}

	
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("go")));
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(5, is(equalTo(5)));
		assertThat(5, is(not(nullValue())));
		assertThat(7, (either(equalTo(7)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}


}
