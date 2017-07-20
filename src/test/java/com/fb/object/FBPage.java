package com.fb.object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBPage {

	WebDriver driver;
	boolean present = false;
	String getTestURL = "";
	String GmailURL = "http://www.gmail.com/";

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "pass")
	WebElement pwdId;

	@FindBy(id = "loginbutton")
	WebElement lgnbut;

	@FindBy(xpath = ".//*[@class='_4rbf _53ij']")
	WebElement errorTextId;

	Logger logger = Logger.getLogger("devpinoyLogger");

	public FBPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fbLogin(String username, String password) throws InterruptedException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		this.goToFb(username, password);
		Thread.sleep(1000);
	}

	private void goToFb(String username, String password) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(2000);
		emailId.sendKeys(username);
		Thread.sleep(2000);
		pwdId.sendKeys(password);
		Thread.sleep(2000);
		lgnbut.click();
		Thread.sleep(2000);
		System.out.println("******************************************ERRRRRORR***********************");
		System.out.println("The error is:  " + errorTextId.getText());
		Thread.sleep(2000);
	}

}
