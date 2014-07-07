package com.jms.steps;

import static org.junit.Assert.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.model.Address;
import com.jms.pages.JobDetailPage;
import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.SideMenuBar;
import com.jms.pages.elements.VendorService;

public class JobDetailSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	
	private JobDetailPage jobDetailPage() {
		return getPages().currentPageAt(JobDetailPage.class);
	}
	
	@Step
	public void setSchedulingFirm(String name) {
		jobDetailPage().setSchedulingFirm(name);
	}
	
	@Step
	public void setClientMatterN(String number) {
		jobDetailPage().setClientMatterN(number);
	}
	
	@Step
	public void assertClientMatterN(String number) {
		assertEquals(number, jobDetailPage().getClientMatterN());
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
		jobDetailPage().setWitnessName(index, name);
	}
	
	@Step
	public void setWitnessStartingPgN(int index, String value) {
		jobDetailPage().setWitnessStartingPgN(index, value);
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
	public void clickExpectedServicesButton() {
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
	public void clickVendorActionLink(int index) {
		jobDetailPage().clickVendorActionLink(index);
	}
	
	@Step
	public String getVendorNameInManageModule(int index) {
		return jobDetailPage().getVendorNameInManageModule(index);
	}
	
	@Step
	public void clickAddFirmButton() {
		jobDetailPage().clickAddFirmButton();
	}

	@Step
	public void clickAddWitnessButton() {
		jobDetailPage().clickAddWitnessButton();
	}
	
	@Step
	public void selectCaseType(String type) {
		jobDetailPage().selectCaseType(type);
	}
	
	@Step
	public void clickCaseInfoCheckBox(String checkBoxLabel) {
		jobDetailPage().clickCaseInfoCheckBox(checkBoxLabel);
	}
	
	@Step
	public void setActionNumber(String number) {
		jobDetailPage().setActionNumber(number);
	}
	
	@Step
	public void clickAddConferenceLink() {
		jobDetailPage().clickAddConferenceLink();
	}
	
	@Step
	public void setCaseInfoPhoneNumber(String number) {
		jobDetailPage().setCaseInfoPhoneNumber(number);
	}
	
	@Step
	public void selectCaseInfoPhoneNumber(int index) {
		jobDetailPage().selectCaseInfoPhoneNumber(index);
	}
	
	@Step
	public void setCaseInfoPassCode(String code) {
		jobDetailPage().setCaseInfoPassCode(code);
	}
	
	@Step
	public void setCaseInstructions(String instructions) {
		jobDetailPage().setCaseInstructions(instructions);
	}
	
	@Step
	public void checkLocationAddress(int index, Address address) {
		assertEquals(address, jobDetailPage().getLocationAddress(index));
	}
	
	@Step
	public void setLocationAddressNotes(int index, String notes) {
		jobDetailPage().setLocationAddressNotes(index, notes);
	}
	
	@Step
	public void setLocationAddressConfRm(int index, String confRm) {
		jobDetailPage().setLocationAddressConfRm(index, confRm);
	}

	@Step
	public void setLocationAddressContact(int index, String contact) {
		jobDetailPage().setLocationAddressContact(index, contact);
	}
	
	@Step
	public void setLocationAddressPhone(int index, String phone) {
		jobDetailPage().setLocationAddressPhone(index, phone);
	}
	
	@Step
	public void clickClearAddressFields(int index) {
		jobDetailPage().clickClearAddressFields(index);
	}
	
	@Step
	public void clickOkButton() {
		jobDetailPage().clickOkButton();
	}
	
	@Step
	public void setExpectedStartTime(String time) {
		jobDetailPage().setExpectedStartTime(time);
	}
	
	@Step
	public void assertExpectedStartTime(String time) {
		assertEquals(time, jobDetailPage().getExpectedStartTime());
	}
	
	@Step
	public void setExpectedFinishTime(String time) {
		jobDetailPage().setExpectedFinishTime(time);
	}
	
	@Step
	public void assertExpectedFinishTime(String time) {
		assertEquals(time, jobDetailPage().getExpectedFinishTime());
	}
	
	@Step
	public void clickVendorsActionMenuLink(int index, ActionLink link) {
		jobDetailPage().clickVendorsActionMenuLink(index, link.getLink());
	}
	
	@Step
	public void isBeacon(Beacon beacon, BeaconState state) {
		jobDetailPage().isBeacon(beacon.getBeacon(), state.getState());
	}
	
	/*@Step
	public void invokeSideMenuBar() {
		jobDetailPage().clickSideMenuBar();
	}
	
	@Step
	public void selectSideMenuLink(SideMenuBar sideMenuLink) {
		jobDetailPage().clickSideMenuLink(sideMenuLink.getLink());
	}*/
	
}
