package com.jms.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class AssignVendorPopup extends PageObject {
	
	@FindBy(xpath="//span[text()='Approve']")
	private WebElement approveButton;
	
	@FindBy(xpath="//span[text()='Save']")
	private WebElement saveButton;

	public void clickApproveButton() {
		approveButton.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
}
