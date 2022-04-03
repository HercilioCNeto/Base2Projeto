package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.bases.PageBase;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.utils.DriverUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.text.html.HTMLDocument;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;

    //Tests
    @Test
    public void userLoginSuccessful(){

        DriverUtils.createInstance();
        loginPage = new LoginPage();

        //Parameters
        String user = "hercilio.neto";
        String password = "42aja7pfmantis";
        //Tests
        loginPage.fillUser(user);
        loginPage.fillPassword(password);
        loginPage.clickLogin();

        //Should assert if the login was a success with the user typed.
        WebElement loginTrue = PageBase.driver.findElement(By.className("login-info-left"));
        Assert.assertEquals("Logged in as: hercilio.neto (Hercilio Cezar Cavalcante Neto - manager)", loginTrue.getText());

    }
}
