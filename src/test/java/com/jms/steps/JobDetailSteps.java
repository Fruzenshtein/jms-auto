package com.jms.steps;

import static org.junit.Assert.*;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.pages.JobDetailPage;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;

public class JobDetailSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	
	private JobDetailPage jobDetailPage() {
		return getPages().currentPageAt(JobDetailPage.class);
	}
	
	@Step
	public void setSchedulingFirm(String name) throws InterruptedException {
		jobDetailPage().setSchedulingFirm(name);
	}
	
	@Step
	public void setDate(String date) {
		jobDetailPage().setDate(date);
	}
	
	@Step
	public void setCaseName(String name) {
		jobDetailPage().setCaseName(name);
	}
	
	@Step
	public void setLocation(String location) throws InterruptedException {
		jobDetailPage().setLocationAutoComplete(location);
	}
	
	public void setContributingFirm(String name) throws InterruptedException {
		jobDetailPage().setContributingFirm(name);
	}
	
	@Step
	public void setWitnessName(int index, String name) {
		jobDetailPage().setWitnessName(1, name);
	}
	
	@Step
	public void isServiceIconInWitnessInfo(VendorService vendor, boolean is) {
		assertTrue(jobDetailPage().isServiceIconInWitnessInfo(vendor, is));
	}
	
	@Step
	public void isServiceIconInVendorSection(VendorService vendor, boolean is) {
		assertTrue(jobDetailPage().isServiceIconInVendorSection(vendor, is));
	}
	
	@Step
	public void clickSave() {
		jobDetailPage().clickSave();
	}
	
	@Step
	public String getJobId() {
		return jobDetailPage().getJobDetailHeaderLabel(JobDetailHeaderLabel.JOB_N);
	}
	
	@Step
	public void assertJobDetailHeaderLabel(JobDetailHeaderLabel label, String expectedValue) {
		assertTrue(jobDetailPage()
				.getJobDetailHeaderLabel(label)
				.contains(expectedValue));
	}
	
	@Step
	public void clickExpectedServicesButton() throws InterruptedException {
		Thread.sleep(1000);
		jobDetailPage().clickExpectedServicesButton();
	}
	
	@Step
	public String getReporterName() {
		return jobDetailPage().getReporterName();
	}
 
	@Step
	public void checkVendorNameInJobDetailsEquipment(String vendorName) {
		assertEquals(vendorName, jobDetailPage().getVendorNameInJobDetailEquipment());
	}
	
	@Step
	public void clickManageButton() {
		jobDetailPage().clickManageButton();
	}
	
	@Step
	public void clickAddFirmButton() {
		jobDetailPage().clickAddFirmButton();
	}

	@Step
	public void clickAddWitnessButton() {
		jobDetailPage().clickAddWitnessButton();
	}
}
