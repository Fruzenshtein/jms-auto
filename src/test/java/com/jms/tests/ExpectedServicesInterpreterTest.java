package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.ExpectedServiceSection;
import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.VendorService;
import com.jms.requirements.ExpectedServicesStory.ExpectedServicesInterpreterStory;
import com.jms.steps.ExpectedServicesSteps;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(ExpectedServicesInterpreterStory.class)
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
	/*
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_5_1() throws InterruptedException {
		
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
	*/
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc4_5_2() throws InterruptedException {
		
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

}
