package com.example.rules.customRules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class LoggingRule implements TestRule {
	
	private String name;
	
	public LoggingRule(String name) {
		this.name = name;		
	}

	public Statement apply(final Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				System.out.println("starting " + name);
				base.evaluate();
				System.out.println("finished " + name);
			}
		};
	}

}
