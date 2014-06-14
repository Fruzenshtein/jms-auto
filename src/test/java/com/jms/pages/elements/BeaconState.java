package com.jms.pages.elements;

public enum BeaconState {
	
	GRAY("gray"),
	BLUE("blue");

	private String state;
	
	BeaconState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
