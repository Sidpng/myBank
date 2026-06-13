package com.myBank.tests;

import com.myBank.pages.SignUp;
import com.myBank.utilities.readConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {

	protected WebDriver driver;
	protected SignUp signUp;
	readConfig rc = new readConfig();

	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		// CI-safe flags: run headed under xvfb / inside containers
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(rc.getPropertyName("baseUrl"));
		signUp = new SignUp(driver);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
