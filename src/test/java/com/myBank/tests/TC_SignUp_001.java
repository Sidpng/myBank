package com.example.mybank;

import com.myBank.pages.SignUp;
import com.myBank.utilities.readConfig;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TC_SignUp_001 extends BaseClass {
    readConfig rc=new readConfig();
    @Test(groups= {"signUpTCs"}, priority = 1)
    public void signUpNewUser() {
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
        SignUp su=new SignUp(driver);
        su.setFirstName(rc.getPropertyName("firstName"));
        su.setLastName(rc.getPropertyName("lastName"));
        su.setAddress(rc.getPropertyName("address"));
        su.setCity(rc.getPropertyName("city"));
        su.setState(rc.getPropertyName("state"));
        su.setZip(rc.getPropertyName("zip"));
        su.setPhone(rc.getPropertyName("phone"));
        su.setSSN("44551");
        su.setUsername(rc.getPropertyName("userName"));
        su.setPassword(rc.getPropertyName("password"));
        su.cnfrmPassword(rc.getPropertyName("password"));
        su.btnRegister();
        //System.out.println(driver.getTitle());
    }
}
