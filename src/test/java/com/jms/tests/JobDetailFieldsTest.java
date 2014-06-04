package com.jms.tests;

import org.junit.Test;

import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.requirements.JobManagementStory.JobDetailFieldsStory;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

@Story(JobDetailFieldsStory.class)
public class JobDetailFieldsTest extends BasicTest {

	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void jobDetailPageCaseInfoSection() throws InterruptedException {
		
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		String jobId = jobDetailSteps.getJobId();
		
		jobDetailSteps.setDate(futureDate);
		jobDetailSteps.setCaseName("Sony presentation");
		//TODO: Mark Case name as TBD
		jobDetailSteps.selectCaseType("Meeting");
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.JOB_TYPE, "Meeting");
		
		jobDetailSteps.clickCaseInfoCheckBox("Agency Job");
		jobDetailSteps.clickCaseInfoCheckBox("Non-Contract State");
		
		jobDetailSteps.setActionNumber("3");
		
		jobDetailSteps.clickAddConferenceLink();
		jobDetailSteps.setCaseInfoPhoneNumber("2223399");
		jobDetailSteps.setCaseInfoPassCode("777");
		jobDetailSteps.setCaseInstructions("Some instructions");
		
		jobDetailSteps.clickCaseInfoCheckBox("TSG Provided");
		jobDetailSteps.selectCaseInfoPhoneNumber(1);
		
		jobDetailSteps.setSchedulingFirm("Sony Electronics Inc.");
		
		
		
	}
	
}
