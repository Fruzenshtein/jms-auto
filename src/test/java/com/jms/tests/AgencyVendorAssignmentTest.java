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

import com.jms.steps.VednorQueueSteps;

import com.jms.steps.LoginSteps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(VendorWorkflowStory.VendorWorkflowTestSeriesAgencyVendorAssignment.class)
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

	@Steps
	public VednorQueueSteps vednorQueueSteps;
	
	//Alternative test data: 2013, 2007, 2024
	private String jobId = "2013";

	@Test
	@Screenshots(onlyOnFailures = true)

	public void tc_6_2_1() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2012");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.VIDEOGRAPHER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(6);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(18);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(5);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		
		globalSteps.pause(5);
		jobDetailSteps.clickVendorActionLink(2);
		globalSteps.pause(5);
		jobDetailSteps.clickVendorsActionMenuLink(2, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(10);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(10);
		
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(5);
		assignVendorSteps.clickApproveButton();
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(20);
		globalSteps.waitUntilTextAppear("Agency Assignment Approved");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		jobDetailSteps.clickVendorActionLink(2);
		jobDetailSteps.clickVendorsActionMenuLink(2, ActionLink.APPROVE_RECOMENDATION);
		globalSteps.pause(20);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.GRAY);	
	}

	@Test
	@Screenshots(onlyOnFailures = true)
	
	public void tc_6_2_2() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(6);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(18);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(5);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		globalSteps.pause(10);
		
		//Test starts
		String currentVandor = jobDetailSteps.getVendorNameInManageModule(1);
		
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.RECOMMEND_ANOTHER_VEND);
		globalSteps.pause(10);
		
		globalSteps.waitUntilTextDisappear(currentVandor);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)

	public void tc_6_2_5() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(6);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(14);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(5);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		globalSteps.pause(10);
		
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.APPROVE_RECOMENDATION);
		
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.CONTACT_FOR_ASSIGNMENT);
		contactVendorSteps.clickCalledButton();
		contactVendorSteps.clickContactedButton();
		
		globalSteps.waitUntilTextAppear("Assignment Unconfirmed");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.YELLOW);
	}
	
	
	@Test
	@Screenshots(onlyOnFailures = true)
	
	public void tc_6_2_7() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2007");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(6);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(18);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(5);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		globalSteps.pause(10);
	
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.APPROVE_RECOMENDATION);
		
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.CONTACT_FOR_ASSIGNMENT);
		contactVendorSteps.clickCalledButton();
		contactVendorSteps.clickAcceptedButton();
		
		globalSteps.pause(60);
		globalSteps.waitUntilTextAppear("Job Info - Prep Draft");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GREEN);
	
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_6_2_8() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2007");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(6);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		globalSteps.pause(20);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(5);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		globalSteps.pause(10);
	
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.APPROVE_RECOMENDATION);
		
//		String name = jobDetailSteps.getVendorNameInManageModule(1);
		
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.CONTACT_FOR_ASSIGNMENT);
		contactVendorSteps.clickCalledButton();
		contactVendorSteps.clickRejectedButton();
		
		globalSteps.pause(10);
//		globalSteps.waitUntilTextDisappear(name);
//		globalSteps.waitUntilTextAppear("Recommendation (Freelancer)");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
	
	}
	
}
