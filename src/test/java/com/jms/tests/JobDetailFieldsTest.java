package com.jms.tests;

import org.junit.Test;

import com.jms.model.Address;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.JobManagementStory.JobDetailFieldsStory;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;
import com.jms.util.RandonNumberGenerator;

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

//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageCaseInfoSection() throws InterruptedException {
//
//		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		jobDetailSteps.setDate(futureDate);
//		jobDetailSteps.setCaseName("Sony presentation"); // TODO: Mark Case name
//															// as TBD
//															// jobDetailSteps.selectCaseType("Meeting");
//		jobDetailSteps.assertJobDetailHeaderLabel(
//				JobDetailHeaderLabel.JOB_TYPE, "Meeting");
//
//		jobDetailSteps.clickCaseInfoCheckBox("Agency Job");
//		jobDetailSteps.clickCaseInfoCheckBox("Non-Contract State");
//
//		jobDetailSteps.setActionNumber("3");
//
//		jobDetailSteps.clickAddConferenceLink();
//		jobDetailSteps.setCaseInfoPhoneNumber("2223399");
//		jobDetailSteps.setCaseInfoPassCode("777");
//		jobDetailSteps.setCaseInstructions("Some instructions");
//
//		jobDetailSteps.clickCaseInfoCheckBox("TSG Provided");
//		jobDetailSteps.selectCaseInfoPhoneNumber(1);
//
//		jobDetailSteps.setSchedulingFirm("Sony Electronics Inc.");
//
//	}
//
//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageWitnessInfoSection() throws InterruptedException {
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		jobDetailSteps.setWitnessName(1, "Robert"); // TODO: TBD
//		jobDetailSteps.setWitnessStartingPgN(1, "7");
//		jobDetailSteps.clickCaseInfoCheckBox("30(b)(6)");
//
//		globalSteps.checkTextPresent("Robert");
//
//		jobDetailSteps.clickAddWitnessButton();
//
//		jobDetailSteps.setWitnessName(2, "Peter");
//		jobDetailSteps.setWitnessStartingPgN(2, "2");
//
//		globalSteps.checkTextPresent("Robert");
//		globalSteps.checkTextPresent("Peter");
//	}
//
//	// TODO: Delete operation }
//
//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageLocationInfoSection() throws InterruptedException {
//
//		Address address1 = new Address();
//		address1.setCompany("Century City Bar Association")
//				.setAddress("1616 Ocean Park Boulevard")
//				.setCity("Santa Monica").setZip("90405")
//				.setCountry("United States of America");
//
//		Address address2 = new Address();
//		address2.setCountry("United States of America");
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		jobDetailSteps.setLocation("Century City Bar Association"); // TODO: TBD
//		jobDetailSteps.checkLocationAddress(1, address1);
//
//		jobDetailSteps.clickCaseInfoCheckBox("Names Required for Security");
//		jobDetailSteps.setLocationAddressNotes(1, "Some notes");
//		jobDetailSteps.setLocationAddressConfRm(1, "55");
//		jobDetailSteps.setLocationAddressContact(1, "Jane Lee"); // TODO: TBD
//		jobDetailSteps.setLocationAddressPhone(1, "553 77 88");
//
//		jobDetailSteps.clickClearAddressFields(1);
//		jobDetailSteps.clickOkButton();
//
//		jobDetailSteps.checkLocationAddress(1, address2); // BUG: 'Clear
//															// address' link
//															// doesn't work }
//	}
//
//	@Test
//	@Pending
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageClientInfoSection() throws InterruptedException {
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		jobDetailSteps.setSchedulingFirm("Altesse Co., Ltd"); // TODO: Continue
//
//	}
//
//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageClientMatter() throws InterruptedException {
//
//		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		String jobId1 = jobDetailSteps.getJobId();
//
//		jobDetailSteps.setSchedulingFirm("Banner");
//		jobDetailSteps.setDate(futureDate);
//		jobDetailSteps.setCaseName("Daily meeting");
//		jobDetailSteps.setClientMatterN("33");
//
//		jobDetailSteps.clickSave();
//
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//
//		String jobId2 = jobDetailSteps.getJobId();
//
//		jobDetailSteps.setSchedulingFirm("Banner");
//		jobDetailSteps.setDate(futureDate);
//		jobDetailSteps.setCaseName("Daily meeting");
//
//		jobDetailSteps.clickSave();
//
//		globalSteps.searchJobById(jobId2);
//
//		jobDetailSteps.assertClientMatterN("33");
//	}
//
//	// TODO: Complete the test }
//
//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageVendorModule() {
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.searchJobById("1644");
//
//		jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER,
//				true);
//		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER,
//				true);
//		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING,
//				true);
//		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION,
//				true);
//		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER,
//				true);
//
//		jobDetailSteps.setExpectedStartTime("10:00 AM");
//		jobDetailSteps.assertExpectedStartTime("10:00 AM");
//
//		// TODO: Need normal identifier for the Finish time field
//		// jobDetailSteps.setExpectedFinishTime("01:00 PM");
//		// jobDetailSteps.assertExpectedFinishTime("01:00 PM");
//
//	}
//
//	@Test
//	@Screenshots(onlyOnFailures = true)
//	public void jobDetailPageClientMatterNumber() throws InterruptedException {
//
//		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
//
//		loginSteps.login(userStorage.getUser(0));
//		globalSteps.searchJobById("300");
//		jobDetailSteps.maximizeClientInfoSection();
//		jobDetailSteps
//				.setClientMatterN(RandonNumberGenerator.getRandomNumber());
//		jobDetailSteps.clickSave();
//		globalSteps.pause(2);
//		jobDetailSteps.writeClientMatterN();
//		globalSteps.pause(1);
//
//		globalSteps.searchJobById("301");
//		jobDetailSteps.maximizeClientInfoSection();
//		jobDetailSteps.maximizeCaseInfoSection();
//		globalSteps.pause(2);
//		jobDetailSteps.clickSave();
//		globalSteps.pause(3);
//		jobDetailSteps.writeClientMatterN();
//		globalSteps.pause(1);
//
//		// create a new job
//		globalSteps.clickCreateJobIcon();
//		globalSteps.openWidgetIn(1);
//		jobDetailSteps.setSchedulingFirm("Thirkill");
//		jobDetailSteps.setDate(futureDate);
//		jobDetailSteps.assertClientMatterNIsDisabled();
//		jobDetailSteps.setCaseName("testClientMatter#");
//		jobDetailSteps.clickSave();
//		globalSteps.pause(5);
//		jobDetailSteps.writeClientMatterN();
//
//		jobDetailSteps.compareClientMatterNs(0, 1, 2);
//		jobDetailSteps.clearClientMatterNList();
//		jobDetailSteps
//				.setClientMatterN(RandonNumberGenerator.getRandomNumber());
//		jobDetailSteps.clickSave();
//		globalSteps.pause(3);
//		jobDetailSteps.writeClientMatterN();
//
//		globalSteps.searchJobById("301");
//		jobDetailSteps.maximizeClientInfoSection();
//		jobDetailSteps.writeClientMatterN();
//
//		globalSteps.searchJobById("300");
//		jobDetailSteps.maximizeClientInfoSection();
//		jobDetailSteps.writeClientMatterN();
//		jobDetailSteps.compareClientMatterNs(0, 1, 2);
//		jobDetailSteps.clearClientMatterNList();
//	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageClientInfoSection() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("123");
		jobDetailSteps.maximizeClientInfoSection();
		jobDetailSteps.clearSchedulingFirmField();
		jobDetailSteps.setSchedulingFirm("Ann Van Devanter Townsend");
		jobDetailSteps.addAdditionalContact();
		jobDetailSteps.checkAdditionalContactConfirmCheckbox();
		jobDetailSteps.clickQuickCRMAddLink();
		jobDetailSteps.addFirstNameQuickCRM("Irina" + RandonNumberGenerator.getRandomNumber());
		jobDetailSteps.addLastNameQuickCRM("M" + RandonNumberGenerator.getRandomNumber());
		jobDetailSteps.addEmailAddressQuickCRM("test@door" + RandonNumberGenerator.getRandomNumber() +".com");
		jobDetailSteps.clickSubmitButtonQuickCRM();
		jobDetailSteps.clickActionMenuLinkSecondContact();
	}
}
