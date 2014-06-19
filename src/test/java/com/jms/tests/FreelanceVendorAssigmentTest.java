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
public class FreelanceVendorAssigmentTest extends BasicTest {
	
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
	public void recommendedVendorReassignment() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1713");
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.RECOMMEND_ANOTHER_VEND);
		
		String currentVandor = jobDetailSteps.getVendorNameInManageModule(1);
		
		globalSteps.waitUntilTextDisappear(currentVandor);
		
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendedVendorApproval() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1710");
		
		//Preparing test data
		//We expect that on test start the job has 2 reporter inside
		//And we need to re-init them
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(2);
		jobDetailSteps.clickSave();		
		globalSteps.pause(2);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(14);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);
		
		//Test starts
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		
		globalSteps.pause(5);
		assignVendorSteps.clickApproveButton();
		assignVendorSteps.clickSaveButton();
		
		globalSteps.pause(20);
		globalSteps.waitUntilTextAppear("Recommendation Approved (Freelancer)");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		jobDetailSteps.clickVendorActionLink(2);
		jobDetailSteps.clickVendorsActionMenuLink(2, ActionLink.APPROVE_RECOMENDATION);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.GRAY);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendationApprovedVendorContactViaCalled() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1700");
		
		//Preparing test data
		//We expect that on test start the job has 1 approved reporter
		//And we need to re-init them
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(2);
		jobDetailSteps.clickSave();		
		globalSteps.pause(2);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(10);
		
		jobDetailSteps.clickSave();
		
		globalSteps.pause(8);

		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.APPROVE_RECOMENDATION);
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
		
		//Test starts
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickVendorsActionMenuLink(1, ActionLink.CONTACT_FOR_ASSIGNMENT);
		contactVendorSteps.clickCalledButton();
		contactVendorSteps.clickContactedButton();
		
		globalSteps.waitUntilTextAppear("Assignment Unconfirmed");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.YELLOW);
		
	}

}
