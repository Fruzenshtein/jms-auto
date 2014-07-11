package com.jms.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.pages.VendorQueuePage;

public class VednorQueueSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private VendorQueuePage vendorQueuePage() {
		return getPages().currentPageAt(VendorQueuePage.class);
	}

	@Step
	public void clickJobNumberFilterIcon() {
		vendorQueuePage().clickJobNumberFilterIcon();
	}
	
	@Step
	public void filterJobsByNumber(String jobbNumber) {
		
		vendorQueuePage().filterJobsByNumber(jobbNumber);
		vendorQueuePage().clickFilterButton();
	}
	
}
