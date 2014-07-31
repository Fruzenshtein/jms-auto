package com.jms.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='First Name']/../input[@type='text']")
	private WebElement quickCRMAddFirstName;

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='Last Name']/../input[@type='text']")
	private WebElement quickCRMAddLastName;

	@FindBy(xpath = "//div[@class='modal-content crmadmin-quickaddcontact-view']//span[text()='Email Address']/../input[@type='text']")
	private WebElement quickCRMAddEmailAddress;

	@FindBy(xpath = "//div[@class='buttons']//span[text()='Submit']")
	private WebElement submitButtonQuickCRM;
	
	@FindBy(xpath = "//td/input[@data-test='reportlaptops-equipment-txt']")
	private WebElement reporterCompanyRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='videographerlaptops-equipment-txt']")
	private WebElement videographerCompanyRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='resources-equipment-txt']")
	private WebElement additionalResourceCompanyRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='additionaltotalneeded-equipment-txt']")
	private WebElement quantityAdditionalRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='additionalreporter-equipment-txt']")
	private WebElement reporterAdditionalRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='additionalvideographer-equipment-txt']")
	private WebElement videographerAdditionalRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='additionalresoruces-equipment-txt']")
	private WebElement additionalAdditionalRowTD;
	
	@FindBy(xpath = "//td/input[@data-test='vbrickreporter-equipment-txt']")
	private WebElement reporterVBrickRow;
	
	@FindBy(xpath = "//td/input[@data-test='vbrickvideographer-equipment-txt']")
	private WebElement videographerVBrickRow;
	
	@FindBy(xpath = "//td/input[@data-test='vbrickadditional-equipment-txt']")
	private WebElement additionalResourceVBrickRow;
	
	@FindBy(xpath = "//td/input[@data-test='streamingreporter-equipment-txt']")
	private WebElement reporterStreamingRow;
	
	@FindBy(xpath = "//td/input[@data-test='streamingvideographer-equipment-txt']")
	private WebElement videographerStreamingRow;
	
	@FindBy(xpath = "//td/input[@data-test='streamingadditional-equipment-txt']")
	private WebElement additionalStreamingRow;

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
		return $("//div[text()='" + label.getLabel() + "']/../div[@class='showinfo-text']").getText();
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
		$("//select[@class='phonenumberprovided']").selectByIndex(index);
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

	public void clickQuickCRMAddLink(int index) {
		$("(//div[@class='clr']//a[@class='quickcrmadd'])["+ index + "]").click();
	}

	public void checkSchedulingFirmConfirmCheckbox() {
		$(schedulingFirmConfirmCheckbox).isPresent();
	}

	public void checkFirmContactCheckbox(int index) throws NoSuchElementException{
		//	 if ($("(//div[@data-test='jobdetail-clientinfo-container']//img[@role='checkbox' and @aria-checked='false'])[" + index + "]").isVisible()) { 
		//	 $("(//div[@data-test='jobdetail-clientinfo-container']//img[@role='checkbox'])[" + index + "]").click(); 
		//	 } else if ($("(//div[@data-test='jobdetail-clientinfo-container']//img[@role='checkbox' and @aria-checked='true'])[" + index + "]").isVisible())
		//		 return;
			 
			 if ( !(getDriver().findElement(By.xpath("(//div[@data-test='jobdetail-clientinfo-container']//img[@role='checkbox'])[" + index + "]")).isSelected()))
			 {
				 getDriver().findElement(By.xpath("(//div[@data-test='jobdetail-clientinfo-container']//img[@role='checkbox'])[" + index + "]")).click();
			 }
	}
	
	public void clickAddRequestedVendorLink(int index) {
		$("(//a[text()='Add Requested Vendor'])[" + index + "]").click();
	}

	public void addRequestedVendor(String requestedVendorName, int index) {
		
		$("(//span[text()='Req. Vendor']/../input[@type='text'])[" + index + "]").clear();
		$("(//span[text()='Req. Vendor']/../input[@type='text'])[" + index + "]").sendKeys(requestedVendorName);
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

	public void clickActionMenuLink(int index) {
		$(
				"(//div[@data-test='jobdetail-clientinfo-container']//div[@class='actionmenu-link'])["
						+ index + "]").click();
	}

	public void selectActionMenuOption(String option, int index) {
		$(
				"(//div[@data-test='jobdetail-clientinfo-container']//div[@class='actionmenu-content']//a[text()='"
						+ option + "'])[" + index + "]").waitUntilVisible()
				.click();
	}

	public void selectVendorTab(String tab, String vendor) {
		$(
				"//div[@data-test='" + tab + "']//div[@class='vendor-services "
						+ vendor + " on']").click();
		// $("//div[@class='tabs box-tabs']//div[@data-test='" + tab
		// +"']").click();
	}

	public void setVendorNotes(String notes) {
		$("//textarea[@class='tabnotes']").sendKeys(notes);
		;
	}

	public void setStreamingVendorNotes(String notes) {
		$("//textarea[@class='notesb']").sendKeys(notes);
		;
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
			return $(
					"(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@aria-checked='"	+ is + "'])[" + index + "]").isPresent();
		else
			return $(
					"(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck' and @aria-checked='"
							+ is + "'])[" + index + "]").isPresent();
	}

	public boolean checkVendorTBDEndTime(int index, boolean is) {
		if (is)
			return $(
					"(//div[@class='module tabbed jobdetail-vendorinfo-view']//label[@class='toggle-switch checked']//img[@class='imageCheck checked' and @aria-checked='"
							+ is + "'])[" + index + "]").isPresent();
		else
			return $(
					"(//div[@class='module tabbed jobdetail-vendorinfo-view']//label[@class='toggle-switch checked']//img[@class='imageCheck checked' and @aria-checked='"
							+ is + "'])[" + index + "]").isPresent();
	}

	public void markTBDVendorStartTime(int indexStart) {
		$(
				"(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck'])["
						+ indexStart + "]").waitUntilVisible().click();

	}

	public void markTBDVendorEndTime(int indexEnd) {
		$(
				"(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck'])["
						+ indexEnd + "]").waitUntilVisible().click();
	}
	
	public void unmarkTBDVendorEndTime(int indexEnd) {
		$(
				"(//div[@class='module tabbed jobdetail-vendorinfo-view']//img[@class='imageCheck checked'])["
						+ indexEnd + "]").waitUntilVisible().click();
	}

	public void setStreamingSessionID(String id) {
		$("//span[text()='Session ID']/../input[@type='text']").sendKeys(id);
	}

	public String getStreamingSessionID() {
		return $("//span[text()='Session ID']/../input[@type='text']")
				.getValue();
	}

	public void attachRatesSheet(int index) throws AWTException {
		$(
				"(//input[@type='file'])[" + index + "]").click();
		getClock().pauseFor(5000);
		
		  StringSelection ss = new
		  StringSelection("C:\\Users\\Install\\Documents\\RatesSheet.txt");
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
		  robot.delay(1000);

	}

	public void maximizeRatesSection() {
		$(
				"//div[@data-test='jobdetail-ratesinfo-container']//div[@class='collapsed on']")
				.click();
	}
	
	public void minimizeRatesSection() {
		$(
				"//div[@data-test='jobdetail-ratesinfo-container']//div[@class='collapsed off']")
				.click();
	}

	public void checkAdminApprovedChckbxRates(int index) {
		$(
				"(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox'])["
						+ index + "]").click();
	}

	public boolean getAdminApprovedChckbxRates(int index, boolean is) {
		if (is)
			return $(
					"(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox' and @aria-checked='"
							+ is + "'])[" + index + "]").isPresent();
		else
			return $(
					"(//div[@data-test='jobdetail-ratesinfo-container']//img[@role='checkbox' and @aria-checked='"
							+ is + "'])[" + index + "]").isPresent();
	}

	public void addRatesNotes(int index, String notes) {
		$(
				"(//label[@class='clr']//textarea[@class='ratesnotes'])["
						+ index + "]").sendKeys(notes);
	}

	public String getRatesNotes(int index) {
		return $(
				"(//label[@class='clr']//textarea[@class='ratesnotes'])["
						+ index + "]").getValue();
	}

	public void clearRatesNotes(int index) {
		$(
				"(//label[@class='clr']//textarea[@class='ratesnotes'])["
						+ index + "]").clear();
	}

	public void maximizeCommissionSection() {
		$(
				"//div[@class='module micro jobdetail-commission-view']//div[@class='collapsed on']")
				.click();
	}
	
	public void minimizeCommissionSection() {
		$(
				"//div[@class='module micro jobdetail-commission-view']//div[@class='collapsed off']")
				.click();
	}

	public void clickCommissionApplyLink() {
		$(
				"//div[@class='module micro jobdetail-commission-view']//a[@class='commissionapply']")
				.click();
	}

	public void clickApplyButtonCommission() {
		$("//button[@class='blue']/span[text()='Apply']").click();
	}

	public String getAppliedCommission() {
		return $(
				"//div[@class='module micro jobdetail-commission-view']//span[text()='123, 1. / 123, 1. (3 - 3)']")
				.getValue();
	}

	public void deleteAppliedCommission(int index) {
		$(
				"(//a[@class='icon delete'])["
						+ index + "]").click();
	}
	
	public void addCommissionNotes(String commissionNotes) {
		$("//textarea[@data-test='jobcommission-notes-text']").sendKeys(commissionNotes);
	}
	
	public String getCommissionNotes() {
		return $("//textarea[@data-test='jobcommission-notes-text']").getTextValue();
	}
	
	public void removeAddedFirm(int index) {
		$("(//div[@data-test='jobclient-delete-button'])[" + index + "]").click();
	}
	
	public String retrieveReporterEquipmentSection(int index) {
		return $("(//div[@class='vendor-name left'])[" + index + "]").waitUntilVisible().getTextValue();
	////div[@data-test='report-equipment-icon']
	}
	
	public String retrieveVideographerEquipmentSection(int index) {
		return $("(//div[@class='vendor-name left'])[" + index + "]").waitUntilVisible().getTextValue();
	}
	
	public void minimizeMaximizeEquipmentSection() {
		$("//div[@data-test='jobdetail-equipmentinfo-container']//div[@class='collapsed on']").click();
	}
	
	public void addSalesPersonCommissionSection() {
		$("//div[@data-test='jobcommission-addsalesperson-button']").click();
	}
	
//	public void selectASalesPersonCommissionSection() {
//		$("//div[@data-test='jobcommission-addsalesperson-button']").selectByIndex(3);
//	}
	
	public void addNotesCommissionSection(String commissionNotes) {
		$("//textarea[@data-test='jobcommission-notes-text']").clear();
		$("//textarea[@data-test='jobcommission-notes-text']").sendKeys(commissionNotes);
	}
	
	public String getNotesCommissionSection() {
		return $("//textarea[@data-test='jobcommission-notes-text']").getValue();
	}
	
	public void changeCommissionPercentage(int index, String percentage) {
		$("(//div[@data-test='jobdetail-commission-container']//input[@type='text'])[" + index + "]").clear();
		$("(//div[@data-test='jobdetail-commission-container']//input[@type='text'])[" + index + "]").sendKeys(percentage);
	}
	
	public String getCommissionPercentage(int index) {
		return $("(//div[@data-test='jobdetail-commission-container']//input[@type='text'])[" + index + "]").getTextValue();
	}
	
	public void maximizeFilesSection() {
		$(
				"//div[@data-test='jobdetail-fileinfo-container']//div[@class='collapsed on']")
				.click();
	}
	
	public void minimizeFilesSection() {
		$(
				"//div[@data-test='jobdetail-fileinfo-container']//div[@class='collapsed off']")
				.click();
	}
	
	public void addAnotherFileFilesSection(int index) throws AWTException {

		$("(//input[@type='file'])[" + index + "]").click();
		  getClock().pauseFor(5000);
		
		  StringSelection ss = new
		  StringSelection("Libraries\\Documents\\RatesSheet.txt");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
		  Robot robot = new Robot(); 
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(1000);
	}
	
	public void deleteAnotherFileFilesSection(int index) {
		$("//a[@class='icon delete']").click();
	}
	
	public void addFilesNotes(String filesNotes) {
		$("//textarea[@class='filesnotes']").clear();
		$("//textarea[@class='filesnotes']").sendKeys(filesNotes);
	}
	
	public String getFilesNOtes() {
		return $("//textarea[@class='filesnotes']").getValue();
		
	}
	
	public void checkInternetHardlineConfirmed() {
		$("//div[@class='left mt-10 mr-5']//img[@aria-controls='imageCheckInput_308' and @aria-checked='true']").waitUntilPresent().isPresent();
		
	}
	
	public void checkVideoStreamHardlineConfirmed() {
		$("//div[@class='module tabbed jobdetail-vendorinfo-view']//div[@class='left mt-10']//img[@aria-controls='imageCheckInput_309' and @aria-checked='true']").waitUntilPresent().isPresent();
	}
	
	public void selectVBrickOption(int index) {
		$("//select[@class='vbricklist']").selectByIndex(index);
	}
	//Location section
	public void addLocationNotes(String notes) {
		$("//div[@class='fieldset tab-JobVideoConferences']//textarea[@class='notesa']").sendKeys(notes);
	}
	
	public String getLocationNotes() {
		return $("//div[@class='fieldset tab-JobVideoConferences']//textarea[@class='notesa']").getValue();
	}
	
	public void setTimeLocationSection(int index, String time) {
		$("(//div[@class='fieldset tab-JobVideoConferences']//input[@class='hasTimeEntry'])[" + index + "]").sendKeys(time);
	}
	
	public String getTimeLocationSection(int index) {
		return $("(//div[@class='fieldset tab-JobVideoConferences']//input[@class='hasTimeEntry'])[" + index + "]").getValue();
	}
	
	public void setConfirmationContact(String name) {
		$("//span[text()='Confirmation Contact Name']/../input[@type='text']").sendKeys(name);
	}
	
	public String getConfirmationContact() {
		return $("//span[text()='Confirmation Contact Name']/../input[@type='text']").getValue();
	}
	
	public void checkVideoConferenceSectionIsNotActive() {
		$("//div[@class='fieldset tab-JobVideoConferences']//div[@class='loadmask']").isCurrentlyVisible();
	}
	
	public void checkVideoConferenceNeededCheckbox() {
		$("//div[@class='fieldset tab-JobVideoConferences']//img[@class='imageCheck videoconfneeded']").click();
	}
	
	public void checkTSGProvidingBridgeCheckbox() {
		$("//div[@class='fieldset tab-JobVideoConferences']//img[@class='imageCheck tsgprovidedbridge']").click();
	}
	
	public void checkInitiatesConferenceCheckbox() {
		$("//div[@class='fieldset tab-JobVideoConferences']//img[@class='imageCheck altlocation']").click();
	}
	
	public void setIP(String ip) {
		$("//input[@class='ip']").sendKeys(ip);
	}
	
	public String getIP() {
		return $("//input[@class='ip']").getValue();
	}
	
	public void setITContact(String itContact) {
		$("//input[@class='itcontact']").sendKeys(itContact);
	}
	
	public String getITContact() {
		return $("//input[@class='itcontact']").getValue();
	}
	
	public void setISDN(String isdn) {
		$("//input[@class='isdn']").sendKeys(isdn);
	}
	
	public String getISDN() {
		return $("//input[@class='isdn']").getValue();
	}
	
	public void setPhone(String phone) {
		$("//input[@class='phone']").sendKeys(phone);
	}
	
	public String getPhone() {
		return $("//input[@class='phone']").getValue();
	}
	
	//Interpreter tab
	
	public void assertLanguageAndWitnessApplied() {
		$("//span[text()='English']").isDisplayed();
		$("//span[text()='All']").isDisplayed();
	}
	
	//Equipment module
	//Firm row
	public void setReporterEquipmentFirmRow(String number) {
		$(reporterCompanyRowTD).clear();
		$(reporterCompanyRowTD).sendKeys(number);
	}
	
	public String getReporterEquipmentFirmRow() {
		return $(reporterCompanyRowTD).getValue();
	}
	
	public void setVideographerEquipmentFirmRow(String number) {
		$(videographerCompanyRowTD).clear();
		$(videographerCompanyRowTD).sendKeys(number);
	}
	
	public String getVideographerEquipmentFirmRow() {
		return $(videographerCompanyRowTD).getValue();
	}
	
	public void setAdditionalResourceEquipmentFirmRow(String number) {
		$(additionalResourceCompanyRowTD).clear();
		$(additionalResourceCompanyRowTD).sendKeys(number);
	}
	
	public String getAdditionalResourceEquipmentFirmRow() {
		return $(additionalResourceCompanyRowTD).getValue();
	}
	//Additional row
	public void setQuantityEquipmentAdditionalow(String number) {
		$(quantityAdditionalRowTD).clear();
		$(quantityAdditionalRowTD).sendKeys(number);
	}
	
	public String getQuantityEquipmentAdditionalRow() {
		return $(quantityAdditionalRowTD).getValue();
	}
	
	public void setReporterEquipmentAdditionalow(String number) {
		$(reporterAdditionalRowTD).clear();
		$(reporterAdditionalRowTD).sendKeys(number);
	}
	
	public String getReporterEquipmentAdditionalRow() {
		return $(reporterAdditionalRowTD).getValue();
	}
	
	public void setVideographerEquipmentAdditionalRow(String number) {
		$(videographerAdditionalRowTD).clear();
		$(videographerAdditionalRowTD).sendKeys(number);
	}
	
	public String getVideographerEquipmentAdditionalRow() {
		return $(videographerAdditionalRowTD).getValue();
	}
	
	public void setAdditionalResourceAdditionalRow(String number) {
		$(additionalAdditionalRowTD).clear();
		$(additionalAdditionalRowTD).sendKeys(number);
	}
	
	public String getAdditionalResourceAdditionalRow() {
		return $(additionalAdditionalRowTD).getValue();
	}
	
	//VBrick row
	public void setReporterVBrickRow(String number) {
		$(reporterVBrickRow).clear();
		$(reporterVBrickRow).sendKeys(number);
	}
	
	public String getReporterVBrickRow() {
		return $(reporterVBrickRow).getValue();
	}
	
	public void setVideographerVBrickRow(String number) {
		$(videographerVBrickRow).clear();
		$(videographerVBrickRow).sendKeys(number);
	}
	
	public String getVideographerVBrickRow() {
		return $(videographerVBrickRow).getValue();
	}
	
	public void setAdditionalResourceVBrickRow(String number) {
		$(additionalResourceVBrickRow).clear();
		$(additionalResourceVBrickRow).sendKeys(number);
	}
	
	public String getAdditionalResourceVBrickRow() {
		return $(additionalResourceVBrickRow).getValue();
	}
	
	//Streaming row
	public void setReporterStreamingRow(String number) {
		$(reporterStreamingRow).clear();
		$(reporterStreamingRow).sendKeys(number);
	}
	
	public String getReporterStreamingRow() {
		return $(reporterStreamingRow).getValue();
	}
	
	public void setVideographerStreamingRow(String number) {
		$(videographerStreamingRow).clear();
		$(videographerStreamingRow).sendKeys(number);
	}
	
	public String getVideographerStreamingRow() {
		return $(videographerStreamingRow).getValue();
	}
	
	public void setAdditionalResourceStreamingRow(String number) {
		$(additionalStreamingRow).clear();
		$(additionalStreamingRow).sendKeys(number);
	}
	
	public String getAdditionalResourceStreamingRow() {
		return $(additionalStreamingRow).getValue();
	}
	
	//Total row
	public String getQuantityTotalRow() {
		return $("//span[@data-test='total-equipment-txt']").getTextValue();
	}
	
	public String getReporterTotalRow() {
		return $("//span[@data-test='totalreporter-equipment-txt']").getTextValue();
	}
	
	public String getVideographerTotalRow() {
		return $("//span[@data-test='totalvideographer-equipment-txt']").getTextValue();
	}
	
	public String getAdditionalTotalRow() {
		return $("//span[@data-test='totaladditional-equipment-txt']").getTextValue();
	}
	
	public void maximizeLocationSection() {
		$("//span[text()='Location Info']/../div[@class='collapsed on']").click();
	}
	
	public void setLocationAddress(String company, int companyIndex, String address, 
			String city, String zip, String state, int countryIndex) {

				$("(//span[text()='Company']/../input)[" + companyIndex + "]").sendKeys(company);
				$("(//span[text()='Address']/../input)").sendKeys(address);
				$("(//span[text()='City']/../input)").sendKeys(city);
				$("(//span[text()='Zip']/../input)").sendKeys(zip);
				$("(//span[text()='Country']/../select)").selectByIndex(countryIndex);
				$("(//span[text()='State']/../input)").sendKeys(state);
		
	}
}
