package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.jms.pages.elements.ExpectedServiceOption;
import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.ReportingService;
import com.jms.pages.elements.VendorService;

public class ExpectedServicesPopup extends PageObject {
	
	@FindBy(xpath="(//div[@class='service-row']//img)[1]")
	private WebElement servicesReporterCheckbox;
	
	@FindBy(className="deliveryservices")
	private WebElement deliveryDropDown;
	
	@FindBy(xpath="(//span[text()='Reporting Services']/../..//div)[2]")
	private WebElement reportingServicesSection;
	
	@FindBy(xpath="(//span[text()='Videographer Services']/../..//div)[2]")
	private WebElement videographerServicesSection;
	
	@FindBy(xpath="(//span[text()='Streaming Services']/../..//div)[2]")
	private WebElement streamingServicesSection;
	
	@FindBy(xpath="//span[text()='Update']")
	private WebElement updateButton;
	
	@FindBy(xpath="//span[text()='Reporter Instructions']/../textarea")
	private WebElement reporterInstructions;
	
	@FindBy(xpath="//span[text()='Videographer Instructions']/../textarea")
	private WebElement videographerInstructions;
	
	@FindBy(className="exsvcneedlaptop")
	private WebElement numberOfLeptops;
	
	@FindBy(linkText="Add Email")
	private WebElement addEmail;
	
	@FindBy(className="streamingaddemail")
	private WebElement addEmailField;
	
	@FindBy(className="streamingemailtoservices")
	private WebElement addEmailVideoStream;
	
	@FindBy(className="conferenceserviceslocation")
	private WebElement conferenceLocation;
	
	@FindBy(linkText="Add Location")
	private WebElement addLocationLink;
	
	@FindBy(xpath="//span[text()='IP']/../input")
	private WebElement ipField;
	
	@FindBy(xpath="//span[text()='ISDN']/../input")
	private WebElement isdnField;
	
	@FindBy(xpath="//span[text()='IT Contact']/../input")
	private WebElement itContactField;
	
	@FindBy(xpath="(//span[text()='Phone']/../input)[2]")
	private WebElement phoneFieldConfServices;
	
	@FindBy(xpath="//span[text()='Notes']/../textarea")
	private WebElement notesTextarea;
	
	@FindBy(xpath="//span[text()='Number of Cameos']/../input")
	private WebElement numberOfCameos;
	
	@FindBy(xpath="//span[text()='Email to:']/../input")
	private WebElement confServEmail;
	
	@FindBy(linkText="Add Language")
	private WebElement addLanguageLink;
	
	@FindBy(xpath = "//span[text()='Change Recommendation']")
	private WebElement changeRecommendationButton;
	
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement save;
	
	public void clickVendorServiceIcon(VendorService vendor) {
		getClock().pauseFor(1000);
		//TODO: Re-implement after unique selectors will be assigned
		$("(//div[@class='service-row']//img)["+vendor.getOrder()+"]")
			.waitUntilPresent()
			.click();
	}
	
	public void clickVendorTBDIcon(VendorService vendor) {
		getClock().pauseFor(1000);
		//TODO: Re-implement after unique selectors will be assigned
		$("(//div[@class='service-row clr']//img)["+vendor.getOrder()+"]")
			.waitUntilPresent()
			.click();
	}
	
	public boolean isServiceCheckBoxChecked(ExpectedServiceOption service, boolean is) {
		boolean case1 = false;
		boolean case2 = false;
		boolean case3 = false;
		if (is) {
			try {
				case1 = $("//label[@class='checkbox checked']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case1)
					return true;
			} catch (NoSuchElementException e) { }
			try {
				case2 = $("//label[@class='clr checkbox checked']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case2)
					return true;
			} catch (NoSuchElementException e) { }
			try {
				case3 = $("//label[@class='subitem clr checkbox checked']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case3)
					return true;
			} catch (NoSuchElementException e) { }
			return false;
		}
		else {
			try {
				case1 = $("//label[@class='checkbox']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case1)
					return true;
			} catch (NoSuchElementException e) { }
			try {
				case2 = $("//label[@class='clr checkbox']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case2)
					return true;
			} catch (NoSuchElementException e) { }
			try {
				case3 = $("//label[@class='subitem clr checkbox']/span[text()='"+service.getService()+"']").isDisplayed();
				if (case3)
					return true;
			} catch (NoSuchElementException e) { }
			return false;
		}
	}
	
	public boolean isServiceIconActivated(VendorService vendor, boolean is) {
		if (is)
			return $("//div[@class='service-row']/label[@class='vendor-services "+
			vendor.getName()+" checkbox checked']").isPresent();
		else
			return $("//div[@class='service-row']/label[@class='vendor-services "+
			vendor.getName()+" checkbox']").isPresent();
	}
	
	public boolean statusServiceIcon(VendorService vendor) {
			return $("//div[@class='service-row']/label[contains(@class, '"+vendor.getName()+"')]")
					.getAttribute("class").contains("checked");
	}
	
	public boolean isAsapCheckBox(boolean is) {
		if (is)
			return $("//img[class='imageCheck exibitsAsap checked']").waitUntilPresent().isPresent();
		else
			return $("//img[class='imageCheck exibitsAsap']").waitUntilPresent().isPresent();
	}
	
	public String getCurrentDelivery() {
		return $(deliveryDropDown).getSelectedVisibleTextValue();
	}
	
	public void selectDelivery(String delivery) {
		$(deliveryDropDown).selectByVisibleText(delivery);
	}
	
	public void clickReportingServiceCheckBox(ExpectedServiceOption service, int order) {
			$("(//span[text()='"+service.getService()+"'])["+order+"]").click();
	}
	
	public boolean isDisplayedReportingServiceCheckBox(ReportingService service) {
		return $("//span[text()='"+service.getService()+"']").isVisible();
	}
	
	public void setReporterInstructions(String text) {
		reporterInstructions.sendKeys(text);
	}
	
	public void setVideographerInstructions(String text) {
		videographerInstructions.sendKeys(text);
	}
	
	public boolean isExpectedServicesSection(ExpectedServiceSection section, boolean enabled) {
		boolean elementStatus = $("(//span[text()='"+section.getSection()+"']/../..//div)[2]").isEnabled();
		if (enabled)
			return elementStatus;
		else
			return elementStatus;
	}
	
	public void setNumberOfLeptops(String number) {
		numberOfLeptops.clear();
		numberOfLeptops.sendKeys(number);
	}
	
	public void clickAgencyByIndex(int index) {
		$("(//div[contains(@class, 'assign-agency-grid')]//td[@class])["+index+"]").click();
	}
	
	public void clickUpdate() {
		updateButton.click();
	}
	
	public void clickAddEmailLink() {
		addEmail.click();
	}
	
	public void addEmail(String email) {
		addEmailField.sendKeys(email);
	}
	
	public void addEmailInVeideoStream(String email) {
		addEmailVideoStream.sendKeys(email);
	}

	public void selectConferenceLocation(int index) {
		$(conferenceLocation).selectByIndex(index);
	}
	
	public void clickAddLocationLink() {
		addLocationLink.click();
	}
	
	public void setIP(String ip) {
		ipField.sendKeys(ip);
	}
	
	public void setISDN(String isdn) {
		isdnField.sendKeys(isdn);
	}
	
	public void setItContact(String itContact) {
		itContactField.sendKeys(itContact);
	}
	
	public void setPhoneConfServices(String phone) {
		phoneFieldConfServices.sendKeys(phone);
	}
	
	public void setNotes(String notes) {
		notesTextarea.sendKeys(notes);
	}
	
	public void setNumberOfCameos(String number) {
		numberOfCameos.sendKeys(number);
	}
	
	public void addEmailConfServSection(String email) {
		$("//span[text()='Email to:']//..//input").sendKeys(email);
	}
	
	public void clickAddLanguage() {
		addLanguageLink.click();
	}
	
	public void clickChangeRecommendationButton() {
		changeRecommendationButton.click();
	}
	
	public void goToFirmTab(int index) {
		$("(//div[@data-test='client-expectedservices-tab'])[" + index + "]").click();
	}

	public void checkExhibitASAP() {
		$("//img[@class='imageCheck exibitsAsap']").click();
	}
}
