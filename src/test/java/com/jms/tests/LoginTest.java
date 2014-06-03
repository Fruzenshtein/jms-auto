package com.jms.tests;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;

import org.junit.Test;

import com.jms.requirements.LoginStory.UserLogin;
import com.jms.steps.GlobalSteps;
import com.jms.steps.LoginSteps;

@Story(UserLogin.class)
public class LoginTest extends BasicTest {
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public GlobalSteps globalSteps;
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc1_1() throws InterruptedException {
		loginSteps.login(userStorage.getUser(0));
		globalSteps.clickSideMenuItem("Log Out");
		loginSteps.checkPageTitle();
	}
	
	@Test
	@Screenshots(onlyOnFailures = true)
	public void tc1_2() {
		loginSteps.login(userStorage.getUser(1));
		loginSteps.checkLoginErrorMsg();
		loginSteps.checkPasswordErrorMsg();
		
		loginSteps.login(userStorage.getUser(2));
		loginSteps.checkPasswordErrorMsg();
		
		loginSteps.login(userStorage.getUser(3));
		loginSteps.checkLoginErrorMsg();
		
		loginSteps.login(userStorage.getUser(4));
		globalSteps.checkAlertText("Invalid login information");
	}

}
