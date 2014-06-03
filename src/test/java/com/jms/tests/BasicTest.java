package com.jms.tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.jms.util.UserStorage;

@RunWith(ThucydidesRunner.class)
public class BasicTest {
	
	protected UserStorage userStorage = UserStorage.getInstance();
	
	@Managed
	public WebDriver webDriver;
	
	@ManagedPages
	public Pages pages;

}
