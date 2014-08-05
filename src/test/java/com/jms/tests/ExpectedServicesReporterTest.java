package com.jms.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Test;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.ReportingService;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesTestSeries;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

@Story(ExpectedServicesTestSeries.class)
public class ExpectedServicesReporterTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Steps
	public ExpectedServicesSteps expectedServicesSteps;
	
	private String jobId = "1252";
	String futureDate = DateGenerator.getInstance().particularDate(2016, Calendar.MAY, 12);

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_1() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
	//	expectedServicesSteps.isAsapCheckBox(true);
		expectedServicesSteps.isCurrentDelivery("Regular (8-Day)");
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.REPORTING, false);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Regular (8-Day) Delivery");
		//TODO: Check WITNESS INFO section
		
		//Revert changes
		//jobDetailSteps.clickExpectedServicesButton();
		//expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		//expectedServicesSteps.clickUpdate();
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_2() throws InterruptedException {
		
		//TODO: Change for @Before method
		loginSteps.login(userStorage.getUser(0));
		
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
	
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.REALTIME, 1);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.ROUGH_DRAFT, 1);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.INTERNET_REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.CHAT_ROOM_NEEDED, 1);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.UPLOAD_TO_REPOSITORY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TRANSCRIPTS, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBITS, 1);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_HARD_COPY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TABBED, 1);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_SCANED_LINKED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.OCR, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TIFF, 1);
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time, Real-Time, Rough Draft, Regular (8-Day) Delivery");
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER, true);
		
		String reporterName = jobDetailSteps.getReporterName();
		
		jobDetailSteps.checkVendorNameInJobDetailsEquipment(reporterName);
		//TODO: Check the number of lap-tops needed
		
		jobDetailSteps.clickManageButton();
		//TODO: Check vendor name
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.UPLOAD_TO_REPOSITORY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_HARD_COPY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_SCANED_LINKED, 1);
		
		expectedServicesSteps.isDisplayedReportingServiceCheckBox(ReportingService.EXHIBITS, false);
		expectedServicesSteps.isDisplayedReportingServiceCheckBox(ReportingService.TRANSCRIPTS, false);
		expectedServicesSteps.isDisplayedReportingServiceCheckBox(ReportingService.TABBED, false);
		expectedServicesSteps.isDisplayedReportingServiceCheckBox(ReportingService.OCR, false);
		expectedServicesSteps.isDisplayedReportingServiceCheckBox(ReportingService.TIFF, false);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.UPLOAD_TO_REPOSITORY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_HARD_COPY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_SCANED_LINKED, 1);
		
		expectedServicesSteps.setNumberOfLeptops("5");
		expectedServicesSteps.clickUpdate();
		//TODO: Check the number of lap-tops needed
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_3() throws InterruptedException {
		
		//TODO: Change for @Before method
		loginSteps.login(userStorage.getUser(0));
		
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.INTERNET_REALTIME, 1);
		//TODO: Check that Streaming service is activated
		
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.STREAMING, true);
		expectedServicesSteps.clickUpdate();
		
		String reporterName = jobDetailSteps.getReporterName();
		
		jobDetailSteps.checkVendorNameInJobDetailsEquipment(reporterName);
		
		jobDetailSteps.clickManageButton();
		//TODO: Check vendor name
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.INTERNET_REALTIME, 1);
		//TODO: Check the check-box is unchecked
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.STREAMING);
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.STREAMING, false);
		
	}	


	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_4() throws InterruptedException {
	
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		
		Calendar cal = new GregorianCalendar(2016, Calendar.MAY, 12);
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Regular (8-Day) Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("Immediate ("+futureDate+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("Immediate Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("Daily ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("Daily Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("2-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 3)+")");
		expectedServicesSteps.clickUpdate();

		globalSteps.waitUntilTextAppear("2-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("3-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("3-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("4-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("4-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("5-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("5-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("6-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("6-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("7-Day ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 3)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("7-Day Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("Regular (7-Day) ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 0)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("Regular (7-Day) Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("Regular (9-Day) ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 2)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("Regular (9-Day) Delivery");
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.selectDelivery("Regular (10-Day) ("+DateGenerator
				.getInstance()
				.modifyParticularDate(cal, 0, 0, 1)+")");
		expectedServicesSteps.clickUpdate();
		
		globalSteps.waitUntilTextAppear("Regular (10-Day) Delivery");
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_5() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER, true);
		
		String reporterName = jobDetailSteps.getReporterName();
		//TODO: Check reporter's name
		
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, false);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER, false);
		//TODO: Verify that Vendor section is disabled
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.REPORTER, true);
		jobDetailSteps.isServiceIconInVendorSection(VendorService.REPORTER, true);
		
		reporterName = jobDetailSteps.getReporterName();
		//TODO: Check reporter's name
		
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_1_6() {
		String testFutureDate = DateGenerator.getInstance().particularDate(2016, Calendar.OCTOBER, 28);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("1937");
		globalSteps.pause(3);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		//Scheduling firm tab
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.INTERNET_REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.REALTIME, 1);
		expectedServicesSteps.setNumberOfLeptops("2");
		//Contributing firm tab
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.ROUGH_DRAFT, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.INTERNET_REALTIME, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.UPLOAD_TO_REPOSITORY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_HARD_COPY, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBIT_SCANED_LINKED, 1);
		expectedServicesSteps.setReporterInstructions("Reporter instructions");
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.EXHIBITS, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.CHAT_ROOM_NEEDED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TRANSCRIPTS, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TABBED, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.OCR, 1);
		expectedServicesSteps.clickReportingServiceCheckBox(ReportingService.TIFF, 1);
		expectedServicesSteps.setNumberOfLeptops("3");
		expectedServicesSteps.selectDelivery("Immediate ("+testFutureDate+")");
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.REPORTER);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(7);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.REPORTERS, "Internet Real-Time, Real-Time, Rough Draft, Immediate Delivery");
		
	}
	
}
