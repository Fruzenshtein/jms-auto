package com.jms.tests;

import org.junit.Test;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import com.jms.model.Address;
import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.LocationService;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesConferenceStory;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

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
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);

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
	@Screenshots(onlyOnFailures = true)
	public void multipleFirmsWitnesses() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("674");
		jobDetailSteps.clickExpectedServicesButton();
		//Scheduling firm
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		//Contributing firm
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(1);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.removeLocation(1);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP("207.110.57.178");
		expectedServicesSteps.setISDN("415988488501");
		expectedServicesSteps.setItContact("Robert Huberts");
		expectedServicesSteps.setPhoneConfServices("380447362211");
	//	expectedServicesSteps.setNotes("Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3");
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.setIP("207.222.11.200");
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test2@door3.com", 2);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		
	}

	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void invalidLocation() throws InterruptedException {

		loginSteps.login(userStorage.getUser(0));
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);

		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
	
		jobDetailSteps.setSchedulingFirm("ABC, Inc.");
		jobDetailSteps.setDate(futureDate);
		jobDetailSteps.setCaseName("IrinaAutoTest");
		jobDetailSteps.setLocationAddress("Company1", 3, "Lilu 5", "Lviv", "02111", "Lviv", 2);
		jobDetailSteps.clickSave();
		globalSteps.pause(7);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP("207.110.57.178");
		expectedServicesSteps.setISDN("415988488501");
		expectedServicesSteps.setItContact("Robert Huberts");
		expectedServicesSteps.setPhoneConfServices("380447362211");
	//	expectedServicesSteps.setNotes("Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3");
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "IrinaCo (Revutskogo 3, Kiev, Kiev, UA)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.maximizeLocationSection();
		jobDetailSteps.clickClearAddressFields(1);
		jobDetailSteps.clickOkButton();
		//Set another location
		
		jobDetailSteps.setLocationAddress("Some company", 2, "Vivi 5", "Kiev", "02111", "Kiev", 3);
		jobDetailSteps.clickSave();
		globalSteps.pause(7);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.removeLocation(1);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP("207.000.00.000");
		expectedServicesSteps.setISDN("45123409");
    	expectedServicesSteps.setItContact("Vi");
		expectedServicesSteps.setPhoneConfServices("3335566");
		//expectedServicesSteps.setNotes("Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("8");
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test2@door3.com", 1);
		expectedServicesSteps.clickUpdate();
	//	jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Some company (Vivi 5, Kiev, Kiev, UA)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		 
		globalSteps.pause(15);
 }

}
