package com.jms.steps;


import static org.junit.Assert.*;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.jms.model.User;
import com.jms.pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	
	private static final String ERROR_MSG = "This field is required.";

	private LoginPage loginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}
	
	@Step
	public void login(User user) {
		loginPage().login(user);
	}
	
	@Step
	public void checkPageTitle() {
		assertEquals("LOGIN", loginPage().getTitle());
	}
	
	@Step
	public void checkLoginErrorMsg() {
		assertEquals(ERROR_MSG, loginPage().getErrorLogin());
	}
	
	@Step
	public void checkPasswordErrorMsg() {
		assertEquals(ERROR_MSG, loginPage().getErrorPassword());
	}
	
}
