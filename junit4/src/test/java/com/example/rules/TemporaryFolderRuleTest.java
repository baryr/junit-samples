package com.example.rules;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTest {

	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();

	@Test
	public void testTempFolder1() throws IOException {
		File tempFile = testFolder.newFile("file.txt");
		File tempFolder = testFolder.newFolder("folder");
		// Will print something like 'C:\Users\bary\AppData\Local\Temp\junit4714282283644324775' 
		System.out.println("Test folder: " + testFolder.getRoot());
		// test...
	}
	
	@Test
	public void testTempFolder2() throws IOException {
		File tempFile = testFolder.newFile("file.txt");
		File tempFolder = testFolder.newFolder("folder");
		// Will print something like 'C:\Users\bary\AppData\Local\Temp\junit7798324981789070429' 
		System.out.println("Test folder: " + testFolder.getRoot());
		// test...
	}

}
