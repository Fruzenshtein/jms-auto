package com.jms.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class ContactVendorPopup extends PageObject {
	
	@FindBy(xpath="//span[text()='Called']")
	private WebElement calledButton;
	
	@FindBy(xpath="//span[text()='Contacted']")
	private WebElement contactedButton;
	
	@FindBy(xpath="//span[text()='Accepted']")
	private WebElement acceptedButton;
	
	@FindBy(xpath="//span[text()='Rejected']")
	private WebElement rejectedButton;
	
	@FindBy(xpath="//span[text()='Vendor is not available on this day']")
	private WebElement vendorIsNotAvailableOnThisDay;
	
	public void clickCalledButton() {
		calledButton.click();
	}
	
	public void clickAcceptedButton() {
		acceptedButton.click();
	}
	
	public void clickContactedButton() {
		contactedButton.click();
	}
	
	public void clickRejectedButton() {
		rejectedButton.click();
	}
	
	public void clickVendorIsNotAvailableOnThisDay() {
		vendorIsNotAvailableOnThisDay.click();
	}

}
