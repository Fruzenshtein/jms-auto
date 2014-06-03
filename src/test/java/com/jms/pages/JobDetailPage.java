package com.jms.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;

public class JobDetailPage extends PageObject {
	
	@FindBy(xpath="//span[text()='Scheduling Firm']/../input[@type='text']")
	private WebElement scheduleFirmField;
	
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
	
	public void setSchedulingFirm(String name) throws InterruptedException {
		scheduleFirmField.sendKeys(name);
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//strong[text()='"+name+"']")).click();
	}
	
	public void setDate(String date) {
		dateField.clear();
		dateField.sendKeys(date);
	}
	
	public void setCaseName(String name) {
		caseNameField.clear();
		caseNameField.sendKeys(name);
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
		$(saveButton).waitUntilPresent().click();
	}
	
	public String getJobDetailHeaderLabel(JobDetailHeaderLabel label) {
		return $("//div[text()='"+label.getLabel()+"']/../div[@class='showinfo-text']")
				.getText();
	}
	
	public void clickExpectedServicesButton() throws InterruptedException {
		$(expectedServicesButton).waitUntilEnabled().click();
		Thread.sleep(2000);
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
		manageButton.click();
	}
	
	public void clickAddFirmButton() {
		addFirmButton.click();
	}
	
	public void clickAddWitnessButton() {
		addWitnessButton.click();
	}
}
