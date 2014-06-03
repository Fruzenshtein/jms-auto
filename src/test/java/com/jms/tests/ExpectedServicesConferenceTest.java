package com.jms.tests;

import org.junit.Test;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.LocationService;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesConferenceStory;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

@Story(ExpectedServicesConferenceStory.class)
public class ExpectedServicesConferenceTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "1251";
	private String jobIdWithVultipleLoc = "1473";
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_1() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
	
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.isServiceIconActivated(VendorService.LOCATION, true);
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.CONFERENCE, true);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.isServiceIconActivated(VendorService.LOCATION, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.isCheckBoxChecked(LocationService.VIDEO_CONF_NEEDED, false);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Cascone & Kluepfel, LLP (1399 Franklin Avenue Suite 302, Garden City, NY, US)");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
	
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.TSG_PROVIDING, 1);
		
		expectedServicesSteps.setIP("207.110.57.178");
		expectedServicesSteps.setISDN("415988488501");
		expectedServicesSteps.setItContact("Robert Huberts");
		expectedServicesSteps.setPhoneConfServices("380447362211");
		//expectedServicesSteps.setNotes("Test notes");
		
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.CAMEO, 1);
		
		expectedServicesSteps.setNumberOfCameos("3");
		
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test@door3.com");

		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);
		
		//TODO: Check Location tab
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Cameo");
		
		//TODO: Complete the test
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_3() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
	
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION, false);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, false);
		
	}
	
	@Test
	@Pending
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_4() throws InterruptedException {
		
	}
	
	@Test
	@Pending
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_5() throws InterruptedException {
		
	}
	
	@Test
	@Pending
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_6() throws InterruptedException {
		
	}
	
	@Test
	@Pending
	@Screenshots(onlyOnFailures = true)
	public void tc4_4_7() throws InterruptedException {
		
	}

}
