package com.jms.pages.elements;

public enum VendorTab {
	REPORTER("reporter-vendor-tab"),
	VIDEOGRAPHER("videographer-vendor-tab"),
	STREAMING_SERVICES("streaming-vendor-tab"),
	LOCATION("videoconference-vendor-tab"),
	INTERPRETER("interpreter-vendor-tab");
	
	private final String tab;
	
	VendorTab(String tab) {
		this.tab = tab;
	}
	
	public String getTab() {
		return tab;
	}
}
