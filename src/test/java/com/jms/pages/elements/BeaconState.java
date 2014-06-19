package com.jms.pages.elements;

public enum BeaconState {
	
	GRAY("gray"),
	BLUE("blue"),
	YELLOW("yellow");

	private String state;
	
	BeaconState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
