package com.jms.pages.elements;

public enum LocationService implements ExpectedServiceOption {
	
	VIDEO_CONF_NEEDED("Video Conference Needed"),
	INITIATES_CONF("Initiates Conference"),
	TSG_PROVIDING("TSG Providing Bridge"),
	CAMEO("Cameo");
	
	private final String service;
	
	LocationService(String service) {
		this.service = service;
	}

	public String getService() {
		return service;
	}
	
}
