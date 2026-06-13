package com.myBank.tests;

import com.myBank.pages.SignUp;
import com.myBank.utilities.readConfig;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_SignUp_001 extends BaseClass {

	readConfig rc = new readConfig();

	@Test(groups = { "signUpTCs" }, priority = 1)
	public void signUpNewUser() {
		// open the Register form from the home page
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();

		// unique username so the test is repeatable (ParaBank rejects duplicates)
		String uniqueUser = rc.getPropertyName("userName") + System.currentTimeMillis();

		SignUp su = new SignUp(driver);
		su.setFirstName(rc.getPropertyName("firstName"));
		su.setLastName(rc.getPropertyName("lastName"));
		su.setAddress(rc.getPropertyName("address"));
		su.setCity(rc.getPropertyName("city"));
		su.setState(rc.getPropertyName("state"));
		su.setZip(rc.getPropertyName("zip"));
		su.setPhone(rc.getPropertyName("phone"));
		su.setSSN("44551");
		su.setUsername(uniqueUser);
		su.setPassword(rc.getPropertyName("password"));
		su.cnfrmPassword(rc.getPropertyName("password"));
		su.btnRegister();

		String confirmation = su.getConfirmationMessage();
		Assert.assertTrue(confirmation.toLowerCase().contains("successfully"),
				"Expected a success confirmation but got: " + confirmation);
	}
}
