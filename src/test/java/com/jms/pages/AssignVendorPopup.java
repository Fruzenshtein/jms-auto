package com.jms.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class AssignVendorPopup extends PageObject {

	@FindBy(xpath = "//span[text()='Approve']")
	private WebElement approveButton;

	@FindBy(xpath = "//div[@class='save-buttons']//span[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='save-buttons']//span[text()='Save']")
	private WebElement vendorSelection;

	@FindBy(xpath = "//button[@class='blue']//span[text()='Change Recommendation']")
	private WebElement changeRecommendationButton;

	public void clickApproveButton() {
		approveButton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickChangeRecommendationButton() {
		changeRecommendationButton.click();
	}

	public void selectVendor(String vendorName) {
		$("//div[@class='clr-left assign-agency-grid k-grid k-widget']//td[text()='" + vendorName + "']")
				.waitUntilPresent()
				.click();

	}

}
