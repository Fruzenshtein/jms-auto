package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.VendorWorkflowStory;
import com.jms.steps.AssignVendorSteps;
import com.jms.steps.ContactVendorSteps;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(VendorWorkflowStory.class)
public class AgencyVendorAssignmentTest extends BasicTest {

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public GlobalSteps globalSteps;

	@Steps
	public JobDetailSteps jobDetailSteps;

	@Steps
	public ExpectedServicesSteps expectedServicesSteps;

	@Steps
	public AssignVendorSteps assignVendorSteps;

	@Steps
	public ContactVendorSteps contactVendorSteps;

	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendedAgencyVendorApprovalManageModule() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1611");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.clickSave();
		globalSteps.pause(3);
		jobDetailSteps.clickSave();
		// Test starts
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
		
		jobDetailSteps.clickManageButton();
		globalSteps.pause(3);
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		
		globalSteps.pause(25);
		
		assignVendorSteps.selectVendor("Stewart & Shoman");
		assignVendorSteps.clickChangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(5);
		assignVendorSteps.clickApproveButton();
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(10);
		globalSteps.waitUntilTextAppear("Recommendation Approved (Freelancer)");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
	/*	//Deactivate Reporter and Videographer services back
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(4);
		jobDetailSteps.clickSave();
		globalSteps.pause(3); */
	}

}
