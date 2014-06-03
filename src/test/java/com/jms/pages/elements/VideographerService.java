package com.jms.pages.elements;

public enum VideographerService implements ExpectedServiceOption {
	
	MPEG("MPEG"),
	MPEG_SYNC("MPEG Sync"),
	DVD("DVD"),
	VHS("VHS"),
	VIDEO_STREAM("Video Stream"),
	UPLOAD_TO_REPO("Upload to Repository");
	
	private final String service;
	
	VideographerService(String service) {
		this.service = service;
	}
	
	public String getService() {
		return service;
	}

}
