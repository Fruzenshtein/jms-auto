package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebElement;

public class MainPage extends PageObject {

	@FindBy(id="sidemenu-open-link")
	private WebElement sideMenuPlusButton;
	
	@FindBy(id="tn-create-job")
	private WebElement createJobIcon;
	
	@FindBy(id="jobsearchnav")
	private WebElement jobSearchField;

	@FindBy(id="tn-jobnumber-search")
	private WebElement jobSearchButton;
	
	@FindBy(id="message-box-dialog")
	private WebElement messagePopup;
	
	@FindBy(xpath="//div[@id='message-box-dialog']//button[text()='OK']")
	private WebElement messagePopupOkBtn;
	
	@FindBy(xpath="//div[@class='jobdetail-view scroll-view']")
	private WebElement jobDetailWidget;

	public void okAlert() {
		getAlert().accept();
	}
	
	public String getAlertText() {
		return getAlert().getText();
	}
	
	public String getMessageText() {
		return messagePopup.getText();
	}
	
	public void clickOkMessagePopup() {
		messagePopupOkBtn.click();
	}
	
	public void openSideBar() {
		sideMenuPlusButton.click();
	}
	
	public boolean isSideBarDisplayed() {
		return sideMenuPlusButton.isDisplayed();
	}
	
	public void clickSideBarLink(String linkTitle) throws InterruptedException {
		Thread.sleep(1500);
		element("//div[@id='sidemenu']//a[text() = '"+linkTitle+"']").click();
	}
	
	public void clickCreateJobIcon() {
		createJobIcon.click();
	}
	
	public void openWidgetIn(int zoneId) {
		waitFor("#layout-link-popup");
		switch (zoneId) {
			case 1:
				element("//div[@data-window-tab='"+zoneId+"']/a").click();
				break;
			case 2:
				element("//div[@data-window-tab='"+zoneId+"']/a").click();
				break;
			case 3:
				element("//div[@data-window-tab='"+zoneId+"']/a").click();
				break;
			default:
				element("//div[@data-window-tab='1']").click();
		}
	}
	
	public void setJobInSearchField(String jobId) {
		jobSearchField.click();
		jobSearchField.sendKeys(jobId);
	}
	
	public void clickJobSearchButton() {
		jobSearchButton.click();
	}
	
	public void activeWidget() {
		$(jobDetailWidget).waitUntilPresent();
	}
	
}
