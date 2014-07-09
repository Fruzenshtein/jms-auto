package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;

import com.jms.pages.VendorQueuePage;
import com.jms.pages.elements.ActionLink;
import com.jms.pages.elements.Beacon;
import com.jms.pages.elements.BeaconState;
import com.jms.pages.elements.SideMenuBar;

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
/*
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
		jobDetailSteps.clickVendorsActionMenuLink(1,
				ActionLink.SELECT_ANOTHER_VENDOR);

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

		/*
		 * //Deactivate Reporter and Videographer services back
		 * jobDetailSteps.clickExpectedServicesButton();
		 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		 * expectedServicesSteps
		 * .clickVendorServiceIconSection(VendorService.REPORTER);
		 * expectedServicesSteps
		 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		 * expectedServicesSteps.clickUpdate(); globalSteps.pause(4);
		 * jobDetailSteps.clickSave(); globalSteps.pause(3);
		 */
	


	/*
	 * @Test
	 * 
	 * @Screenshots(onlyOnFailures = true) public void
	 * RecommendedAgencyApprovalViaAssignVendorPopup () {
	 * loginSteps.login(userStorage.getUser(0));
	 * globalSteps.searchJobById("1611");
	 * jobDetailSteps.clickExpectedServicesButton();
	 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.REPORTER);
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
	 * expectedServicesSteps.clickUpdate(); globalSteps.pause(7);
	 * jobDetailSteps.clickSave(); globalSteps.pause(17);
	 * jobDetailSteps.clickSave(); globalSteps.pause(5);
	 * 
	 * jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.BLUE);
	 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
	 * 
	 * //Reporter jobDetailSteps.clickManageButton();
	 * jobDetailSteps.clickVendorActionLink(1);
	 * jobDetailSteps.clickVendorsActionMenuLink(1,
	 * ActionLink.SELECT_ANOTHER_VENDOR);
	 * 
	 * globalSteps.pause(60);
	 * assignVendorSteps.selectVendor("Stewart & Shoman");
	 * assignVendorSteps.clickchangeRecommendationButton();
	 * globalSteps.pause(3); assignVendorSteps.clickApproveButton();
	 * globalSteps.pause(3); assignVendorSteps.clickSaveButton();
	 * globalSteps.pause(15); jobDetailSteps.clickSave(); globalSteps.pause(10);
	 * jobDetailSteps.clickSave(); globalSteps.pause(10);
	 * 
	 * jobDetailSteps.isBeacon(Beacon.REPORTER_ASSIGNED, BeaconState.GRAY);
	 * 
	 * //Videographer jobDetailSteps.clickVendorActionLink(2);
	 * jobDetailSteps.clickVendorsActionMenuLink(2,
	 * ActionLink.SELECT_ANOTHER_VENDOR);
	 * 
	 * globalSteps.pause(60);
	 * assignVendorSteps.selectVendor("Capital Reporting Company");
	 * assignVendorSteps.clickchangeRecommendationButton();
	 * globalSteps.pause(3); assignVendorSteps.clickSaveButton();
	 * globalSteps.pause(15); jobDetailSteps.clickSave(); globalSteps.pause(10);
	 * jobDetailSteps.clickSave(); globalSteps.pause(15);
	 * jobDetailSteps.clickVendorActionLink(2); globalSteps.pause(5);
	 * jobDetailSteps.clickVendorsActionMenuLink(2,
	 * ActionLink.APPROVE_RECOMENDATION); globalSteps.pause(5);
	 * jobDetailSteps.clickSave(); globalSteps.pause(10);
	 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.GRAY);
	 * 
	 * //Deativate expected services
	 * jobDetailSteps.clickExpectedServicesButton(); globalSteps.pause(5);
	 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.REPORTER);
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
	 * expectedServicesSteps.clickUpdate(); globalSteps.pause(7);
	 * jobDetailSteps.clickSave();
	 * 
	 * }
	 * 
	 * 
	 * @Test
	 * 
	 * @Screenshots(onlyOnFailures = true) public void
	 * RecommendedAgencyReassignment() {
	 * loginSteps.login(userStorage.getUser(0));
	 * globalSteps.searchJobById("1613");
	 * jobDetailSteps.clickExpectedServicesButton();
	 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
	 * expectedServicesSteps.clickUpdate(); globalSteps.pause(15);
	 * jobDetailSteps.clickSave(); globalSteps.pause(15);
	 * 
	 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED, BeaconState.BLUE);
	 * 
	 * jobDetailSteps.clickManageButton();
	 * jobDetailSteps.clickVendorActionLink(1);
	 * jobDetailSteps.clickVendorsActionMenuLink(1,
	 * ActionLink.SELECT_ANOTHER_VENDOR);
	 * 
	 * globalSteps.pause(70);
	 * assignVendorSteps.selectVendor("Capital Reporting Company");
	 * assignVendorSteps.clickchangeRecommendationButton();
	 * globalSteps.pause(10); assignVendorSteps.clickSaveButton();
	 * globalSteps.pause(15);
	 * 
	 * 
	 * jobDetailSteps.clickVendorActionLink(1);
	 * jobDetailSteps.clickVendorsActionMenuLink(1,
	 * ActionLink.RECOMMEND_ANOTHER_VEND); String currentVandor =
	 * jobDetailSteps.getVendorNameInManageModule(1);
	 * 
	 * globalSteps.waitUntilTextDisappear(currentVandor);
	 * 
	 * jobDetailSteps.clickExpectedServicesButton();
	 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
	 * expectedServicesSteps
	 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
	 * expectedServicesSteps.clickUpdate(); globalSteps.pause(7);
	 * jobDetailSteps.clickSave();
	 * 
	 * }
	 */
	@Test
	@Screenshots(onlyOnFailures = true)
	public void TrustedAgencyAssignmentViaManageModule()
			throws InterruptedException {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1250");
		/*
		 * jobDetailSteps.clickExpectedServicesButton();
		 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		 * expectedServicesSteps
		 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		 * expectedServicesSteps.clickUpdate(); globalSteps.pause(15);
		 * jobDetailSteps.clickSave(); globalSteps.pause(15);
		 * 
		 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED,
		 * BeaconState.BLUE);
		 * 
		 * jobDetailSteps.clickManageButton();
		 * jobDetailSteps.clickVendorActionLink(1);
		 * jobDetailSteps.clickVendorsActionMenuLink(1,
		 * ActionLink.SELECT_ANOTHER_VENDOR);
		 * 
		 * globalSteps.pause(60);
		 * assignVendorSteps.selectVendor("No-Rec Catch All");
		 * assignVendorSteps.clickchangeRecommendationButton();
		 * globalSteps.pause(10); assignVendorSteps.clickSaveButton();
		 * globalSteps.pause(15);
		 * 
		 * 
		 * jobDetailSteps.clickVendorActionLink(1);
		 * jobDetailSteps.clickVendorsActionMenuLink(1,
		 * ActionLink.ASSIGN_WITHOUT_CONFIRM_COMPOSE_JI);
		 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_ASSIGNED,
		 * BeaconState.GREEN);
		 * jobDetailSteps.isBeacon(Beacon.VIDEOGRAPHER_JOB_INFO,
		 * BeaconState.GRAY);
		 */
		globalSteps.clickSideMenuItem(SideMenuBar.CALENDAR_VENDOR_QUEUE);
		globalSteps.openWidgetInNewTab();
		globalSteps.pause(5);
		vednorQueueSteps.clickJobNumberFilterIcon();
		vednorQueueSteps.filterJobsByNumber("1250");

		/*
		 * jobDetailSteps.clickExpectedServicesButton();
		 * globalSteps.waitUntilTextAppear("Special Instructions / Job Info");
		 * expectedServicesSteps
		 * .clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		 * expectedServicesSteps.clickUpdate(); globalSteps.pause(7);
		 * jobDetailSteps.clickSave();
		 */

	}

}
