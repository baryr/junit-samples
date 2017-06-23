package com.example.assertions.customMatchers;

import static com.example.assertions.customMatchers.IsNotANumber.notANumber;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NotANumberTest {

	@Test
	public void testSquareRootOfMinusOneIsNotANumber() {
		assertThat("Square root of minus one should not be number", Math.sqrt(-1), is(notANumber()));
	}

}
