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

	@Test
	@Screenshots(onlyOnFailures = true)
	public void RecommendedAgencyApprovalViaAssignVendorPopup () {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1611");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.clickSave();		
		globalSteps.pause(17);
		jobDetailSteps.clickSave();
		globalSteps.pause(5);
		
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
		
		//Reporter
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		
		globalSteps.pause(60);
		assignVendorSteps.selectVendor("Stewart & Shoman");
		assignVendorSteps.clickchangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickApproveButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(15);
		jobDetailSteps.clickSave();	
		globalSteps.pause(10);
		jobDetailSteps.clickSave();
		globalSteps.pause(10);
		
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		//Videographer
		jobDetailSteps.clickVendorActionLink(2);
		jobDetailSteps.clickVendorsActionMenuLink(2, ActionLink.SELECT_ANOTHER_VENDOR);
		
		globalSteps.pause(60);
		assignVendorSteps.selectVendor("Capital Reporting Company");
		assignVendorSteps.clickchangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(15);
		jobDetailSteps.clickSave();	
		globalSteps.pause(10);
		jobDetailSteps.clickSave();
		globalSteps.pause(15);
		jobDetailSteps.clickVendorActionLink(2);
		globalSteps.pause(5);
		jobDetailSteps.clickVendorsActionMenuLink(2, ActionLink.APPROVE_RECOMENDATION);
		globalSteps.pause(5);
		jobDetailSteps.clickSave();		
		globalSteps.pause(10);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.GRAY);
		
		//Deativate expected services
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(5);
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.clickSave();
		
	} 
	/*
	@Test
	@Screenshots(onlyOnFailures = true)
	public void RecommendedAgencyApprovalViaManageModule () {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1611");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(15);
		jobDetailSteps.clickSave();		
		globalSteps.pause(15);
		//jobDetailSteps.clickSave();
		//globalSteps.pause(5);
		
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		
		globalSteps.pause(70);
		assignVendorSteps.selectVendor("Stewart & Shoman");
		assignVendorSteps.clickchangeRecommendationButton();
		globalSteps.pause(3);
		assignVendorSteps.clickApproveButton();
		globalSteps.pause(3);
		assignVendorSteps.clickSaveButton();
		globalSteps.pause(15);
		jobDetailSteps.clickSave();	
		globalSteps.pause(10);
		jobDetailSteps.clickSave();
		globalSteps.pause(10);
		globalSteps.waitUntilTextAppear("Agency Assignment Approved");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		jobDetailSteps.clickVendorActionLink(2);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.APPROVE_RECOMENDATION);
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.clickSave();			
		
	} */
}
