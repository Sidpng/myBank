package com.myBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the ParaBank registration form.
 * (No assertions here — those belong in the test layer.)
 */
public class SignUp {

	private final WebDriver driver;

	// ParaBank register-form locators
	private final By firstName = By.id("customer.firstName");
	private final By lastName = By.id("customer.lastName");
	private final By address = By.id("customer.address.street");
	private final By city = By.id("customer.address.city");
	private final By state = By.id("customer.address.state");
	private final By zip = By.id("customer.address.zipCode");
	private final By phone = By.id("customer.phoneNumber");
	private final By ssn = By.id("customer.ssn");
	private final By username = By.id("customer.username");
	private final By password = By.id("customer.password");
	private final By repeatedPassword = By.id("repeatedPassword");
	private final By registerButton = By.cssSelector("input[value='Register']");
	private final By confirmationText = By.cssSelector("#rightPanel p");

	public SignUp(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName(String value) {
		driver.findElement(firstName).sendKeys(value);
	}

	public void setLastName(String value) {
		driver.findElement(lastName).sendKeys(value);
	}

	public void setAddress(String value) {
		driver.findElement(address).sendKeys(value);
	}

	public void setCity(String value) {
		driver.findElement(city).sendKeys(value);
	}

	public void setState(String value) {
		driver.findElement(state).sendKeys(value);
	}

	public void setZip(String value) {
		driver.findElement(zip).sendKeys(value);
	}

	public void setPhone(String value) {
		driver.findElement(phone).sendKeys(value);
	}

	public void setSSN(String value) {
		driver.findElement(ssn).sendKeys(value);
	}

	public void setUsername(String value) {
		driver.findElement(username).sendKeys(value);
	}

	public void setPassword(String value) {
		driver.findElement(password).sendKeys(value);
	}

	public void cnfrmPassword(String value) {
		driver.findElement(repeatedPassword).sendKeys(value);
	}

	public void btnRegister() {
		driver.findElement(registerButton).click();
	}

	public String getConfirmationMessage() {
		return driver.findElement(confirmationText).getText();
	}
}
