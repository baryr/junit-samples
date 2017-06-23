package com.example.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.example.categories.markers.FastTest;

@RunWith(Categories.class)
@IncludeCategory(FastTest.class)
@SuiteClasses({CommonTests.class, MixedTests.class })
public class FastTestSiute {

}
