package com.padavala.loom.financialcalculator;

public enum Frequency {
	
	MONTHLY(12), // 12 months per year
	QUARTERLY(4), // 4 quarters per year
	YEARLY(1); // 1 year per year
	
	private final int value;

    private Frequency(int value) {
            this.value = value;
    }

	public int getValue() {
		return value;
	}
};
