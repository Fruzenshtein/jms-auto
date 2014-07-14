package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;

import com.jms.pages.VendorQueuePage;
import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.SideMenuLink;

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

@Story(VendorWorkflowStory.AgencyVendorAssignmentStory.class)
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
	
	@Test
	@Screenshots(onlyOnFailures = true)
	//TC6.2.1
	public void recommendedAgencyVendorApproval() {
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
		globalSteps.pause(4);
		
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
		globalSteps.pause(10);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		
		jobDetailSteps.clickVendorActionLink(2);
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
	//TC6.2.2
	public void recommendedAgencyVendorReassignment() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2013");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		
		if (expectedServicesSteps.statusOfServiceIcon(VendorService.REPORTER))
			expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(6);
		jobDetailSteps.clickSave();		
		globalSteps.pause(4);
		
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
		globalSteps.pause(10);
		expectedServicesSteps.clickAgencyByIndex(1);
		expectedServicesSteps.clickChangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.waitUntilTextAppear("Recommendation (Agency)");
		globalSteps.pause(10);
		
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.RECOMMEND_ANOTHER_VEND);
		globalSteps.pause(5);
		
		String currentVandor = jobDetailSteps.getVendorNameInManageModule(1);
		
		globalSteps.waitUntilTextDisappear(currentVandor);
	}
}
