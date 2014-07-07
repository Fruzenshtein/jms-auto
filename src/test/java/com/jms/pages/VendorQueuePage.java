package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class VendorQueuePage extends PageObject {
	
	@FindBy(xpath="(//a[@class='k-grid-filter']/span[@class='k-icon k-filter'])[7]")
	private WebElement jobNumberFilterIcon;
	
	@FindBy(xpath="(//span[@class='k-numeric-wrap k-state-default']//input[@type='text'])[1]")
	private WebElement jobNumberFilter;
	
	@FindBy(xpath="//button[text()='Filter']")
	private WebElement filterButton;
	
	public void clickJobNumberFilter() {
		jobNumberFilterIcon.click();
	}
	
	public void filterJobsByNumber(String jobNumber) {
		$(jobNumberFilter).waitUntilPresent().sendKeys(jobNumber);;
	}
	
	public void clickFilterButton() {
		filterButton.click();
	}
}
