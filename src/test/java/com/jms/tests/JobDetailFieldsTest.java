package com.jms.tests;

import org.junit.Test;

import com.jms.model.Address;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.requirements.JobManagementStory.JobDetailFieldsStory;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

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
	/*
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageCaseInfoSection() throws InterruptedException {
		
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		jobDetailSteps.setDate(futureDate);
		jobDetailSteps.setCaseName("Sony presentation");
		//TODO: Mark Case name as TBD
		jobDetailSteps.selectCaseType("Meeting");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.JOB_TYPE, "Meeting");
		
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
	public void jobDetailPageWitnessInfoSection() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		jobDetailSteps.setWitnessName(1, "Robert");
		//TODO: TBD
		jobDetailSteps.setWitnessStartingPgN(1, "7");
		jobDetailSteps.clickCaseInfoCheckBox("30(b)(6)");
		
		globalSteps.checkTextPresent("Robert");
		
		jobDetailSteps.clickAddWitnessButton();
		
		jobDetailSteps.setWitnessName(2, "Peter");
		jobDetailSteps.setWitnessStartingPgN(2, "2");
		
		globalSteps.checkTextPresent("Robert");
		globalSteps.checkTextPresent("Peter");
		
		//TODO: Delete operation
	}
	*/
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageLocationInfoSection() throws InterruptedException {
		
		Address address1 = new Address();
		address1.setCompany("Century City Bar Association")
			.setAddress("1616 Ocean Park Boulevard")
			.setCity("Santa Monica")
			.setZip("90405")
			.setCountry("United States of America");
		
		Address address2 = new Address();
		address2.setCountry("United States of America");
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		jobDetailSteps.setLocation("Century City Bar Association");
		//TODO: TBD
		jobDetailSteps.checkLocationAddress(1, address1);
		
		jobDetailSteps.clickCaseInfoCheckBox("Names Required for Security");
		jobDetailSteps.setLocationAddressNotes(1, "Some notes");
		jobDetailSteps.setLocationAddressConfRm(1, "55");
		jobDetailSteps.setLocationAddressContact(1, "Jane Lee");
		//TODO: TBD
		jobDetailSteps.setLocationAddressPhone(1, "553 77 88");
		
		jobDetailSteps.clickClearAddressFields(1);
		jobDetailSteps.clickOkButton();
		
		jobDetailSteps.checkLocationAddress(1, address2);
		//BUG: 'Clear address' link doesn't work
	}
}
