package com.jms.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

public class ContactVendorPopup extends PageObject {
	
	@FindBy(xpath="//span[text()='Called']")
	private WebElement calledButton;
	
	@FindBy(xpath="//span[text()='Contacted']")
	private WebElement contactedButton;
	
	public void clickCalledButton() {
		calledButton.click();
	}
	
	public void clickContactedButton() {
		contactedButton.click();
	}

}
