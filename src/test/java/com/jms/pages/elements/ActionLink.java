package com.jms.pages.elements;

public enum ActionLink {
	
	APPROVE_RECOMENDATION("Approve Recommendation"),
	RECOMMEND_ANOTHER_VEND("Recommend Another Vendor"),
	JOB_INFO_TABLE("Job Information Table");
	
	private final String link;
	
	ActionLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

}
