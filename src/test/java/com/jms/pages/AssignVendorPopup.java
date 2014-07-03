package com.jms.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class AssignVendorPopup extends PageObject {
	
	@FindBy(xpath="//span[text()='Approve']")
	private WebElement approveButton;
	
	@FindBy(xpath="//div[@class='save-buttons']//span[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@class='buttons']//span[text()='Change Recommendation']")
	private WebElement changeRecommendationButton;

	public void clickApproveButton() {
		approveButton.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void selectVendor(String vendorName) {
		$("//td[contains(.,'" + vendorName + "')]").waitUntilPresent().click();
		//table[@class='k-selectable']//td[contains(.,'Stewart & Shoman')]
	}
	
	public void clickchangeRecommendationButton() {
		changeRecommendationButton.click();
	}
	
}
