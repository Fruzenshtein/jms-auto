package com.jms.pages.elements;

public enum Beacon {
	
	STREAMING_ASSIGNED("Streaming Assigned"),
	REPORTER_ASSIGNED("Reporter Assigned"),
	VIDEOGRAPHER_ASSIGNED("Videographer Assigned"),
	VIDEOGRAPHER_JOB_INFO("Videographer Job Info");
	
	private String beacon;
	
	Beacon(String beacon) {
		this.beacon = beacon;
	}
	
	public String getBeacon() {
		return beacon;
	}

}
