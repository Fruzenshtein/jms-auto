package com.jms.pages.elements;

public enum ExpectedServiceSection {
	
	REPORTING("Reporting Services"),
	VIDEOGRAPHER("Videographer Services"),
	STREAMING("Streaming Services"),
	CONFERENCE("Conference Services"),
	INTERPRETER("Interpreter");
	
	private final String section;
	
	ExpectedServiceSection(String section) {
		this.section = section;
	}

	public String getSection() {
		return section;
	}
	
}
