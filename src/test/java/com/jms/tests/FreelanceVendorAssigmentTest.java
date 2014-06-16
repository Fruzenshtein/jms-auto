package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.VendorWorkflowStory;
import com.jms.steps.AssignVendorSteps;
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
/*
	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendedVendorReassignment() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1713");
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickVendorActionLink(1);
		jobDetailSteps.clickActionMenuLink(1, ActionLink.RECOMMEND_ANOTHER_VEND);
		
		String currentVandor = jobDetailSteps.getVendorNameInManageModule(1);
		
		globalSteps.waitUntilTextDisappear(currentVandor);
		
	}
	*/
	@Test
	@Screenshots(onlyOnFailures = true)
	public void recommendedVendorApproval() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1710");
		
		//Preparing test data
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(5);
		jobDetailSteps.clickSave();
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(5);
		jobDetailSteps.clickSave();
		
		//Test starts
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
		jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
		
		jobDetailSteps.clickManageButton();
		jobDetailSteps.clickActionMenuLink(1, ActionLink.SELECT_ANOTHER_VENDOR);
		
		assignVendorSteps.clickApproveButton();
		assignVendorSteps.clickSaveButton();
		
		globalSteps.checkTextPresent("Recommendation Approved (Freelancer)");
		jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
	}
	
	

}
