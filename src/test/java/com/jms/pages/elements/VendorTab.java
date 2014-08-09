package com.jms.pages.elements;

public enum VendorTab {
	REPORTER("reporter-vendor-tab", "reporter"),
	VIDEOGRAPHER("videographer-vendor-tab", "videographer"),
	STREAMING_SERVICES("streaming-vendor-tab", "streaming"),
	LOCATION("videoconference-vendor-tab", "location"),
	INTERPRETER("interpreter-vendor-tab", "interpreter");
	
	private final String tab;
	private final String vendor;
	
	VendorTab(String tab, String vendor) {
		this.tab = tab;
		this.vendor = vendor;
	}
	
	public String getTab() {
		return tab;
	}
	
	public String getVendor() {
		return vendor;
	}
}
