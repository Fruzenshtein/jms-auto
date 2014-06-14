package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jms.model.Address;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;

public class JobDetailPage extends PageObject {
	
	@FindBy(xpath="//span[text()='Scheduling Firm']/../input[@type='text']")
	private WebElement scheduleFirmField;
	
	@FindBy(xpath="//span[text()='Client Matter #']/../input[@type='text']")
	private WebElement clientMatterNField;
	
	@FindBy(xpath="//span[text()='Date']/../input")
	private WebElement dateField;
	
	@FindBy(xpath="//span[text()='Case Name']/../input[@type='text']")
	private WebElement caseNameField;
	
	@FindBy(xpath="//span[text()='Contributing Firm']/../input[@type='text']")
	private WebElement contributingFirmField;
	
	@FindBy(xpath="//span[text()='Name']/../input[@type='text']")
	private WebElement witnessNameField;
	
	@FindBy(xpath="//input[@class='locationname autocomplete-input']")
	private WebElement locationAutocompleteField;
	
	@FindBy(xpath="//div[@class='header']/span[text()='Job Detail']/..//button[1]")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[text()='Expected Services']")
	private WebElement expectedServicesButton;
	
	@FindBy(xpath="//div[@class='jobdetail-view scroll-view']")
	private WebElement jobDetailWidget;
	
	@FindBy(xpath="(//div[@class='tabs box-tabs']/div)[1]//div[@class='vendor-name']")
	private WebElement vendorTabs;
	
	@FindBy(xpath="//table[@class='jobdetail-equipment']//th[@class='vendor-name']")
	private WebElement vendorNameInJobDetailEquipment;
	
	@FindBy(className="manage")
	private WebElement manageButton;
	
	@FindBy(xpath="//span[text()='Add Firm']")
	private WebElement addFirmButton;
	
	@FindBy(xpath="//span[text()='Add Witness']")
	private WebElement addWitnessButton;
	
	@FindBy(className="typeDpl")
	private WebElement caseTypeDropDown;
	
	@FindBy(className="actionnumber")
	private WebElement actionNumber;
	
	@FindBy(linkText="Add Conference Line")
	private WebElement addConferenceLine;
	
	@FindBy(className="phonenumberprovided")
	private WebElement caseInfoPhoneNumber;
	
	@FindBy(xpath="//span[text()='Passcode']/../input")
	private WebElement passCode;
	
	@FindBy(xpath="//span[text()='Instructions']/../textarea")
	private WebElement instructionsTextarea;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement clearAddressOkButton;
	
	@FindBy(xpath="//input[@class='firstExpectedStart hasTimeEntry']")
	private WebElement expectedStartTimeField;
	
	@FindBy(xpath="//span[text()='Expected End']/..//input")
	private WebElement expectedFinishTimeField;
	
	public void setSchedulingFirm(String name) {
		scheduleFirmField.sendKeys(name);
		getClock().pauseFor(2500);
		getDriver().findElement(By.xpath("//strong[text()='"+name+"']")).click();
	}
	
	public void setClientMatterN(String number) {
		clientMatterNField.clear();
		clientMatterNField.sendKeys(number);
	}
	
	public String getClientMatterN() {
		getClock().pauseFor(2000);
		return clientMatterNField.getText();
	}
	
	public void setDate(String date) {
		dateField.clear();
		dateField.sendKeys(date);
	}
	
	public void setCaseName(String name) {
		caseNameField.clear();
		caseNameField.sendKeys(name);
		getClock().pauseFor(1500);
		getDriver().findElement(By.xpath("//strong[text()='"+name+"']")).click();
	}
	
	public void setContributingFirm(String name) throws InterruptedException {
		contributingFirmField.sendKeys(name);
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//strong[text()='"+name+"']")).click();
	}
	
	public void setLocationAutoComplete(String location) throws InterruptedException {
		locationAutocompleteField.sendKeys(location);
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//strong[text()='"+location+"']")).click();
	}
	
	public void setWitnessName(int index, String name) {
		WebElement el = $("(//span[text()='Name']/../input[@type='text'])["+index+"]");
		el.clear();
		el.sendKeys(name);
	}
	
	public void setWitnessStartingPgN(int index, String value) {
		WebElement el = $("(//span[text()='Starting Pg #']/../input[@type='text'])["+index+"]");
		el.clear();
		el.sendKeys(value);
	}
	
	public boolean isServiceIconInWitnessInfo(VendorService vendor, boolean is) {
		if (is)
			return $("(//label[@class='vendor-services "+
					vendor.getName()+" checkbox checked'])[2]")
					.isPresent();
		else
			return $("(//label[@class='vendor-services "+
					vendor.getName()+" checkbox'])[2]")
					.isPresent();
	}
	
	public boolean isServiceIconInVendorSection(VendorService vendor, boolean is) {
		if (is)
			return $("//div[@class='module-container jobdetail-vendorinfo-container']" +
					"//div[@class='vendor-services "+vendor.getName()+" on']")
					.waitUntilPresent()
					.isPresent();
		else
			return $("//div[@class='module-container jobdetail-vendorinfo-container']" +
					"//div[@class='vendor-services "+vendor.getName()+"']")
					.waitUntilPresent()
					.isPresent();
	}
	
	public void clickSave() {
		$(saveButton).waitUntilEnabled().click();
	}
	
	public String getJobDetailHeaderLabel(JobDetailHeaderLabel label) {
		return $("//div[text()='"+label.getLabel()+"']/../div[@class='showinfo-text']")
				.getText();
	}
	
	public void clickExpectedServicesButton() {
		getClock().pauseFor(3000);
		$(expectedServicesButton).waitUntilVisible().click();
	}
	
	public void activeWidget() {
		$(jobDetailWidget).waitUntilVisible();
	}
	
	public String getReporterName() {
		return vendorTabs.getText();
	}
	
	public String getVendorNameInJobDetailEquipment() {
		return vendorNameInJobDetailEquipment.getText();
	}
	
	public void clickManageButton() {
		getClock().pauseFor(5000);
		$(manageButton).waitUntilEnabled().click();
	}
	
	public void clickVendorActionLink(int index) {
		$("(//div[@class='vendors']//div[@class='actionmenu-link'])["+index+"]").click();
	}
	
	public String getVendorNameInManageModule(int index) {
		return $("(//div[@class='vendors']//span[@class='title'])["+index+"]").getText();
	}
	
	public void clickAddFirmButton() {
		addFirmButton.click();
	}
	
	public void clickAddWitnessButton() {
		addWitnessButton.click();
	}
	
	public void selectCaseType(String type) {
		$(caseTypeDropDown).selectByVisibleText(type);
	}
	
	public void clickCaseInfoCheckBox(String checkBoxLabel) {
		$("//span[text()='"+checkBoxLabel+"']").click();
	}
	
	public void setActionNumber(String number) {
		actionNumber.clear();
		actionNumber.sendKeys(number);
	}
	
	public void clickAddConferenceLink() {
		addConferenceLine.click();
	}
	
	/**
	 * Method for activated 'Client Provided'
	 */
	public void setCaseInfoPhoneNumber(String number) {
		caseInfoPhoneNumber.sendKeys(number);
	}
	
	/**
	 * Method for activated 'TSG Provided'
	 */
	public void selectCaseInfoPhoneNumber(int index) {
		$(caseInfoPhoneNumber).selectByIndex(index);
	}
	
	public void setCaseInfoPassCode(String code) {
		passCode.sendKeys(code);
	}
	
	public void setCaseInstructions(String instructions) {
		instructionsTextarea.sendKeys(instructions);
	}
	
	public Address getLocationAddress(int index) {
		Address address = new Address();
		int companyIndex = 1 + index;
		address.setCompany($("(//span[text()='Company']/../input[@type='text'])[" + companyIndex +"]").getValue())
			.setAddress($("(//span[text()='Address']/../input[@type='text'])["+index+"]").getValue())
			.setCity($("(//span[text()='City']/../input[@type='text'])["+index+"]").getValue())
			.setZip($("(//span[text()='Zip']/../input[@type='text'])["+index+"]").getValue())
			.setCountry($("(//select[@class='Country'])["+index+"]").getSelectedVisibleTextValue());
		return address;
	}
	
	public void setLocationAddressNotes(int index, String notes) {
		$("(//span[text()='Notes']/../textarea)["+index+"]").sendKeys(notes);
	}
	
	public void setLocationAddressConfRm(int index, String confRm) {
		$("(//span[text()='Conf Rm']/../input[@type='text'])["+index+"]").sendKeys(confRm);
	}
	
	public void setLocationAddressContact(int index, String contact) {
		$("(//span[text()='Contact']/../input[@type='text'])["+index+"]").sendKeys(contact);
	}
	
	public void setLocationAddressPhone(int index, String phone) {
		$("(//span[text()='Phone']/../input[@type='text'])["+index+"]").sendKeys(phone);
	}
	
	public void clickClearAddressFields(int index) {
		$("(//a[text()='Clear Address Fields'])["+index+"]").click();
	}
	
	public void clickOkButton() {
		clearAddressOkButton.click();
	}
	
	public void setExpectedStartTime(String time) {
		expectedStartTimeField.sendKeys(time);
	}
	
	public String getExpectedStartTime() {
		return $(expectedStartTimeField).getValue();
	}
	
	public void setExpectedFinishTime(String time) {
		expectedFinishTimeField.sendKeys(time);
	}
	
	public String getExpectedFinishTime() {
		return $(expectedFinishTimeField).getValue();
	}
	
	public void clickActionMenuLink(int index, String link) {
		$("(//div[@class='vendors']//a[text()='"+link+"'])["+index+"]")
			.waitUntilVisible()
			.click();
	}
	
	public boolean isBeacon(String name, String state) {
		return $("//div[contains(@class, '"+state+"') and text()='"+name+"']").waitUntilDisabled().isDisplayed();
	}
	
}
