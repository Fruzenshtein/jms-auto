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
		
		expectedServicesSteps.setNumberOfCameos("3", 1);
		
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
		expectedServicesSteps.setNumberOfCameos("3",1);
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
	@Pending
	public void multipleLocations() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("669");
		jobDetailSteps.clickExpectedServicesButton();
		//1st location
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		//2nd location
		expectedServicesSteps.selectConferenceLocation(2);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		//3rd location
		expectedServicesSteps.selectConferenceLocation(3);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickUpdate();
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
				+ "Ball Janik LLP (One Main Place, 101 SW Main Street, Portland, OR, US), "
				+ "Aegis Media North America (150 E. 42nd Street, New York, NY, US)");
		//Provide data
		//1st location
		jobDetailSteps.clickExpectedServicesButton();
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
		jobDetailSteps.setCompanyLocation("MyCompany1", 2);
		jobDetailSteps.setAddress("Address");
		jobDetailSteps.setCity("City");
		jobDetailSteps.setZip("00099");
		jobDetailSteps.setCountry(2);
		jobDetailSteps.setState("State");
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
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "MyCompany1 (Address, City, State, AF)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.clickClearAddressFields(1);
		jobDetailSteps.clickOkButton();
		
		//Set another location
		jobDetailSteps.setCompanyLocation("MyCompany2", 2);
		jobDetailSteps.setAddress("Address2");
		jobDetailSteps.setCity("City2");
		jobDetailSteps.setZip("00022");
		jobDetailSteps.setCountry(3);
		jobDetailSteps.setState("State2");
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
		expectedServicesSteps.setNumberOfCameos("8", 1);
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmailConfServSection("test2@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "MyCompany2 (Address2, City2, State2, AX)");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		 
	//	globalSteps.pause(15);

 }
	

	@Test
	@Screenshots(onlyOnFailures = true)
	public void interpreterServicesMultipleLanguagesWitnesses() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("128");
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, true);
		
		//Add French and German languages
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(3, 2);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(5, 3);
		expectedServicesSteps.selectAppliedWitness(6, 2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "French");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "German");
		//Delete French
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.deleteLanguage(2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "German");
		//Change from German to Spanish
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectLanguage(3, 6);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "Spanish");
		
	}

}
