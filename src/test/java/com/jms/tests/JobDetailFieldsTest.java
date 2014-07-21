package com.jms.tests;

import java.awt.AWTException;

import org.junit.Test;

import com.jms.model.Address;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.StreamServices;
import com.jms.pages.elements.VendorService;
import com.jms.pages.elements.VendorTab;
import com.jms.requirements.JobManagementStory.JobDetailFieldsStory;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;
import com.jms.util.RandonUUIDGenerator;
import com.jms.steps.ExpectedServicesSteps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(JobDetailFieldsStory.class)
public class JobDetailFieldsTest extends BasicTest {

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public GlobalSteps globalSteps;

	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps; 
	
	 @Test
	 @Screenshots(onlyOnFailures = true)
	 public void jobDetailPageCaseInfoSection() throws InterruptedException {
	
	 String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
	
	 loginSteps.login(userStorage.getUser(0));
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	
	 jobDetailSteps.setDate(futureDate);
	 jobDetailSteps.setCaseName("Sony presentation"); // TODO: Mark Case name
	 // as TBD
	  jobDetailSteps.selectCaseType("Meeting");
	 jobDetailSteps.assertJobDetailHeaderLabel(
	 JobDetailHeaderLabel.JOB_TYPE, "Meeting");
	
	 jobDetailSteps.clickCaseInfoCheckBox("Agency Job");
	 jobDetailSteps.clickCaseInfoCheckBox("Non-Contract State");
	
	 jobDetailSteps.setActionNumber("3");
	
	 jobDetailSteps.clickAddConferenceLink();
	 jobDetailSteps.setCaseInfoPhoneNumber("2223399");
	 jobDetailSteps.setCaseInfoPassCode("777");
	 jobDetailSteps.setCaseInstructions("Some instructions");
	
	 jobDetailSteps.clickCaseInfoCheckBox("TSG Provided");
	 jobDetailSteps.selectCaseInfoPhoneNumber(1);
	
	 jobDetailSteps.setSchedulingFirm("Sony Electronics Inc.");
	
	 }
	
	 @Test
	 @Screenshots(onlyOnFailures = true)
	 public void jobDetailPageWitnessInfoSection() throws InterruptedException
	 {
	
	 loginSteps.login(userStorage.getUser(0));
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	
	 jobDetailSteps.setWitnessName(1, "Robert"); // TODO: TBD
	 jobDetailSteps.setWitnessStartingPgN(1, "7");
	 jobDetailSteps.clickCaseInfoCheckBox("30(b)(6)");
	
	 globalSteps.checkTextPresent("Robert");
	
	 jobDetailSteps.clickAddWitnessButton();
	
	 jobDetailSteps.setWitnessName(2, "Peter");
	 jobDetailSteps.setWitnessStartingPgN(2, "2");
	
	 globalSteps.checkTextPresent("Robert");
	 globalSteps.checkTextPresent("Peter");
	 }
	
	 // TODO: Delete operation }
	
	 @Test
	 @Screenshots(onlyOnFailures = true)
	 public void jobDetailPageLocationInfoSection() throws
	 InterruptedException {
	
	 Address address1 = new Address();
	 address1.setCompany("Century City Bar Association")
	 .setAddress("1616 Ocean Park Boulevard")
	 .setCity("Santa Monica").setZip("90405")
	 .setCountry("United States of America");
	
	 Address address2 = new Address();
	 address2.setCountry("United States of America");
	
	 loginSteps.login(userStorage.getUser(0));
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	
	 jobDetailSteps.setLocation("Century City Bar Association"); // TODO: TBD
	 jobDetailSteps.checkLocationAddress(1, address1);
	
	 jobDetailSteps.clickCaseInfoCheckBox("Names Required for Security");
	 jobDetailSteps.setLocationAddressNotes(1, "Some notes");
	 jobDetailSteps.setLocationAddressConfRm(1, "55");
	 jobDetailSteps.setLocationAddressContact(1, "Jane Lee"); // TODO: TBD
	 jobDetailSteps.setLocationAddressPhone(1, "553 77 88");
	
	 jobDetailSteps.clickClearAddressFields(1);
	 jobDetailSteps.clickOkButton();
	
	 jobDetailSteps.checkLocationAddress(1, address2); // BUG: 'Clear
	 // address' link
	 // doesn't work }
	 }
	

	
	 @Test
	 @Screenshots(onlyOnFailures = true)
	 public void jobDetailPageClientMatter() throws InterruptedException {
	
	 String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
	
	 loginSteps.login(userStorage.getUser(0));
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	
	 String jobId1 = jobDetailSteps.getJobId();
	
	 jobDetailSteps.setSchedulingFirm("Banner");
	 jobDetailSteps.setDate(futureDate);
	 jobDetailSteps.setCaseName("Daily meeting");
	 jobDetailSteps.setClientMatterN("33");
	
	 jobDetailSteps.clickSave();
	
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	
	 String jobId2 = jobDetailSteps.getJobId();
	
	 jobDetailSteps.setSchedulingFirm("Banner");
	 jobDetailSteps.setDate(futureDate);
	 jobDetailSteps.setCaseName("Daily meeting");
	
	 jobDetailSteps.clickSave();
	
	 globalSteps.searchJobById(jobId2);
	
	 jobDetailSteps.assertClientMatterN("33");
	 }
	
	
	 @Test
	 @Screenshots(onlyOnFailures = true)
	 public void jobDetailPageClientMatterNumber() throws InterruptedException
	 {
	
	 String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
	
	 loginSteps.login(userStorage.getUser(0));
	 globalSteps.searchJobById("300");
	 jobDetailSteps.maximizeClientInfoSection();
	 jobDetailSteps.setClientMatterN(RandonUUIDGenerator.getRandomUUID());
	 jobDetailSteps.clickSave();
	 globalSteps.pause(2);
	 jobDetailSteps.writeClientMatterN();
	 globalSteps.pause(1);
	
	 globalSteps.searchJobById("301");
	 jobDetailSteps.maximizeClientInfoSection();
	 jobDetailSteps.maximizeCaseInfoSection();
	 globalSteps.pause(2);
	 jobDetailSteps.clickSave();
	 globalSteps.pause(3);
	 jobDetailSteps.writeClientMatterN();
	 globalSteps.pause(1);
	
	 // create a new job
	 globalSteps.clickCreateJobIcon();
	 globalSteps.openWidgetIn(1);
	 jobDetailSteps.setSchedulingFirm("Thirkill");
	 jobDetailSteps.setDate(futureDate);
	 jobDetailSteps.assertClientMatterNIsDisabled();
	 jobDetailSteps.setCaseName("testClientMatter#");
	 jobDetailSteps.clickSave();
	 globalSteps.pause(5);
	 jobDetailSteps.writeClientMatterN();
	
	 jobDetailSteps.compareClientMatterNs(0, 1, 2);
	 jobDetailSteps.clearClientMatterNList();
	 jobDetailSteps
	 .setClientMatterN(RandonUUIDGenerator.getRandomUUID());
	 jobDetailSteps.clickSave();
	 globalSteps.pause(3);
	 jobDetailSteps.writeClientMatterN();
	
	 globalSteps.searchJobById("301");
	 jobDetailSteps.maximizeClientInfoSection();
	 jobDetailSteps.writeClientMatterN();
	
	 globalSteps.searchJobById("300");
	 jobDetailSteps.maximizeClientInfoSection();
	 jobDetailSteps.writeClientMatterN();
	 jobDetailSteps.compareClientMatterNs(0, 1, 2);
	 jobDetailSteps.clearClientMatterNList();
	 }

	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageClientInfoSection() throws InterruptedException {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("123");
		jobDetailSteps.maximizeClientInfoSection();
		jobDetailSteps.checkSchedulingFirmConfirmCheckbox();	
		jobDetailSteps.addAndAssertSchedulingFirmIsAdded("Altesse Co., Ltd.");
		jobDetailSteps.setSchedulingFirmContact("Ronny Bobb");
		jobDetailSteps.addRequestedVendor("Celestino Calpo", 1);
		jobDetailSteps.clickSave();

		globalSteps.pause(5); 
		jobDetailSteps.addAndAssertSchedulingFirmIsAdded("Ann Van Devanter Townsend");
		jobDetailSteps.setSchedulingFirmContact("Liza");
		jobDetailSteps.addAdditionalContact();
		
		jobDetailSteps.clickQuickCRMAddLink(1);
		jobDetailSteps.addFirstNameQuickCRM("Irina"
				+ RandonUUIDGenerator.getRandomUUID());
		jobDetailSteps.addLastNameQuickCRM("M"
				+ RandonUUIDGenerator.getRandomUUID());
		jobDetailSteps.addEmailAddressQuickCRM("test@door"
				+ RandonUUIDGenerator.getRandomUUID() + ".com");
		jobDetailSteps.clickSubmitButtonQuickCRM();
		jobDetailSteps.clickActionMenuLink(2);
		globalSteps.pause(2);
		jobDetailSteps.selectActionMenuOption("Make Primary", 2);
		jobDetailSteps.clickActionMenuLink(2);
		jobDetailSteps.selectActionMenuOption("Remove Contact", 2); 
		jobDetailSteps.checkFirmContactCheckbox(2); 
		jobDetailSteps.clickAddRequestedVendorLink(1);
		jobDetailSteps.addRequestedVendor("Daniel Lever", 1);
		jobDetailSteps.clickActionMenuLink(2);
		jobDetailSteps.selectActionMenuOption("Remove Requested Vendor", 1); 
		jobDetailSteps.clickAddFirmButton();
		jobDetailSteps.setContributingFirm("American Capital, Ltd.");
		jobDetailSteps.clickQuickCRMAddLink(2);
		jobDetailSteps.addFirstNameQuickCRM("Vi"
				+ RandonUUIDGenerator.getRandomUUID());
		jobDetailSteps.addLastNameQuickCRM("M"
				+ RandonUUIDGenerator.getRandomUUID());
		jobDetailSteps.addEmailAddressQuickCRM("test@eng"
				+ RandonUUIDGenerator.getRandomUUID() + ".com");
		jobDetailSteps.clickSubmitButtonQuickCRM();
		jobDetailSteps.clickAddRequestedVendorLink(2);
		jobDetailSteps.addRequestedVendor("Robert Algeri", 2);
		jobDetailSteps.removeAddedFirm(2);
		jobDetailSteps.clickSave(); 
		globalSteps.pause(10);
	} 
/*
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageVendorModule() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2201");
			jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(25);
		jobDetailSteps.clickSave();
		globalSteps.pause(15);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, true);
	    jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);
		//Reporter tab
		jobDetailSteps.selectVendorTab(VendorTab.REPORTER.getTab(), VendorTab.REPORTER.getVendor());
		jobDetailSteps.setExpectedStartTime("11:00 AM");
		jobDetailSteps.assertExpectedStartTime("11:00 AM");
		jobDetailSteps.setExpectedFinishTime("06:00 PM");
		jobDetailSteps.assertExpectedFinishTime("06:00 PM");
		jobDetailSteps.setVendorNotes("REPORTER notes");
		jobDetailSteps.assertVendorNotes("REPORTER notes");
		jobDetailSteps.clearExpectedStartEndTime();
		jobDetailSteps.assertExpectedStartEndTimeIsNotCleared("", "");
		jobDetailSteps.markTBDVendorEndTime(2);
		jobDetailSteps.markTBDVendorStartTime(1);
		globalSteps.pause(2);
		//jobDetailSteps.checkVendorTBDEndTime(2, true);
		jobDetailSteps.checkVendorTBDStartTime(1, true);
		jobDetailSteps.clearVendorNotes();
		jobDetailSteps.assertVendorNotes("");  
		//Videographer tab
		jobDetailSteps.selectVendorTab(VendorTab.VIDEOGRAPHER.getTab(), VendorTab.VIDEOGRAPHER.getVendor());
		jobDetailSteps.setExpectedStartTime("11:00 AM");
		jobDetailSteps.assertExpectedStartTime("11:00 AM");
		jobDetailSteps.setExpectedFinishTime("06:00 PM");
		jobDetailSteps.assertExpectedFinishTime("06:00 PM");
		jobDetailSteps.markTBDVendorEndTime(2);
		jobDetailSteps.markTBDVendorStartTime(1);
		jobDetailSteps.setVendorNotes("VIDEOGRAPHER notes");
		jobDetailSteps.assertVendorNotes("VIDEOGRAPHER notes"); 
		jobDetailSteps.selectVendorTab(VendorTab.STREAMING_SERVICES.getTab(), VendorTab.STREAMING_SERVICES.getVendor());
		jobDetailSteps.setExpectedStartTime("09:00 AM");
		jobDetailSteps.assertExpectedStartTime("09:00 AM");
		jobDetailSteps.setExpectedFinishTime("05:00 PM");
		jobDetailSteps.assertExpectedFinishTime("05:00 PM");
		jobDetailSteps.markTBDVendorEndTime(2);
		jobDetailSteps.markTBDVendorStartTime(1);
		jobDetailSteps.setStreamingVendorNotes("STREAMING_SERVICES notes");
		jobDetailSteps.assertStreamingVendorNotes("STREAMING_SERVICES notes");
		jobDetailSteps.setStreamingSessionID("33");
		jobDetailSteps.assertStreamingSessionID("33");
		jobDetailSteps.markTBDVendorEndTime(2);
		jobDetailSteps.markTBDVendorStartTime(1); 
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.HARDLINE_CONFIRMED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.HARDLINE_CONFIRMED, 2);
		expectedServicesSteps.clickUpdate();
		jobDetailSteps.clickSave();
		globalSteps.pause(10); 
		//Deactivate services
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickUpdate(); 
		
	} 
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageRatesCommissionFiles() throws AWTException {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1290");
	    //Rates
		jobDetailSteps.maximizeRatesSection();
		//jobDetailSteps.attachRatesSheet(1);
		//Scheduling firm
		jobDetailSteps.checkAdminApprovedChckbxRates(1);
		jobDetailSteps.getAdminApprovedChckbxRates(1, true);
		jobDetailSteps.clearRatesNotes(1);
		jobDetailSteps.addRatesNotes(1, "Rates notes 1");
		jobDetailSteps.verifyAddedRatesNotes(1, "Rates notes 1");
		//Contributing firm
		jobDetailSteps.checkAdminApprovedChckbxRates(2);
		jobDetailSteps.getAdminApprovedChckbxRates(2, true);
		jobDetailSteps.clearRatesNotes(2);
		jobDetailSteps.addRatesNotes(2, "Rates notes 2");
		jobDetailSteps.verifyAddedRatesNotes(2, "Rates notes 2");
		jobDetailSteps.clickSave();
		globalSteps.pause(5);
		jobDetailSteps.checkAdminApprovedChckbxRates(2);
		jobDetailSteps.getAdminApprovedChckbxRates(2, false);
		jobDetailSteps.checkAdminApprovedChckbxRates(1);
		jobDetailSteps.getAdminApprovedChckbxRates(1, false);
		jobDetailSteps.clearRatesNotes(1);
		jobDetailSteps.verifyAddedRatesNotes(1, "");
		jobDetailSteps.clickSave();
		globalSteps.pause(5);
		jobDetailSteps.minimizeRatesSection();    
		
		//Commission
		jobDetailSteps.maximizeCommissionSection();
		jobDetailSteps.clickCommissionApplyLink();
		jobDetailSteps.clickApplyButtonCommission();
		//TODO Add sales person
		//jobDetailSteps.assertAppliedCommission("123, 1. / 123, 1. (3 - 3)");
		jobDetailSteps.changeCommissionPercentage(1, "33");
		jobDetailSteps.changeCommissionPercentage(2, "55");
		jobDetailSteps.assertCommissionPercentage(1, "33");
		jobDetailSteps.assertCommissionPercentage(2, "55");
		jobDetailSteps.deleteAppliedCommission(1);
		jobDetailSteps.deleteAppliedCommission(1);
		jobDetailSteps.addNotesCommissionSection("Commission notes");
		jobDetailSteps.clickSave();
		globalSteps.pause(6);
		jobDetailSteps.assertNotesCommissionSection("Commission notes");
		jobDetailSteps.addNotesCommissionSection("");
		jobDetailSteps.clickSave();
		globalSteps.pause(6);
		jobDetailSteps.assertNotesCommissionSection("");
		jobDetailSteps.minimizeCommissionSection();   
		//Files
		jobDetailSteps.maximizeFilesSection();
		jobDetailSteps.addAnotherFileFilesSection(3);
		jobDetailSteps.addFilesNotes("Files notes");
		jobDetailSteps.clickSave();
		jobDetailSteps.assertFilesNotes("Files notes");
		jobDetailSteps.addFilesNotes("Files notes");
		jobDetailSteps.clickSave();
		jobDetailSteps.assertFilesNotes("Files notes");
		jobDetailSteps.deleteAnotherFileFilesSection(2);
		globalSteps.pause(7); 
	} 
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageEquipmentModule() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2220");
	    //Rates
		//jobDetailSteps.minimizeMaximizeEquipmentSection();
		jobDetailSteps.retrieveReporterEquipmentSection("Debbie Zirbz", 1);
		//jobDetailSteps.retrieveVideographerEquipmentSection("Stanley Weinberg");
		globalSteps.pause(15); 
		//jobDetailSteps.attachRatesSheet(1);
	}  */
}
