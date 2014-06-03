package com.jms.pages.elements;

public enum StreamServices implements ExpectedServiceOption {
	
	INTERNET_REALTIME("Internet Realtime"),
	VIDEO_STREAM("Video Stream"),
	HARDLINE_CONFIRMED("Hardline Confirmed"),
	CHAT_ROOM_NEEDED("Chat Room Needed");
	
	private final String service;
	
	StreamServices(String service) {
		this.service = service;
	}
	
	public String getService() {
		return service;
	}

}
