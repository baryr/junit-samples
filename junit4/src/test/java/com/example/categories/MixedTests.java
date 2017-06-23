package com.example.categories;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.categories.markers.FastTest;
import com.example.categories.markers.SlowTest;
public class MixedTests {
	
	@Test
	// will not be run by @RunWith(Categories.class)
	public void normalTest() {
		assertThat("True is true", "true", is("true"));		
	}
	
	@Test
	@Category({FastTest.class})
	public void fastTest() {
		assertThat("True is true", "true", is("true"));		
	}
	
	@Test
	@Category({SlowTest.class})
	public void slowTest() {
		try { Thread.sleep(5000); } catch (InterruptedException e) {}
		assertThat("True is true", "true", is("true"));		
	}
	
}
