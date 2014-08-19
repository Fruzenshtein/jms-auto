package com.jms.pages;

import java.util.List;

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
	
	@FindBy(className="streamingemailtoservices")
	private WebElement addEmailVideoStream;
	
	@FindBy(className="conferenceserviceslocation")
	private WebElement conferenceLocation;
	
	@FindBy(linkText="Add Location")
	private WebElement addLocationLink;
	
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
		deliveryDropDown.sendKeys(delivery);
	}
	
	public List<String> getDeliveryOptions() {
		return $(deliveryDropDown).getSelectOptions();
	}
	
	public void selectDelivery2(int index) {
		$(deliveryDropDown).selectByIndex(index);
	}
	
	public void clickReportingServiceCheckBox(ExpectedServiceOption service, int order) {
			$("(//span[text()='"+service.getService()+"']/../img)["+order+"]").click();
	}
	
	public void clickVideoConferenceNeededCheckBox(int order) {
		$("(//div[@data-test='conferenceservices-expectedservices-module']//img[@data-test='videoconferenceneeded-expectedservices-cbx'])["+order+"]").click();
	}
	
	public void clickInitiatesConferenceCheckBox(int order) {
		$("(//div[@data-test='conferenceservices-expectedservices-module']//img[@data-test='initiatesconference-expectedservices-cbx'])["+order+"]").click();
	}
	
	public void clickTSGProvidingBridgeCheckBox(int order) {
		$("(//div[@data-test='conferenceservices-expectedservices-module']//img[@data-test='tsgprovidingbridge-expectedservices-cbx'])["+order+"]").click();
	}
	
	public void clickCameoCheckBox(int order) {
		$("(//div[@data-test='conferenceservices-expectedservices-module']//img[@data-test='conferencehascammeo-expectedservices-cbx'])["+order+"]").click();
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
	
	public void clickAddEmailLink(int index) {
		$("(//a[@data-test='conferencecammeoaddemail-expectedservices-link']/../a[text()='Add Email'])[" + index+ "]").click();
	}
	
	public void clickAddEmailLinkInStreamingSection(int index) {
		$("(//div[@data-test='streamingservices-expectedservices-module']//a[text()='Add Email'])["+index+"]").click();
	}
	
	public void addEmail(int index, String email) {
		$("(//span[text()='Email to:']/../input)[" + index + "]").sendKeys(email);
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
	
	public void setIP(int index, String ip) {
		$("(//span[text()='IP']/../input)[" + index + "]").clear();
		$("(//span[text()='IP']/../input)[" + index + "]").sendKeys(ip);
	}
	
	public void setISDN(int index, String isdn) {
		$("(//span[text()='ISDN']/../input)[" + index + "]").clear();
		$("(//span[text()='ISDN']/../input)[" + index + "]").sendKeys(isdn);
	}
	
	public void setItContact(int index, String itContact) {
		$("(//span[text()='IT Contact']/../input)[" + index + "]").clear();
		$("(//span[text()='IT Contact']/../input)[" + index + "]").sendKeys(itContact);
	}
	
	public void setPhoneConfServices(int index, String phone) {
		$("(//span[text()='Phone']/../input[@data-test='conferencephone-expectedservices-text'])[" + index + "]").clear();
		$("(//span[text()='Phone']/../input[@data-test='conferencephone-expectedservices-text'])[" + index + "]").sendKeys(phone);
	}
	
	public void setNotes(int index, String notes) {
		$("(//span[text()='Notes']/../textarea[@data-test='conferencenotes-expectedservices-text'])[" + index +"]").clear();
		$("(//span[text()='Notes']/../textarea[@data-test='conferencenotes-expectedservices-text'])[" + index +"]").sendKeys(notes);
	}
	
	public void setNumberOfCameos(String number, int index) {
		$("(//span[text()='Number of Cameos']/../input)[" + index +"]").sendKeys(number);
	}
	
	public void addEmailConfServSection(String email, int index) {
		$("(//span[text()='Email to:']//..//input[@data-test='conferencecammeoemail-expectedservices-text'])[" + index +"]").clear();
		$("(//span[text()='Email to:']//..//input[@data-test='conferencecammeoemail-expectedservices-text'])[" + index +"]").sendKeys(email);
	}
	
	public void clickAddLanguage() {
		addLanguageLink.click();
	}
	
	public void selectLanguage(int index, int languageIndex) {
		$("(//div[@data-test='interpreterservices-expectedservices-module']//select)[" + index + "]").selectByIndex(languageIndex);
	}
	
	public void selectAppliedWitness(int index, int witnessIndex) {
		$("(//div[@data-test='interpreterservices-expectedservices-module']//select)[" + index + "]").selectByIndex(witnessIndex);
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
	
	public void clickOnVendorSection(int index) {
		$("(//div[@class='loadmask'])[" + index +"]").click();
	}
	
	public void removeLocation(int index) {
		$("(//a[text()='Remove Location'])[" + index + "]").click();
	}
	

	public void chooseRoomTSGLocation(int indexChkbx, int indexSelect) {
		$("((//div[@data-test='conferenceservices-expectedservices-module']//select)[2])[" + indexChkbx +"]").selectByIndex(indexSelect);
	}
	public void deleteLanguage(int index) {
		$("(//div[@data-test='interpreterservices-expectedservices-module']//a[@class='icon delete'])[" + index +"]").click();

	}

}
