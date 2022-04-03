package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.PageBase;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.SearchPage;
import com.javaseleniumtemplate.utils.DriverUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.javaseleniumtemplate.bases.PageBase.driver;

public class SearchTest extends TestBase {
    //Objects
    SearchPage searchPage;

    //Tests
    @Test
    public void searchIssue(){

        DriverUtils.createInstance();
        searchPage = new SearchPage();

        //Parameters
        String issueId = "0009418";
        String user = "hercilio.neto";
        String password = "42aja7pfmantis";

        //Tests
        LoginPage.fillUser(user);
        LoginPage.fillPassword(password);
        LoginPage.clickLogin();
        searchPage.typeIssue(issueId);
        searchPage.clickJump();


        //Should assert if the jumped id is the one that was searched
        WebElement currentId = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td[1]"));
        Assert.assertEquals(currentId.getText(), issueId);

    }
}
