package com.jms.steps;

import com.jms.pages.ContactVendorPopup;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ContactVendorSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	
	private ContactVendorPopup contactVendorPopup() {
		return pages().currentPageAt(ContactVendorPopup.class);
	}
	
	@Step
	public void clickCalledButton() {
		contactVendorPopup().clickCalledButton();
	}
	
	@Step
	public void clickAcceptedButton() {
		contactVendorPopup().clickAcceptedButton();
	}
	
	@Step
	public void clickContactedButton() {
		contactVendorPopup().clickContactedButton();
	}
	
	@Step
	public void clickRejectedButton() {
		contactVendorPopup().clickRejectedButton();
	}
	
	@Step
	public void clickVendorIsNotAvailableOnThisDay() {
		contactVendorPopup().clickVendorIsNotAvailableOnThisDay();
	}
}
