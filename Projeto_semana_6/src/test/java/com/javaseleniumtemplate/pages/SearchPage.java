package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase {
    //Mapping
    By issueField = By.name("bug_id");
    By jumpButton = By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/input[2]");


    //Actions
    public void typeIssue(String issueId) {
        WebElement issue = driver.findElement(issueField);
        issue.sendKeys(issueId);
    }
    public void clickJump() {
        click(jumpButton);
    }
}
