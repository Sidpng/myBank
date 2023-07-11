package com.example.mybank;

import com.myBank.pages.SignUp;
import com.myBank.utilities.readConfig;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;
    private SignUp signUp;
    readConfig rc=new readConfig();

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(rc.getPropertyName("baseUrl"));
        signUp = new SignUp(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
