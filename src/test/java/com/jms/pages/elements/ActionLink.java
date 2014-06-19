package com.jms.pages.elements;

public enum ActionLink {
	
	CONTACT_FOR_ASSIGNMENT("Contact for Assignment"),
	APPROVE_RECOMENDATION("Approve Recommendation"),
	RECOMMEND_ANOTHER_VEND("Recommend Another Vendor"),
	JOB_INFO_TABLE("Job Information Table"),
	SELECT_ANOTHER_VENDOR("Select Another Vendor");
	
	private final String link;
	
	ActionLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

}
