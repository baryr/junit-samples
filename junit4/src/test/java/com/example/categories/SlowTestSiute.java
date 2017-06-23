package com.example.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.example.categories.markers.SlowTest;

@RunWith(Categories.class)
@IncludeCategory(SlowTest.class)
@SuiteClasses({CommonTests.class, MixedTests.class })
public class SlowTestSiute {

}
