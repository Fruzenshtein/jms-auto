package com.jms.pages.elements;

public enum SideMenuLink {
	CALENDAR_VENDOR_QUEUE("Calendar Vendor Queue"),
	LOG_OUT("Log Out");

	private final String sideMenuLink;

	SideMenuLink(String sideMenuLink) {
		this.sideMenuLink = sideMenuLink;
	}

	public String getLink() {
		return sideMenuLink;
	}
}
