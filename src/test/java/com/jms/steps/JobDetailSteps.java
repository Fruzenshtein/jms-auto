package com.jms.steps;

import static org.junit.Assert.*;

import java.awt.AWTException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.model.Address;
import com.jms.pages.JobDetailPage;
import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.SideMenuLink;
import com.jms.pages.elements.VendorService;
import com.jms.pages.elements.VendorTab;

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
	public void setSchedulingFirmContact(String schedulingFirmContactName) {
		jobDetailPage().setSchedulingFirmContact(schedulingFirmContactName);
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
		return jobDetailPage().getJobDetailHeaderLabel(
				JobDetailHeaderLabel.JOB_N);
	}

	@Step
	public void assertJobDetailHeaderLabel(JobDetailHeaderLabel label, String expectedValue) {
		assertTrue(jobDetailPage().getJobDetailHeaderLabel(label).contains(expectedValue));
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
		assertEquals(vendorName, jobDetailPage()
				.getVendorNameInJobDetailEquipment());
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

	@Step
	public void checkClientMatterNumberIsDisabled() {
		jobDetailPage().checkClientMatterNumberIsDisabled();
	}

	@Step
	public void maximizeClientInfoSection() {
		jobDetailPage().maximizeClientInfoSection();
	}

	@Step
	public void maximizeCaseInfoSection() {
		jobDetailPage().maximizeCaseInfoSection();
	}

	@Step
	public void writeClientMatterN() {
		jobDetailPage().writeClientMatterNInTheList();
	}

	@Step
	public void compareClientMatterNs(int index1, int index2, int index3) {
		/*
		 * assertEquals(jobDetailPage().getClientMatterNFromTheList(index1),
		 * jobDetailPage().getClientMatterNFromTheList(index2));
		 * assertEquals(jobDetailPage().getClientMatterNFromTheList(index1),
		 * jobDetailPage().getClientMatterNFromTheList(index3));
		 */
		assert (jobDetailPage().getClientMatterNFromTheList(index1)
				.equals(jobDetailPage().getClientMatterNFromTheList(index2)
						.equals(jobDetailPage().getClientMatterNFromTheList(
								index3))));
	}

	@Step
	public void clearClientMatterNList() {
		jobDetailPage().clearClientMatterNList();
	}

	@Step
	public void assertClientMatterNIsDisabled() {
		jobDetailPage().assertClientMatterNIsDisabled();
	}

	@Step
	public void checkSchedulingFirmConfirmCheckbox() {
		jobDetailPage().checkSchedulingFirmConfirmCheckbox();
	}

	@Step
	public void checkFirmContactCheckbox(int index) {
		jobDetailPage().checkFirmContactCheckbox(index);
	}

	@Step
	public void clickAddRequestedVendorLink(int index) {
		jobDetailPage().clickAddRequestedVendorLink(index);
	}
	
	@Step
	public void addRequestedVendor(String requestedVendorName, int index) {
		jobDetailPage().addRequestedVendor(requestedVendorName, index);
	}

	@Step
	public void addAndAssertSchedulingFirmIsAdded(String schedulingFirm) {
		jobDetailPage().clearSchedulingFirmField();
		jobDetailPage().setSchedulingFirm(schedulingFirm);
		jobDetailPage().assertSchedulingFirmIsAdded(schedulingFirm);
	}

	public void clearSchedulingFirmField() {
		jobDetailPage().clearSchedulingFirmField();
	}
	
	public void removeAddedFirm(int index) {
		jobDetailPage().removeAddedFirm(index);
	}

	@Step
	public void addAdditionalContact() {
		jobDetailPage().addAdditionalContact();
	}


	@Step
	public void clickQuickCRMAddLink(int index) {
		jobDetailPage().clickQuickCRMAddLink(index);
	}

	@Step
	public void addFirstNameQuickCRM(String firstName) {
		jobDetailPage().addFirstNameQuickCRM(firstName);
	}

	@Step
	public void addLastNameQuickCRM(String lastName) {
		jobDetailPage().addLastNameQuickCRM(lastName);
	}

	@Step
	public void addEmailAddressQuickCRM(String emailAddress) {
		jobDetailPage().addEmailAddressQuickCRM(emailAddress);
	}

	@Step
	public void clickSubmitButtonQuickCRM() {
		jobDetailPage().clickSubmitButtonQuickCRM();
	}

	@Step
	public void clickActionMenuLink(int index) {
		jobDetailPage().clickActionMenuLink(index);
	}
	
	@Step
	public void selectActionMenuOption(String option, int index) {
		jobDetailPage().selectActionMenuOption(option, index);
	}
	
	@Step
	public void selectVendorTab(String tab, String vendor) {
		jobDetailPage().selectVendorTab(tab, vendor);

	}
	
	@Step
	public void setVendorNotes(String notes) {
		jobDetailPage().setVendorNotes(notes);
	}
	
	@Step
	public void setStreamingVendorNotes(String notes) {
		jobDetailPage().setStreamingVendorNotes(notes);
	}
	
	@Step
	public void clearVendorNotes() {
		jobDetailPage().clearVendorNotes();
	}

	@Step
	public void assertVendorNotes(String expectedVendorNotes) {
		assertEquals(expectedVendorNotes, jobDetailPage().getVendorNotes());
	}
	
	@Step
	public void assertStreamingVendorNotes(String expectedStreamingVendorNotes) {
		assertEquals(expectedStreamingVendorNotes, jobDetailPage().getStreamingVendorNotes());
	}
	
	@Step
	public void clearExpectedStartEndTime() {
		jobDetailPage().clearExpectedStartEndTime();
	}
	
	@Step
	public void assertExpectedStartEndTimeIsNotCleared(String expectedStartTime, String expectedEndTime) {
		assertEquals(expectedStartTime, jobDetailPage().getExpectedStartTime());
		assertEquals(expectedEndTime, jobDetailPage().getExpectedFinishTime());
	}
	
	@Step
	public void markTBDVendorStartTime(int indexStart) {
		jobDetailPage().markTBDVendorStartTime(indexStart);
	}
	
	@Step
	public void markTBDVendorEndTime(int indexEnd) {
		jobDetailPage().markTBDVendorEndTime(indexEnd);
	}
	
	@Step
	public void unmarkTBDVendorEndTime(int indexEnd) {
		jobDetailPage().unmarkTBDVendorEndTime(indexEnd);
	}
	
	@Step
	public void checkVendorTBDStartTime(int index, boolean is) {
		jobDetailPage().checkVendorTBDStartTime(index, is);
	}
	
	@Step
	public void checkVendorTBDEndTime(int index, boolean is) {
		jobDetailPage().checkVendorTBDEndTime(index, is);
	}
	
	@Step
	public void setStreamingSessionID(String id) {
		jobDetailPage().setStreamingSessionID(id);
	}
	
	@Step
	public void assertStreamingSessionID(String expectedID) {
		assertEquals(expectedID, jobDetailPage().getStreamingSessionID());
	}
	
	@Step
	public void attachRatesSheet(int index) throws AWTException {
		jobDetailPage().attachRatesSheet(index);
	}
	
	@Step
	public void maximizeRatesSection() {
		jobDetailPage().maximizeRatesSection();
	}
	
	@Step
	public void minimizeRatesSection() {
		jobDetailPage().minimizeRatesSection();
	}
	
	@Step
	public void checkAdminApprovedChckbxRates(int index) {
		jobDetailPage().checkAdminApprovedChckbxRates(index);
	}
	
	@Step
	public void getAdminApprovedChckbxRates(int index, boolean is) {
		jobDetailPage().getAdminApprovedChckbxRates(index, is);
	}
	
	@Step
	public void addRatesNotes(int index, String notes) {
		jobDetailPage().addRatesNotes(index, notes);
	}
	
	@Step
	public void verifyAddedRatesNotes(int index, String expectedNotes) {
		assertEquals(expectedNotes, jobDetailPage().getRatesNotes(index));
	}
	
	@Step
	public void clearRatesNotes(int index) {
		jobDetailPage().clearRatesNotes(index);
	}
	
	@Step
	public void maximizeCommissionSection() {
		jobDetailPage().maximizeCommissionSection();
	}
	
	@Step
	public void minimizeCommissionSection() {
		jobDetailPage().minimizeCommissionSection();
	}
	
	@Step
	public void clickCommissionApplyLink() {
		jobDetailPage().clickCommissionApplyLink();
	}
	
	@Step
	public void clickApplyButtonCommission() {
		jobDetailPage().clickApplyButtonCommission();
	}
	
	@Step
	public void assertAppliedCommission(String expectedCommission) {
		assertEquals(expectedCommission, jobDetailPage().getAppliedCommission());
	}
	
	@Step
	public void deleteAppliedCommission(int index) {
		jobDetailPage().deleteAppliedCommission(index);
	}
	
	@Step
	public void addCommissionNotes(String commissionNotes) {
		jobDetailPage().addCommissionNotes(commissionNotes);
	}
	
	@Step
	public void assertCommissionNotes(String expectedCommissionNotes) {
		assertEquals(expectedCommissionNotes, jobDetailPage().getCommissionNotes());
	}
	
	@Step
	public void retrieveReporterEquipmentSection(String expectedReporter, int index) {
		assertEquals(expectedReporter, jobDetailPage().retrieveReporterEquipmentSection(index));
	}
	
	@Step
	public void retrieveVideographerEquipmentSection(String expectedVideographer, int index) {
		assertEquals(expectedVideographer, jobDetailPage().retrieveVideographerEquipmentSection(index));
	}
	
	@Step
	public void minimizeMaximizeEquipmentSection() {
		jobDetailPage().minimizeMaximizeEquipmentSection();
	}
	
	@Step
	public void addNotesCommissionSection(String commissionNotes) {
		jobDetailPage().addNotesCommissionSection(commissionNotes);
	}
	
	@Step
	public void assertNotesCommissionSection(String expectedCommissionNotes) {
		assertEquals(expectedCommissionNotes, jobDetailPage().getNotesCommissionSection());
	}
	
	@Step
	public void changeCommissionPercentage(int index, String percentage) {
		jobDetailPage().changeCommissionPercentage(index, percentage);
	}
	
	@Step
	public void assertCommissionPercentage(int index, String expectedCommissionPercentage) {
		assertEquals(expectedCommissionPercentage, jobDetailPage().getCommissionPercentage(index));
	}
	
	@Step
	public void maximizeFilesSection() {
		jobDetailPage().maximizeFilesSection();
	}
	
	@Step
	public void minimizeFilesSection() {
		jobDetailPage().minimizeFilesSection();
	}
	
	@Step
	public void addAnotherFileFilesSection(int index) throws AWTException {
		jobDetailPage().addAnotherFileFilesSection(index);
	}
	
	@Step
	public void deleteAnotherFileFilesSection(int index) {
		jobDetailPage().deleteAnotherFileFilesSection(index);
	}
	
	@Step
	public void addFilesNotes(String filesNotes) {
		jobDetailPage().addFilesNotes(filesNotes);
	}
	
	@Step
	public void assertFilesNotes(String expectedFilesNotes) {
		assertEquals(expectedFilesNotes, jobDetailPage().getFilesNOtes());
	}
	//Location section
	@Step
	public void checkInternetHardlineConfirmed() {
		jobDetailPage().checkInternetHardlineConfirmed();
	}
	
	@Step
	public void checkVideoStreamHardlineConfirmed() {
		jobDetailPage().checkVideoStreamHardlineConfirmed();
	}
	
	@Step
	public void selectVBrickOption(int index) {
		jobDetailPage().selectVBrickOption(index);
	}
	
	@Step
	public void addLocationNotes(String notes) {
		jobDetailPage().addLocationNotes(notes);
	}
	
	@Step
	public void assertLocationNotes(String expectedNotes) {
		assertEquals(expectedNotes, jobDetailPage().getLocationNotes());
	}
	
	@Step
	public void setTimeLocationSection(int index, String time) {
		jobDetailPage().setTimeLocationSection(index, time);
	}
	
	@Step
	public void assertTimeLocationSection(int index, String expectedTime) {
		assertEquals(expectedTime, jobDetailPage().getTimeLocationSection(index));
	}
	
	@Step
	public void setConfirmationContact(String name) {
		jobDetailPage().setConfirmationContact(name);
	}
	
	@Step
	public void assertConfirmationContact(String expectedName) {
		assertEquals(expectedName, jobDetailPage().getConfirmationContact());
	}
	
	@Step
	public void checkVideoConferenceSectionIsNotActive() {
		jobDetailPage().checkVideoConferenceSectionIsNotActive();
	}
	
	@Step
	public void checkVideoConferenceNeededCheckbox() {
		jobDetailPage().checkVideoConferenceNeededCheckbox();
	}
	
	
	@Step
	public void checkTSGProvidingBridgeCheckbox() {
		jobDetailPage().checkTSGProvidingBridgeCheckbox();
	}
	
	@Step
	public void checkInitiatesConferenceCheckbox() {
		jobDetailPage().checkInitiatesConferenceCheckbox();
	}
	
	@Step
	public void setIP(String ip) {
		jobDetailPage().setIP(ip);
	}
	
	@Step
	public void assertIP(String ip) {
		assertEquals(ip, jobDetailPage().getIP());
	}
	
	@Step
	public void setITContact(String ITContact) {
		jobDetailPage().setITContact(ITContact);
	}
	
	@Step
	public void assertITContact(String ITContact) {
		assertEquals(ITContact, jobDetailPage().getITContact());
	}
	
	@Step
	public void setISDN(String isdn) {
		jobDetailPage().setISDN(isdn);
	}
	
	@Step
	public void assertISDN(String isdn) {
		assertEquals(isdn, jobDetailPage().getISDN());
	}
	
	@Step
	public void setPhone(String phone) {
		jobDetailPage().setPhone(phone);
	}
	
	@Step
	public void assertPhone(String phone) {
		assertEquals(phone, jobDetailPage().getPhone());
	}
	
	//Interpreter tab
	
	@Step
	public void assertLanguageAndWitnessApplied() {
		jobDetailPage().assertLanguageAndWitnessApplied();
	}
	
	//Equipment tab
	//Firm row
	@Step
	public void setReporterEquipmentFirmRow(String number) {
		jobDetailPage().setReporterEquipmentFirmRow(number);
	}
	
	@Step
	public void assertReporterEquipmentFirmRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getReporterEquipmentFirmRow());
	}
	
	@Step
	public void setVideographerEquipmentFirmRow(String number) {
		jobDetailPage().setVideographerEquipmentFirmRow(number);
	}
	
	@Step
	public void assertVideographerEquipmentFirmRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getVideographerEquipmentFirmRow());
	}
	
	@Step
	public void setAdditionalResourceEquipmentFirmRow(String number) {
		jobDetailPage().setAdditionalResourceEquipmentFirmRow(number);;
	}
	
	@Step
	public void assertAdditionalResourceEquipmentFirmRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getAdditionalResourceEquipmentFirmRow());
	}
	
	//Additional row
	@Step
	public void setQuantityEquipmentAdditionalow(String number) {
		jobDetailPage().setQuantityEquipmentAdditionalow(number);
	}
	
	@Step
	public void assertQuantityEquipmentFirmRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getQuantityEquipmentAdditionalRow());
	}
	
	@Step
	public void setReporterEquipmentAdditionalow(String number) {
		jobDetailPage().setReporterEquipmentAdditionalow(number);;
	}
	
	@Step
	public void assertReporterEquipmentAdditionalow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getReporterEquipmentAdditionalRow());
	}
	
	@Step
	public JobDetailSteps setVideographerEquipmentAdditionalRow(String number) {
		jobDetailPage().setVideographerEquipmentAdditionalRow(number);
		return this;
	}
	
	@Step
	public void assertVideographerEquipmentAdditionalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getVideographerEquipmentAdditionalRow());
	}
	
	@Step
	public void setAdditionalResourceAdditionalRow(String number) {
		jobDetailPage().setAdditionalResourceAdditionalRow(number);;
	}
	
	@Step
	public void assertAdditionalResourceAdditionalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getAdditionalResourceAdditionalRow());
	}
	
	//VBrick row
	@Step
	public void setReporterVBrickRow(String number) {
		jobDetailPage().setReporterVBrickRow(number);
	}
	
	@Step
	public void assertReporterVBrickRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getReporterVBrickRow());
	}
	
	@Step
	public void setVideographerVBrickRow(String number) {
		jobDetailPage().setVideographerVBrickRow(number);
	}
	
	@Step
	public void assertVideographerVBrickRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getVideographerVBrickRow());
	}
	
	@Step
	public void setAdditionalResourceVBrickRow(String number) {
		jobDetailPage().setAdditionalResourceVBrickRow(number);
	}
	
	@Step
	public void assertAdditionalResourceVBrickRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getAdditionalResourceVBrickRow());
	}
	
	//Streaming row
	@Step
	public void setReporterStreamingRow(String number) {
		jobDetailPage().setReporterStreamingRow(number);
	}
	
	@Step
	public void assertReporterStreamingRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getReporterStreamingRow());
	}
	
	@Step
	public void setVideographerStreamingRow(String number) {
		jobDetailPage().setVideographerStreamingRow(number);
	}
	
	@Step
	public void assertVideographerStreamingRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getVideographerStreamingRow());
	}
	
	@Step
	public void setAdditionalResourceStreamingRow(String number) {
		jobDetailPage().setAdditionalResourceStreamingRow(number);
	}
	
	@Step
	public void assertAdditionalResourceStreamingRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getAdditionalResourceStreamingRow());
	}
	
	//Total row
	
	@Step
	public void assertQuantityTotalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getQuantityTotalRow());
	}
	
	@Step
	public void assertReporterTotalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getReporterTotalRow());
	}
	
	@Step
	public void assertVideographerTotalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getVideographerTotalRow());
	}
	
	@Step
	public void assertAdditionalTotalRow(String expectedNumber) {
		assertEquals(expectedNumber, jobDetailPage().getAdditionalTotalRow());
	}
	
	@Step
	public void maximizeLocationSection() {
		jobDetailPage().maximizeLocationSection();
	}
	
	@Step
	public void setCompanyLocation(String company, int companyIndex) {
		jobDetailPage().setCompanyLocation(company, companyIndex);
	}
	
	@Step
	public void setAddress(String address) {
		jobDetailPage().setAddress(address);
	}
	
	@Step
	public void setCity(String city) {
		jobDetailPage().setCity(city);
	}
	
	@Step
	public void setZip(String zip) {
		jobDetailPage().setZip(zip);
	}
	
	@Step
	public void setState(String state) {
		jobDetailPage().setState(state);
	}
	
	@Step
	public void setCountry(int countryIndex) {
		jobDetailPage().setCountry(countryIndex);
	}
}
