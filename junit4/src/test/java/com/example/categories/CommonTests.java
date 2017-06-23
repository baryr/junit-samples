package com.example.categories;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.categories.markers.FastTest;
import com.example.categories.markers.SlowTest;

@Category({SlowTest.class, FastTest.class})
public class CommonTests {
	
	@Test
	public void commonTest() {
		assertThat("True is true", "true", is("true"));		
	}
	
}
