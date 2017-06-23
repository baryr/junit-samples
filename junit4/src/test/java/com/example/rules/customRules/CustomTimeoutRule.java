package com.example.rules.customRules;

import com.example.theories.TheoryTest;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.logging.Logger;

public class CustomTimeoutRule implements TestRule {
	private static final Logger LOG = Logger.getLogger(CustomTimeoutRule.class.getName());
	
	private long  maxTimeInMiliSeconds;
	
	public CustomTimeoutRule(long maxTimeInMiliSeconds) {
		this.maxTimeInMiliSeconds = maxTimeInMiliSeconds;		
	}

	public Statement apply(Statement base, Description description) {
		LOG.info("Apply CustomTimeoutRule to " + description.getDisplayName());
		return new CustomTimeoutStatement(base);
	}
	
	
	private class CustomTimeoutStatement extends Statement {
	    private final Statement next;
	    
	    public CustomTimeoutStatement(Statement base) {
	    	this.next = base;
	    }

		@Override
		public void evaluate() throws Throwable {
			long start = System.nanoTime();
			next.evaluate();
			long stop = System.nanoTime();
			long evaluationTime = (stop - start) / 1000000;
			System.out.println("Executed in: " + evaluationTime);
			if (evaluationTime > maxTimeInMiliSeconds) {
				throw new RuntimeException("To long running test");
			}
		}
	    
	}


}
