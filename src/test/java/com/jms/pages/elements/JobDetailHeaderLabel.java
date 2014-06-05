package com.jms.pages.elements;

public enum JobDetailHeaderLabel {
	
	JOB_N("Job #:"),
	JOB_DATE("Job Date:"),
	JOB_TYPE("Job Type:"),
	REPORTERS("Reporters:"),
	VIDEOGRAPHERS("Videographers:"),
	STREAMING("Streaming:"),
	CONF_SERVICES("Conference Services:"),
	INTERPRETERS("Interpreters:"),
	WITNESS("Witness:");
	
	private final String label;
	
	JobDetailHeaderLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
