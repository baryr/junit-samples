package com.example.theories;

public class Dollar {
	
	private final int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}
	
	public Dollar times(int n) {
		//if (n == 12) { return new Dollar(1); }  // test bug :)
		return new Dollar(getAmount() * n);
	}
	
	public Dollar divideBy(int n) {
		return new Dollar(getAmount() / n);
	}	

	public int getAmount() {
		return amount;
	}
	
}
