package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class VendorQueuePage extends PageObject {
	
	@FindBy(xpath="(//th[@data-title='Job Number']//span)[2]")
	private WebElement jobNumberFilterIcon;
	
	@FindBy(xpath="//form[@data-role='popup']//input[contains(@class, 'k-input')]")
	private WebElement jobNumberFilter;
	
	@FindBy(xpath="//button[text()='Filter']")
	private WebElement filterButton;
	
	public void clickJobNumberFilterIcon() {
		jobNumberFilterIcon.click();
	}
	
	public void filterJobsByNumber(String jobNumber) {
		jobNumberFilter.click();
		$(jobNumberFilter).sendKeys(jobNumber);
	}
	
	public void clickFilterButton() {
		filterButton.click();
	}
}
