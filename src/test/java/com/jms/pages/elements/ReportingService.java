package com.jms.pages.elements;

public enum ReportingService implements ExpectedServiceOption {
	
	REALTIME("Realtime"),
	ROUGH_DRAFT("Rough Draft"),
	INTERNET_REALTIME("Internet Realtime"),
	CHAT_ROOM_NEEDED("Chat Room Needed"),
	UPLOAD_TO_REPOSITORY("Upload to Repository"),
	TRANSCRIPTS("Transcripts"),
	EXHIBITS("Exhibits"),
	EXHIBIT_HARD_COPY("Exhibit (Hard Copy)"),
	TABBED("Tabbed"),
	EXHIBIT_SCANED_LINKED("Exhibit (Scanned & Linked)"),
	OCR("OCR"),
	TIFF("TIFF"),
	EXHIBIT_ASAP("Exhibit ASAP");
	
	private final String service;
	
	ReportingService(String service) {
		this.service = service;
	}
	
	public String getService() {
		return service;
	}

}
