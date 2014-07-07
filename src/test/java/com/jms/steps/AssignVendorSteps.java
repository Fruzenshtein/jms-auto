package com.jms.steps;

import com.jms.pages.AssignVendorPopup;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AssignVendorSteps extends ScenarioSteps {
	
	private static final long serialVersionUID = 1L;
	
	private AssignVendorPopup assignVendorPopup() {
		return getPages().currentPageAt(AssignVendorPopup.class);
	}

	@Step
	public void clickApproveButton() {
		assignVendorPopup().clickApproveButton();
	}
	
	@Step
	public void clickSaveButton() {
		assignVendorPopup().clickSaveButton();
	}
	
	@Step
	public void selectVendor(String vendorName) {
		assignVendorPopup().selectVendor(vendorName);
	}
	
	@Step
	public void clickChangeRecommendationButton() {
		assignVendorPopup().clickChangeRecommendationButton();
	}

	
}
