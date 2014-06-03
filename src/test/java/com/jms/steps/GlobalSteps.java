package com.jms.steps;

import static org.junit.Assert.*;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.pages.MainPage;

public class GlobalSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	
	private MainPage mainPage() {
		return getPages().currentPageAt(MainPage.class);
	}
	
	@Step
	public void checkAlertText(String expectedText) {
		assertEquals(expectedText, mainPage().getAlertText());
	}
	
	@Step
	public void checkMessageText(String expectedText) {
		String actualText = mainPage().getMessageText();
		assertTrue("No expected string ["+expectedText+"] was found in ["+actualText+"]", actualText.contains(expectedText));
	}
	
	@Step
	public void clickOkMessagePopup() {
		mainPage().clickOkMessagePopup();
	}
	
	@Step
	public void clickSideMenuItem(String linkText) throws InterruptedException {
		if (mainPage().isSideBarDisplayed())
			mainPage().openSideBar();
		mainPage().clickSideBarLink(linkText);
	}
	
	@Step
	public void clickCreateJobIcon() {
		mainPage().clickCreateJobIcon();
	}
	
	@Step
	public void openWidgetIn(int zoneId) throws InterruptedException {
		mainPage().openWidgetIn(zoneId);
		Thread.sleep(3000);
	}
	
	@Step
	public void searchJobById(String jobId) throws InterruptedException {
		mainPage().setJobInSearchField(jobId);
		mainPage().clickJobSearchButton();
		Thread.sleep(4000);
	}
	
}
