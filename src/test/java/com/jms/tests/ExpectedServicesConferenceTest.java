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
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesTestSeries;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

@Story(ExpectedServicesTestSeries.class)
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

	public void tc_4_4_1() throws InterruptedException {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.isServiceIconActivated(VendorService.LOCATION,
				true);
		expectedServicesSteps.isExpectedServicesSection(
				ExpectedServiceSection.CONFERENCE, true);

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.isServiceIconActivated(VendorService.LOCATION,
				false);

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.isCheckBoxChecked(
				LocationService.VIDEO_CONF_NEEDED, false);
		expectedServicesSteps.clickUpdate();

		jobDetailSteps
				.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES,
						"Cascone & Kluepfel, LLP (1399 Franklin Avenue Suite 302, Garden City, NY, US)");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION,
				true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);
	}

	@Test
	@Screenshots(onlyOnFailures = true)

	public void tc_4_4_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);

		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);

		expectedServicesSteps.setIP(1, "207.110.57.178");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert Huberts");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");

		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);

		expectedServicesSteps.setNumberOfCameos("3", 1);

		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);

		expectedServicesSteps.clickUpdate();

		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION,
				true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);

		// TODO: Check Location tab

		jobDetailSteps.clickExpectedServicesButton();

		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickUpdate();

		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Cameo");

		// TODO: Complete the test
	}

	@Test
	@Screenshots(onlyOnFailures = true)

	public void tc_4_4_3() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);

		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();

		expectedServicesSteps.clickUpdate();

		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION,
				true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.LOCATION, true);

		jobDetailSteps.clickExpectedServicesButton();

		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);

		expectedServicesSteps.clickUpdate();

		jobDetailSteps.isServiceIconInVendorSection(VendorService.LOCATION,
				false);
		jobDetailSteps
				.isServiceIconInWitnessInfo(VendorService.LOCATION, false);

	}

	@Test
	@Screenshots(onlyOnFailures = true)
	
	public void tc_4_4_4() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("674");
		globalSteps.pause(3);
		jobDetailSteps.clickExpectedServicesButton();

		// Scheduling firm
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		globalSteps.pause(3);
		//Scheduling firm
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		// Contributing firm
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(1);
		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US");

		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.removeLocation(1);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "207.110.57.178");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert Huberts");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.setIP(1, "207.222.11.200");
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test2@door3.com", 2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");

	}

	@Test
	@Screenshots(onlyOnFailures = true)

	@Pending
	public void tc_4_4_5() {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("669");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		//1st location
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.LOCATION);

		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		// 2nd location
		expectedServicesSteps.selectConferenceLocation(2);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		// 3rd location
		expectedServicesSteps.selectConferenceLocation(3);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);

		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
								+ "Ball Janik LLP (One Main Place, 101 SW Main Street, Portland, OR, US), "
								+ "Aegis Media North America (150 E. 42nd Street, New York, NY, US)");
		// Provide data
		// 1st location

		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.CONF_SERVICES, "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
				+ "Ball Janik LLP (One Main Place, 101 SW Main Street, Portland, OR, US), "
				+ "Aegis Media North America (150 E. 42nd Street, New York, NY, US)");
		//Provide data
		//1st location

		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "333.119.33.111");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert H");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		// 2nd location
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 2);
		expectedServicesSteps.setIP(2, "333.119.33.111");
		expectedServicesSteps.setISDN(2, "415988488501");
		expectedServicesSteps.setItContact(2, "Robert H");
		expectedServicesSteps.setPhoneConfServices(2, "380447362211");
		expectedServicesSteps.setNotes(2, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 2);
		expectedServicesSteps.setNumberOfCameos("3", 2);
		expectedServicesSteps.clickAddEmailLink(2);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 2);
		// 3rd location
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 3);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 3);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 3);
		expectedServicesSteps.setIP(3, "333.119.33.111");
		expectedServicesSteps.setISDN(3, "415988488501");
		expectedServicesSteps.setItContact(3, "Robert H");
		expectedServicesSteps.setPhoneConfServices(3, "380447362211");
		expectedServicesSteps.setNotes(3, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 3);
		expectedServicesSteps.setNumberOfCameos("3", 3);
		expectedServicesSteps.clickAddEmailLink(3);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 3);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
								+ "Ball Janik LLP (One Main Place, 101 SW Main Street, Portland, OR, US), "
								+ "Aegis Media North America (150 E. 42nd Street, New York, NY, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		globalSteps.pause(10);
	}

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_4_7() throws InterruptedException {

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
		globalSteps.pause(3);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "207.110.57.178");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert Huberts");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES,
				"MyCompany1 (Address, City, State, AF)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
		jobDetailSteps.clickClearAddressFields(1);
		jobDetailSteps.clickOkButton();

		// Set another location
		jobDetailSteps.setCompanyLocation("MyCompany2", 2);
		jobDetailSteps.setAddress("Address2");
		jobDetailSteps.setCity("City2");
		jobDetailSteps.setZip("00022");
		jobDetailSteps.setCountry(3);
		jobDetailSteps.setState("State2");
		jobDetailSteps.clickSave();
		globalSteps.pause(7);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.removeLocation(1);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "207.000.00.000");
		expectedServicesSteps.setISDN(1, "45123409");
		expectedServicesSteps.setItContact(1, "Vi");
		expectedServicesSteps.setPhoneConfServices(1, "3335566");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("8", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test2@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES,
				"MyCompany2 (Address2, City2, State2, AX)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");


	}

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_4_6() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("432");
		jobDetailSteps.clickExpectedServicesButton();
		// Scheduling firm
		// 1st location
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(1);
		expectedServicesSteps.chooseRoomTSGLocation(1, 1);
		expectedServicesSteps.clickAddLocationLink();
		// 2nd location
		expectedServicesSteps.selectConferenceLocation(2);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		// Contributing firm
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps
				.clickVendorServiceIconSection(VendorService.LOCATION);
		expectedServicesSteps.selectConferenceLocation(3);
		expectedServicesSteps.clickAddLocationLink();
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Bob's Super Company (123 Test Road, New York, NY, US), "
								+ "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
								+ "Bullivant Houser Bailey PC (888 S.W. Fifth Avenue Suite 300, Portland, OR, US)");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "207.110.57.178");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert Huberts");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		// 2nd location
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.LOCATION);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 2);
		expectedServicesSteps.setItContact(2, "Robert Huberts");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 2);
		expectedServicesSteps.setNumberOfCameos("1", 2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 2);
		// Contributing firm
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.VIDEO_CONF_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.INITIATES_CONF, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.TSG_PROVIDING, 1);
		expectedServicesSteps.setIP(1, "207.110.57.178");
		expectedServicesSteps.setISDN(1, "415988488501");
		expectedServicesSteps.setItContact(1, "Robert Huberts");
		expectedServicesSteps.setPhoneConfServices(1, "380447362211");
		expectedServicesSteps.setNotes(1, "Test notes");
		expectedServicesSteps.clickReportingServiceCheckBox(
				LocationService.CAMEO, 1);
		expectedServicesSteps.setNumberOfCameos("3", 1);
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailConfServSection("test@door3.com", 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(3);
		jobDetailSteps
				.assertJobDetailHeaderLabel(
						JobDetailHeaderLabel.CONF_SERVICES,
						"Bob's Super Company (123 Test Road, New York, NY, US), "
								+ "Andrew Rosner & Associates (600 Old Country Road, Suite 520, Garden City, NY, US), "
								+ "Bullivant Houser Bailey PC (888 S.W. Fifth Avenue Suite 300, Portland, OR, US)");
		jobDetailSteps.assertJobDetailHeaderLabel(
				JobDetailHeaderLabel.CONF_SERVICES, "Video Conference, Cameo");
	
 }
	

}
