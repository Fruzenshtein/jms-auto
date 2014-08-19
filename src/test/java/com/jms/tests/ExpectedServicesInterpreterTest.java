package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesTestSeries;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(ExpectedServicesTestSeries.class)
public class ExpectedServicesInterpreterTest extends BasicTest {

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
	public void tc_4_5_1() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.INTERPRETER);
		
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.INTERPRETER, true);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.isExpectedServicesSection(ExpectedServiceSection.INTERPRETER, false);
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickAddLanguageLink();
		
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, true);
		
		//TODO: Check Vendor tab
		
		
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_5_2() throws InterruptedException {
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById(jobId);
		jobDetailSteps.clickExpectedServicesButton();
		
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.INTERPRETER);
		
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.clickUpdate();
		
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, true);
		
		//TODO: Check Vendor tab
		
		jobDetailSteps.clickExpectedServicesButton();
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickUpdate();
	
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, false);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, false);
		globalSteps.checkTextNotPresent("English");
		
		
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_5_3() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("128");
		globalSteps.pause(5);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickVendorTBDIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.isServiceIconInVendorSection(VendorService.INTERPRETER, true);
		jobDetailSteps.isServiceIconInWitnessInfo(VendorService.INTERPRETER, true);
		
		//Add French and German languages
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(3, 2);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(5, 3);
		expectedServicesSteps.selectAppliedWitness(6, 2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "French");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "German");
		//Delete French
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(5);
		expectedServicesSteps.deleteLanguage(2);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "German");
		//Change from German to Spanish
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.selectLanguage(3, 6);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "Spanish");
		
	}
	/*
	@Pending
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_5_4() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("75");
		globalSteps.pause(5);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(1, 0);
		expectedServicesSteps.selectAppliedWitness(2, 0);
		//Contributing firm tab
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(1, 2);
		expectedServicesSteps.selectAppliedWitness(2, 0);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "French");
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(3, 6);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		//Contributing firm tab
		expectedServicesSteps.goToFirmTab(2);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(3, 0);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "French");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "Spanish");
		//TODO: check languages applied to each witness
		globalSteps.pause(5);
	}
*/
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_4_5_5() {

		loginSteps.login(userStorage.getUser(0));
		globalSteps.searchJobById("34");
		globalSteps.pause(5);
		jobDetailSteps.clickExpectedServicesButton();
		globalSteps.pause(3);
		expectedServicesSteps.clickVendorServiceIconSection(VendorService.INTERPRETER);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(1, 0);
		expectedServicesSteps.selectAppliedWitness(2, 0);
		expectedServicesSteps.clickAddLanguageLink();
		expectedServicesSteps.selectLanguage(3, 4);
		expectedServicesSteps.selectAppliedWitness(4, 1);
		expectedServicesSteps.clickUpdate();
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "English");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.INTERPRETERS, "Russian");
		
	}
	
	
}
