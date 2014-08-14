package com.jms.tests;

import java.util.Calendar;

import org.junit.Test;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.StreamServices;
import com.jms.pages.elements.VendorService;
import com.jms.pages.elements.VideographerService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesTestSeries;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(ExpectedServicesTestSeries.class)
public class ExpectedServicesVideographerTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "1251";
	String futureDate = DateGenerator.getInstance().particularDate(2016, Calendar.MAY, 12);

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_2_1() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.VIDEOGRAPHER);
		
		expectedServicesSteps.isCheckBoxChecked(VideographerService.MPEG, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.MPEG_SYNC, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.DVD, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.VHS, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.VIDEO_STREAM, false);
		expectedServicesSteps.isCheckBoxChecked(VideographerService.UPLOAD_TO_REPO, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.VIDEOGRAPHER, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(8);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		
	}

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_2_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG_SYNC, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.VHS, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.DVD, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.UPLOAD_TO_REPO, 2);
		
		expectedServicesSteps.setVideographerInstructions("Videographer insctructions");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(8);
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG/Sync");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "DVD");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "VHS");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Upload to Repository");

		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.DVD, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG, 1);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(5);
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG/Sync");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "VHS");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Upload to Repository");
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_2_3() throws InterruptedException {
		//Fails because of bug!
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.VIDEO_STREAM, 1);
		
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.STREAMING, true);
		expectedServicesSteps.isCheckBoxChecked(StreamServices.VIDEO_STREAM, true);
		expectedServicesSteps.isServiceIconActivated(VendorService.STREAMING, true);
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.STREAMING, "Video Stream");
	
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.STREAMING, true);
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.STREAMING, true);
		
		//TODO: Check Manage module
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(StreamServices.VIDEO_STREAM, 1);
		expectedServicesSteps.isCheckBoxChecked(StreamServices.VIDEO_STREAM, false);
		
		//TODO: Next step is failed due the BUG
		expectedServicesSteps.isServiceIconActivated(VendorService.STREAMING, false);
		//TODO: Complete the test
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_2_4() throws InterruptedException {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG, 1);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(8);
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG");
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.isServiceIconActivated(VendorService.VIDEOGRAPHER, false);
		
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(8);
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, false);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, false);
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickUpdate();
		
		globalSteps.pause(8);
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG");
		
		jobDetailSteps.isServiceIconInVendorSection(VendorService.VIDEOGRAPHER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.VIDEOGRAPHER, true);
	}
	
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_2_5() {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1854");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		//Scheduling firm tab
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.VIDEOGRAPHER);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.VIDEO_STREAM, 1);
		//Contributing firm tab
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickOnVendorSection(2);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.DVD, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(15);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.MPEG_SYNC, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.VHS, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.VIDEO_STREAM, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(VideographerService.UPLOAD_TO_REPO, 2);
		expectedServicesSteps.setVideographerInstructions("Videographer insctructions");
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(10);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Video Streaming");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "DVD");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "MPEG/Sync");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "VHS");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.VIDEOGRAPHERS, "Upload to Repository");
	}
}
