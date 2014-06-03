package com.jms.tests;

import net.thucydides.core.annotations.Pending;
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
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesStreamingStory;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

@Story(ExpectedServicesStreamingStory.class)
public class ExpectedServicesStreamingTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "1251";

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_3_1() throws InterruptedException {
		
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
	public void tc4_3_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.CHAT_ROOM_NEEDED, 2);
		
		expectedServicesSteps.isCheckBoxChecked(ReportingService.CHAT_ROOM_NEEDED, true);
		//TODO: Implement click TBD check-box
		
		expectedServicesSteps.clickAddEmailLink();
		expectedServicesSteps.addEmail("test@door3.com");
		
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
	public void tc4_3_3() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.HARDLINE_CONFIRMED, 2);
		
		expectedServicesSteps.clickAddEmailLink();
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
	public void tc4_3_4() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, false);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, false);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
	
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.INTERNET_REALTIME, 2);
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 2);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, false);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, false);
		
	}

	@Test
	@Pending
	@Screenshots(onlyOnFailures = true)
	public void tc4_3_5() throws InterruptedException {
	
	}

}
