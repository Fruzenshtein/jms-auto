package com.jms.tests;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Test;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.ReportingService;
import com.jms.pages.elements.StreamServices;
import com.jms.pages.elements.VendorService;
import com.jms.pages.elements.VideographerService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesTestSeries;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

@Story(ExpectedServicesTestSeries.class)
public class ExpectedServicesStreamingTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "330";

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_3_1() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.STREAMING);
		
		expectedServicesSteps.isCheckBoxChecked(StreamServices.INTERNET_REALTIME, false);
		expectedServicesSteps.isCheckBoxChecked(StreamServices.INTERNET_REALTIME, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.STREAMING, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_3_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.CHAT_ROOM_NEEDED, 2);
		
		expectedServicesSteps.isCheckBoxChecked(ReportingService.CHAT_ROOM_NEEDED, true);
		//TODO: Implement click TBD check-box
		
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmail(1, "test@door3.com");
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Regular (8-Day) Delivery");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time");
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Internet Real-Time");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Chat");
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		
		//TODO: Work with tabs
		//TODO: Manage section
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.isCheckBoxChecked(ReportingService.INTERNET_REALTIME, false);
		
		//TODO: The next step is bug
		expectedServicesSteps.isServiceIconActivated(VendorService.REPORTER, false);
		
	}

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_3_3() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.HARDLINE_CONFIRMED, 2);
		
		expectedServicesSteps.clickAddEmailLink(1);
		expectedServicesSteps.addEmailInVeideoStream("test@door3.com");
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Video Stream");
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		
		//TODO: Manage module check
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 2);
		expectedServicesSteps.isCheckBoxChecked(StreamServices.VIDEO_STREAM, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.VIDEO_STREAM, false);
		
		//TODO: Bug
		expectedServicesSteps.isServiceIconActivated(VendorService.VIDEOGRAPHER, false);
		
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_3_4() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("671");
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		//Deactivate services
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, false);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, false);
		//Activate services by clicking on the section
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickOnVendorSection(3);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		//Deactivate services
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 2);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(25);
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time, Regular (8-Day) Delivery");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		
	}
	
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_3_5() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("2614");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
	//	jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
	//	jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(5);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.CHAT_ROOM_NEEDED, 2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(15);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Internet Real-Time");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Chat");
	//	jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time, Regular (8-Day) Delivery");
		//Contributing firm
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(15);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Video Stream");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		//Deactivate streaming for scheduling firm
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		//Activate streaming for scheduling firm
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 2);
		//Contributing firm
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time, Regular (8-Day) Delivery");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Internet Real-Time");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Chat");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Video Stream");
	}
	
}
