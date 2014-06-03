package com.jms.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.jms.model.User;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://tsgjms.d3.local/JMS-P4-QA/Security/Login")
public class LoginPage extends PageObject {

	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(tagName="button")
	private WebElement login;
	
	@FindBy(className="title")
	private WebElement title;
	
	@FindBy(xpath="//label[@for='loginEmail']")
	private WebElement errorLogin;
	
	@FindBy(xpath="//label[@for='loginPassword']")
	private WebElement errorPassword;	
	
	public void login(User user) {
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		email.clear();
		email.sendKeys(user.getLogin());

		password.clear();
		password.sendKeys(user.getPassword());
		
		login.click();
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	public String getErrorLogin() {
		return errorLogin.getText();
	}

	public String getErrorPassword() {
		return errorPassword.getText();
	}
	
}
