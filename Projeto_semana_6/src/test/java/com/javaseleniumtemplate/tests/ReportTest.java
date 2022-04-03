package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.PageBase;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.ReportPage;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.utils.DriverUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReportTest extends TestBase {
    //Objects
    ReportPage reportPage;

    //Tests
    @Test
    public void reportIssue(){

        DriverUtils.createInstance();
        reportPage = new ReportPage();

        //Parameters
        String project = "123";
        String user = "hercilio.neto";
        String password = "42aja7pfmantis";

        //Tests
        LoginPage.fillUser(user);
        LoginPage.fillPassword(password);
        LoginPage.clickLogin();
        reportPage.clickReportLink();
        reportPage.chooseProject(project);
        reportPage.clickSelectButton();
        reportPage.fillInBugData();
        reportPage.clickSubmitButton();

        //Should assert if the creation of the issue generated with error, if not it was success.
        WebElement error = PageBase.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td"));
        Assert.assertEquals("APPLICATION ERROR #2800", error.getText());

    }
}
