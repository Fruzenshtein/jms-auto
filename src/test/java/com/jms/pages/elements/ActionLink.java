package com.jms.pages.elements;

public enum ActionLink {
	
	CONTACT_FOR_ASSIGNMENT("Contact for Assignment"),
	CONTACT_FOR_CONFIRMATION("Contact for Confirmation"),
	CONTACT_AGAIN_FOR_ASSIGMENT("Contact Again for Assignment"),
	VENDOR_CONFIRMS("Vendor Confirms"),
	APPROVE_RECOMENDATION("Approve Recommendation"),
	RECOMMEND_ANOTHER_VEND("Recommend Another Vendor"),
	JOB_INFO_TABLE("Job Information Table"),
	SELECT_ANOTHER_VENDOR("Select Another Vendor"),
	AGENCY_CONFIRMS("Agency Confirms"),
	ASSIGN_WITHOUT_CONFIRM_COMPOSE_JI("Assign without Confirm (Compose JI)");
	
	private final String link;
	
	ActionLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

}
