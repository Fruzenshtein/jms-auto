package com.jms.tests;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Test;

import com.jms.pages.elements.JobDetailHeaderLabel;
import com.jms.pages.elements.SideMenuLink;
import com.jms.requirements.LoginAndJobCreationStory.UserLoginJobCreationTestSeries;
import com.jms.steps.GlobalSteps;
import com.jms.steps.JobDetailSteps;
import com.jms.steps.LoginSteps;
import com.jms.util.DateGenerator;

@Story(UserLoginJobCreationTestSeries.class)
public class LoginAndJobCreationTest extends BasicTest {

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public GlobalSteps globalSteps;
	
	@Steps
	public JobDetailSteps jobDetailSteps;

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_1_1() throws InterruptedException {
		
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
		globalSteps.pause(5);
		jobDetailSteps.assertJobDetailHeaderLabel(JobDetailHeaderLabel.JOB_DATE, futureDate);
		globalSteps.clickSideMenuItem(SideMenuLink.LOG_OUT);
		loginSteps.checkPageTitle();
	}

	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc_1_2() throws InterruptedException {
				
		String futureDate = DateGenerator.getInstance().modifiedDate(0, 0, 1);
		
		loginSteps.login(userStorage.getUser(0));
		globalSteps.pause(3);
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
		
		globalSteps.pause(4);
		jobDetailSteps.setCaseName("Daily meeting");
		globalSteps.pause(2);

		globalSteps.clickSideMenuItem(SideMenuLink.LOG_OUT);
		//Unsuccessful login
		loginSteps.login(userStorage.getUser(1));
		loginSteps.checkLoginErrorMsg();
		loginSteps.checkPasswordErrorMsg();

		loginSteps.login(userStorage.getUser(2));
		loginSteps.checkPasswordErrorMsg();

		loginSteps.login(userStorage.getUser(3));
		loginSteps.checkLoginErrorMsg();

		loginSteps.login(userStorage.getUser(4));
		globalSteps.waitUntilTextAppear("LOGIN");
		
	}

}