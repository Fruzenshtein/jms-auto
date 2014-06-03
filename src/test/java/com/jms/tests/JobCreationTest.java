package com.jms.tests;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Test;

import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.requirements.JobManagementStory.JobCreation;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

@Story(JobCreation.class)
public class JobCreationTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc2_1() throws InterruptedException {
		
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		String jobId = jobDetailSteps.getJobId();
		
		jobDetailSteps.setSchedulingFirm("ABC, Inc.");
		jobDetailSteps.setDate(futureDate);
		jobDetailSteps.setCaseName("Daily meeting");
		
		jobDetailSteps.clickSave();
		
		globalSteps.searchJobById(jobId);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.JOB_DATE, futureDate);
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc2_2() throws InterruptedException {
		
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
		String pastDate = DateGenerator.getInstance().modifiedDate(-1, 0, 1);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickCreateJobIcon();
		globalSteps.openWidgetIn(1);
		
		jobDetailSteps.clickSave();
		
		globalSteps.checkMessageText("There were issues with your request");
		globalSteps.checkMessageText("ERRORS:");
		globalSteps.checkMessageText("Please enter a job date.");
		globalSteps.checkMessageText("WARNINGS:");
		globalSteps.checkMessageText("Please enter a firm name.");
		globalSteps.checkMessageText("Please enter a case name for this job.");
		
		globalSteps.clickOkMessagePopup();
		
		jobDetailSteps.setSchedulingFirm("ABC, Inc.");
		jobDetailSteps.clickSave();
		
		globalSteps.checkMessageText("There were issues with your request");
		globalSteps.checkMessageText("ERRORS:");
		globalSteps.checkMessageText("Please enter a job date.");
		globalSteps.checkMessageText("WARNINGS:");
		globalSteps.checkMessageText("Please enter a case name for this job.");
		
		globalSteps.clickOkMessagePopup();
		
		jobDetailSteps.setDate(futureDate);
		jobDetailSteps.clickSave();
		
		globalSteps.checkMessageText("The request was successful, but there were some issues");
		globalSteps.checkMessageText("WARNINGS:");
		globalSteps.checkMessageText("Please enter a case name for this job.");
		
		globalSteps.clickOkMessagePopup();
		
		jobDetailSteps.setDate(pastDate);
		jobDetailSteps.setCaseName("Daily meeting");
		jobDetailSteps.clickSave();
		
		globalSteps.checkMessageText("There were issues with your request");
		globalSteps.checkMessageText("ERRORS:");
		globalSteps.checkMessageText("The job date cannot be before today's date");
		
	}

}
