package com.jms.steps;

import static org.junit.Assert.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.pages.GenericPage;
import com.jms.pages.elements.SideMenuLink;

public class GlobalSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	private GenericPage genericPage() {
		return getPages().currentPageAt(GenericPage.class);
	}

	@Step
	public void pause(int seconds) {
		genericPage().pause(seconds);
	}

	@Step
	public void waitRequestProcessing() {
		genericPage().waitRequestProcessing();
	}

	@Step
	public void checkAlertText(String expectedText) {
		assertEquals(expectedText, genericPage().getAlertText());
	}

	@Step
	public void checkMessageText(String expectedText) {
		String actualText = genericPage().getMessageText();
		assertTrue("No expected string [" + expectedText + "] was found in ["
				+ actualText + "]", actualText.contains(expectedText));
	}

	@Step
	public void clickOkMessagePopup() {
		genericPage().clickOkMessagePopup();
	}

	@Step
	public void checkTextPresent(String text) {
		assertTrue("Expected text [" + text + "] is not present", genericPage()
				.isTextPresent(text));
	}

	@Step
	public void checkTextNotPresent(String text) {
		assertFalse("Expected text [" + text + "] is present", genericPage()
				.isTextPresent(text));
	}

	@Step
	public void waitUntilTextDisappear(String text) {
		genericPage().waitUntilTextDisappear(text);
	}

	@Step
	public void waitUntilTextAppear(String text) {
		genericPage().waitUntilTextAppear(text);
	}

	@Step
	public void clickSideMenuItem(SideMenuLink sideMenuLink)
			throws InterruptedException {
		if (genericPage().isSideBarDisplayed())
			genericPage().openSideBar();
		genericPage().clickSideBarLink(sideMenuLink.getLink());
	}

	@Step
	public void clickCreateJobIcon() {
		genericPage().clickCreateJobIcon();
	}

	@Step
	public void openWidgetIn(int zoneId) throws InterruptedException {
		genericPage().openWidgetIn(zoneId);
		Thread.sleep(3000);
	}

	@Step
	public void searchJobById(String jobId) {
		genericPage().setJobInSearchField(jobId);
		genericPage().clickJobSearchButton();
	}

}
