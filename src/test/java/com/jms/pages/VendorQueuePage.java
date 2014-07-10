package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VendorQueuePage extends PageObject {

	@FindBy(xpath = "//th[@data-title='Job Number']//span[@class='k-icon k-filter']")
	private WebElement jobNumberFilterIcon;

	@FindBy(xpath = "(//div[@class='k-animation-container']//input)[1]")
	private WebElement jobNumberFilter;

	@FindBy(xpath = "//button[text()='Filter']")
	private WebElement filterButton;

	public void clickJobNumberFilterIcon() {
		jobNumberFilterIcon.click();
	}

	public void filterJobsByNumber(String jobNumber) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		getClock().pauseFor(2000);
		js.executeScript("document.getElementByClassName('k-formatted-value k-input').setAttribute('value', 1250)");
		getClock().pauseFor(1000);
	}

	public void clickFilterButton() {
	}
}
