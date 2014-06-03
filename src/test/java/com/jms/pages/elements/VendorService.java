package com.jms.pages.elements;

public enum VendorService {
	
	REPORTER("1", "reporter"),
	VIDEOGRAPHER("2", "videographer"),
	STREAMING("3", "streaming"),
	LOCATION("4", "location"),
	INTERPRETER("5", "interpreter");
	
	private final String orderN;
	private final String name;
	
	private VendorService(String orderN, String name) {
		this.orderN = orderN;
		this.name = name;
	}
	
	public String getOrder() {
		return orderN;
	}
	
	public String getName() {
		return name;
	}

}
