package com.jms.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jms.model.Address;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;
import com.jms.pages.elements.VendorTab;

public class JobDetailPage extends PageObject {

	@FindBy(xpath = "//span[text()='Scheduling Firm']/../input[@type='text']")
	private WebElement scheduleFirmField;

	@FindBy(xpath = "//span[text()='Client Matter #']/../input[@type='text']")
	private WebElement clientMatterNField;

	@FindBy(xpath = "//span[text()='Date']/../input")
	private WebElement dateField;

	@FindBy(xpath = "//span[text()='Case Name']/../input[@type='text']")
	private WebElement caseNameField;

	@FindBy(xpath = "//span[text()='Contributing Firm']/../input[@type='text']")
	private WebElement contributingFirmField;

	@FindBy(xpath = "//span[text()='Name']/../input[@type='text']")
	private WebElement witnessNameField;

	@FindBy(xpath = "//input[@class='locationname autocomplete-input']")
	private WebElement locationAutocompleteField;

	@FindBy(xpath = "//div[@class='header']/span[text()='Job Detail']/..//button[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//span[text()='Expected Services']")
	private WebElement expectedServicesButton;

	@FindBy(xpath = "//div[@class='jobdetail-view scroll-view']")
	private WebElement jobDetailWidget;

	@FindBy(xpath = "(//div[@class='tabs box-tabs']/div)[1]//div[@class='vendor-name']")
	private WebElement vendorTabs;

	@FindBy(xpath = "//table[@class='jobdetail-equipment']//th[@class='vendor-name']")
	private WebElement vendorNameInJobDetailEquipment;

	@FindBy(className = "manage")
	private WebElement manageButton;

	@FindBy(xpath = "//span[text()='Add Firm']")
	private WebElement addFirmButton;

	@FindBy(xpath = "//span[text()='Add Witness']")
	private WebElement addWitnessButton;

	@FindBy(className = "typeDpl")
	private WebElement caseTypeDropDown;

	@FindBy(className = "actionnumber")
	private WebElement actionNumber;

	@FindBy(linkText = "Add Conference Line")
	private WebElement addConferenceLine;

	@FindBy(className = "phonenumberprovided")
	private WebElement caseInfoPhoneNumber;

	@FindBy(xpath = "//span[text()='Passcode']/../input")
	private WebElement passCode;

	@FindBy(xpath = "//span[text()='Instructions']/../textarea")
	private WebElement instructionsTextarea;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement clearAddressOkButton;

	@FindBy(xpath = "//input[@class='firstExpectedStart hasTimeEntry']")
	private WebElement expectedStartTimeField;

	@FindBy(xpath = "//div[@class='module-container jobdetail-vendorinfo-container']//input[@class='hasTimeEntry']")
	private WebElement expectedFinishTimeField;

	@FindBy(id = "sidemenu-open-link")
	private WebElement sideMenuBar;

	@FindBy(xpath = "//div[@class='module-container jobdetail-clientinfo-container']//div[@class='collapsed on']")
	private WebElement clientInfoMaximizeIcon;

	@FindBy(xpath = "//div[@class='module-container jobdetail-caseinfo-container']//div[@class='collapsed on']")
	private WebElement caseInfoMaximizeIcon;

	@FindBy(xpath = "//a[@class='additonalcontact']")
	private WebElement addAdditionalContactLink;

	@FindBy(xpath = "//label[@class='checkbox']//img[@id='ic_imageCheckInput_36' and @aria-checked='false']")
	private WebElement additionalContactConfirm;

	@FindBy(xpath = "//input[@class='contact autocomplete-input']")
	private WebElement schedulingFirmContact;

	@FindBy(xpath = "//label[@class='right checkbox checked']//img[@aria-checked='true']")
	private WebElement schedulingFirmConfirmCheckbox;

	@FindBy(xpath = "//label[@class='checkbox checked']//img[@aria-checked='true']")
	private WebElement schedulingFirmContactConfirmCheckbox;

	@FindBy(xpath = "//span[text()='Req. Vendor']/../input[@type='text']")
	private WebElement requestedVendor;

	@FindBy(xpath = "//div[@class='clr']//a[@class='quickcrmadd']")
	private WebElement quickCRMAddLink;

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='First Name']/../input[@type='text']")
	private WebElement quickCRMAddFirstName;

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='Last Name']/../input[@type='text']")
	private WebElement quickCRMAddLastName;

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='Email Address']/../input[@type='text']")
	private WebElement quickCRMAddEmailAddress;

	@FindBy(xpath = "//div[@class='buttons']//span[text()='Submit']")
	private WebElement submitButtonQuickCRM;

	@FindBy(xpath = "(//div[@class='actionmenu-link'])[2]")
	private WebElement actionMenuLinkSecondContact;

	private static ArrayList<String> clientMatterNumbersList = new ArrayList<String>();

	public void setSchedulingFirm(String name) {
		scheduleFirmField.sendKeys(name);
		getClock().pauseFor(2500);
		getDriver().findElement(By.xpath("//strong[text()='" + name + "']"))
				.click();
	}

	public void setSchedulingFirmContact(String schedulingFirmContactName) {
		schedulingFirmContact.sendKeys(schedulingFirmContactName);
		getClock().pauseFor(2500);
		// getDriver().findElement(By.xpath("//strong[text()='" +
		// schedulingFirmContact + "']")).click();
		getDriver()
				.findElement(
						By.xpath("//strong[text()='"
								+ schedulingFirmContactName + "']")).click();
	}

	public void setClientMatterN(String number) {
		clientMatterNField.clear();
		clientMatterNField.sendKeys(number);
	}

	public ArrayList<String> writeClientMatterNInTheList() {
		clientMatterNumbersList.add(clientMatterNField.getText());
		return clientMatterNumbersList;
	}

	public String getClientMatterNFromTheList(int index) {
		return clientMatterNumbersList.get(index);
	}

	public void clearClientMatterNList() {
		clientMatterNumbersList.clear();
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
		getDriver().findElement(By.xpath("//strong[text()='" + name + "']"))
				.click();
	}

	public void setContributingFirm(String name) throws InterruptedException {
		contributingFirmField.sendKeys(name);
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//strong[text()='" + name + "']"))
				.click();
	}

	public void setLocationAutoComplete(String location)
			throws InterruptedException {
		locationAutocompleteField.sendKeys(location);
		Thread.sleep(3000);
		getDriver()
				.findElement(By.xpath("//strong[text()='" + location + "']"))
				.click();
	}

	public void setWitnessName(int index, String name) {
		WebElement el = $("(//span[text()='Name']/../input[@type='text'])["
				+ index + "]");
		el.clear();
		el.sendKeys(name);
	}

	public void setWitnessStartingPgN(int index, String value) {
		WebElement el = $("(//span[text()='Starting Pg #']/../input[@type='text'])["
				+ index + "]");
		el.clear();
		el.sendKeys(value);
	}

	public boolean isServiceIconInWitnessInfo(VendorService vendor, boolean is) {
		if (is)
			return $(
					"(//label[@class='vendor-services " + vendor.getName()
							+ " checkbox checked'])[2]").isPresent();
		else
			return $(
					"(//label[@class='vendor-services " + vendor.getName()
							+ " checkbox'])[2]").isPresent();
	}

	public boolean isServiceIconInVendorSection(VendorService vendor, boolean is) {
		if (is)
			return $(
					"//div[@class='module-container jobdetail-vendorinfo-container']"
							+ "//div[@class='vendor-services "
							+ vendor.getName() + " on']").waitUntilPresent()
					.isPresent();
		else
			return $(
					"//div[@class='module-container jobdetail-vendorinfo-container']"
							+ "//div[@class='vendor-services "
							+ vendor.getName() + "']").waitUntilPresent()
					.isPresent();
	}

	public void clickSave() {
		$(saveButton).waitUntilEnabled().click();
	}

	public String getJobDetailHeaderLabel(JobDetailHeaderLabel label) {
		return $(
				"//div[text()='" + label.getLabel()
						+ "']/../div[@class='showinfo-text']").getText();
	}

	public void clickExpectedServicesButton() {
		getClock().pauseFor(2000);
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
		$(
				"(//div[@class='vendors']//div[@class='actionmenu-link'])["
						+ index + "]").click();
	}

	public String getVendorNameInManageModule(int index) {
		return $(
				"(//div[@class='vendors']//span[@class='title'])[" + index
						+ "]").getText();
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
		$("//span[text()='" + checkBoxLabel + "']").click();
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
		address.setCompany(
				$(
						"(//span[text()='Company']/../input[@type='text'])["
								+ companyIndex + "]").getValue())
				.setAddress(
						$(
								"(//span[text()='Address']/../input[@type='text'])["
										+ index + "]").getValue())
				.setCity(
						$(
								"(//span[text()='City']/../input[@type='text'])["
										+ index + "]").getValue())
				.setZip($(
						"(//span[text()='Zip']/../input[@type='text'])["
								+ index + "]").getValue())
				.setCountry(
						$("(//select[@class='Country'])[" + index + "]")
								.getSelectedVisibleTextValue());
		return address;
	}

	public void setLocationAddressNotes(int index, String notes) {
		$("(//span[text()='Notes']/../textarea)[" + index + "]")
				.sendKeys(notes);
	}

	public void setLocationAddressConfRm(int index, String confRm) {
		$("(//span[text()='Conf Rm']/../input[@type='text'])[" + index + "]")
				.sendKeys(confRm);
	}

	public void setLocationAddressContact(int index, String contact) {
		$("(//span[text()='Contact']/../input[@type='text'])[" + index + "]")
				.sendKeys(contact);
	}

	public void setLocationAddressPhone(int index, String phone) {
		$("(//span[text()='Phone']/../input[@type='text'])[" + index + "]")
				.sendKeys(phone);
	}

	public void clickClearAddressFields(int index) {
		$("(//a[text()='Clear Address Fields'])[" + index + "]").click();
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

	public void clickVendorsActionMenuLink(int index, String link) {
		$("(//div[@class='vendors']//a[text()='" + link + "'])[" + index + "]")
				.waitUntilVisible().click();
	}

	public void isBeacon(String name, String state) {
		$("//div[contains(@class, '" + state + "') and text()='" + name + "']")
				.shouldBeCurrentlyVisible();
	}

	public void checkClientMatterNumberIsDisabled() {
		$(clientMatterNField).shouldNotBeEnabled();
	}

	public void maximizeClientInfoSection() {
		clientInfoMaximizeIcon.click();
	}

	public void maximizeCaseInfoSection() {
		caseInfoMaximizeIcon.click();
	}

	public void clearClientMatterNumber() {
		clientMatterNField.clear();
	}

	public void assertClientMatterNIsDisabled() {
		$(clientMatterNField).shouldNotBeEnabled();
	}

	public void clearSchedulingFirmField() {
		scheduleFirmField.clear();
	}

	public void addAdditionalContact() {
		addAdditionalContactLink.click();
	}

	public void clickQuickCRMAddLink() {
		quickCRMAddLink.click();
	}

	public void checkSchedulingFirmConfirmCheckbox() {
		$(schedulingFirmConfirmCheckbox).isPresent();
	}

	public void checkSchedulingFirmContactConfirmCheckbox() {
		$(schedulingFirmContactConfirmCheckbox).isPresent();
	}

	public void addRequestedVendor(String requestedVendorName) {
		requestedVendor.clear();
		$(requestedVendor).sendKeys(requestedVendorName);
		getClock().pauseFor(2500);
		getDriver().findElement(
				By.xpath("//strong[text()='" + requestedVendorName + "']"))
				.click();
	}

	public void assertSchedulingFirmIsAdded(String schedulingFirm) {
		$("//div[@class='client-info']//div[text()='" + schedulingFirm + "']")
				.isPresent();
	}

	public void addFirstNameQuickCRM(String firstName) {
		quickCRMAddFirstName.sendKeys(firstName);
	}

	public void addLastNameQuickCRM(String lastName) {
		quickCRMAddLastName.sendKeys(lastName);
	}

	public void addEmailAddressQuickCRM(String emailAddress) {
		quickCRMAddEmailAddress.sendKeys(emailAddress);
	}

	public void clickSubmitButtonQuickCRM() {
		submitButtonQuickCRM.click();
	}

	public void clickActionMenuLinkSecondContact() {
		actionMenuLinkSecondContact.click();
	}
	
	public void selectVendorTab(String tab, String vendor) {
		$("//div[@data-test='" + tab + "']//div[@class='vendor-services " + vendor + " on']").click();
	//	$("//div[@class='tabs box-tabs']//div[@data-test='" + tab +"']").click();
	}

	public void setVendorNotes(String notes) {
		$("//textarea[@class='tabnotes']").sendKeys(notes);;
	}
	
	public void setStreamingVendorNotes(String notes) {
		$("//textarea[@class='notesb']").sendKeys(notes);;
	}
	
	public String getVendorNotes() {
		return $("//textarea[@class='tabnotes']").getValue();
	}
	
	public String getStreamingVendorNotes() {
		return $("//textarea[@class='notesb']").getValue();
	}
	
	public void clearVendorNotes() {
		$("//textarea[@class='tabnotes']").clear();
	}
	
	public void clearExpectedStartEndTime() {
		 expectedStartTimeField.clear();
		 expectedFinishTimeField.clear();
	}
	
	public boolean checkVendorTBDStartTime(int index, boolean is) {
		if (is) 
		return $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck checked' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
		else return $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
	}
	
	public boolean checkVendorTBDEndTime(int index, boolean is) {
		if (is) 
		return $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//label[@class='toggle-switch checked']//img[@class='imageCheck checked' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
		else return $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//label[@class='toggle-switch checked']//img[@class='imageCheck checked' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
	}
	
	public void markTBDVendorStartTime(int indexStart) {
		 $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck'])[" + indexStart + "]").waitUntilVisible().click();
		 
	}
	
	public void markTBDVendorEndTime(int indexEnd) {
		 $("(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck'])[" + indexEnd + "]").waitUntilVisible().click();
	}
	
	public void setStreamingSessionID(String id) {
		 $("//span[text()='Session ID']/../input[@type='text']").sendKeys(id);
	}
	
	public String getStreamingSessionID() {
		return $("//span[text()='Session ID']/../input[@type='text']").getValue();
	}
	
	public void attachRatesSheet(int index) throws AWTException {
		$("(//div[@class='mb-5']//div[@class='qq-upload-button'])["+ index+"]").click();
		getClock().pauseFor(5000);
		/*StringSelection ss = new StringSelection("Libraries\\Documents\\RatesSheet.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000); */
	}
	
	public void maximizeMinimizeRatesSection() {
		$("//div[@data-test='jobdetail-ratesinfo-container']//div[@class='collapsed on']").click();
	}
	
	public void checkAdminApprovedChckbxRates(int index) {
		$("(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox'])[" + index + "]").click();
	}
	
	public boolean getAdminApprovedChckbxRates(int index, boolean is) {
		if (is)
			return $("(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
		else return $("(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox' and @aria-checked='" + is + "'])[" + index + "]").isPresent();
	}
	
	public void addRatesNotes(int index, String notes) {
		$("(//label[@class='clr']//textarea[@class='ratesnotes'])[" + index + "]").sendKeys(notes);
	}
	
	public String getRatesNotes(int index) {
		return $("(//label[@class='clr']//textarea[@class='ratesnotes'])[" + index + "]").getValue();
	}
	
	public void clearRatesNotes(int index) {
		 $("(//label[@class='clr']//textarea[@class='ratesnotes'])[" + index + "]").clear();
	}
	
	public void maximizeMinimizeCommissionSection() {
		$("//div[@class='module micro jobdetail-commission-view']//div[@class='collapsed on']").click();
	}
	
	public void clickCommissionApplyLink() {
		$("//div[@class='module micro jobdetail-commission-view']//a[@class='commissionapply']").click();
	}
	
	public void clickApplyButtonCommission() {
		$("//button[@class='blue']/span[text()='Apply']").click();
	}
	
	public String getAppliedCommission() {
		return $("//div[@class='module micro jobdetail-commission-view']//span[text()='123, 1. / 123, 1. (3 - 3)']").getValue();
	}
	
	public void deleteAppliedCommission(int index) {
		$("(//div[@class='module micro jobdetail-commission-view']//a[@class='icon delete'])[" + index + "]").click();
	}
}
