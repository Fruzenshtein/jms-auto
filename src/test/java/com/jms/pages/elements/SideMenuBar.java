package com.jms.pages.elements;

public enum SideMenuBar {
	CALENDAR_VENDOR_QUEUE("Calendar Vendor Queue"),
	LOG_OUT("Log Out");

	private final String sideMenuLink;

	SideMenuBar(String sideMenuLink) {
		this.sideMenuLink = sideMenuLink;
	}

	public String getLink() {
		return sideMenuLink;
	}
}
