package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import com.javaseleniumtemplate.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportPage extends PageBase {
    //Mapping
    By reportLink = By.xpath("/html/body/table[2]/tbody/tr/td[1]/a[3]");
    By chooseProject= By.xpath("/html/body/div[2]/form/table/tbody/tr[2]/td[2]/select");
    By selectButton = By.xpath("/html/body/div[2]/form/table/tbody/tr[4]/td/input");
    By selectCategory = By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > select");
    By selectReproducibility = By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > select");
    By selectSeverity = By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > select");
    By selectPriority = By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > select");
    By selectProfile = By.cssSelector("body > div:nth-child(6) > form > table > tbody > tr:nth-child(6) > td:nth-child(2) > select");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By stepsField = By.name("steps_to_reproduce");
    By addinfoField = By.name("additional_info");
    By submitButton = By.xpath("/html/body/div[3]/form/table/tbody/tr[16]/td[2]/input");
    By checkError = By.xpath("/html/body/div[2]/table/tbody/tr[1]/td");


    //Actions

    public void clickReportLink() {
        click(reportLink);
    };

    public void chooseProject(String project){

        //Created this comboboxSelect at Pagebase so I could simplify and reuse the comboboxselector to not keep repeating the codes.
        PageBase.comboboxSelect(chooseProject, "123", "Fabiana Carvalho´s Project");
    }

    public void clickSelectButton(){
        click(selectButton);
    }

    public void fillInBugData() {
        //This is where the data mass would enter, to fill the values and texts, I left here an example by putting the values.
        PageBase.comboboxSelect(selectCategory, "366", "[All Projects] Hercilio");
        PageBase.comboboxSelect(selectReproducibility, "30", "sometimes");
        PageBase.comboboxSelect(selectSeverity, "30", "text");
        PageBase.comboboxSelect(selectPriority, "40", "high");
        PageBase.comboboxSelect(selectProfile, "361", "PC Windows 10");
        WebElement summary = driver.findElement(summaryField);
        summary.sendKeys("Make it not crash.");

        WebElement description = driver.findElement(descriptionField);
        description.sendKeys("Keep debugging it until you find the reason it keeps crashing.");

        WebElement steps = driver.findElement(stepsField);
        steps.sendKeys("Survey the previous version and compare it to this new one to find the crash link.");

        WebElement addinfo = driver.findElement(addinfoField);
        addinfo.sendKeys("The older version can be found in the administrator ");

    }

    public void clickSubmitButton(){
        click(submitButton);
    }

    public void CheckError(){

    }

}
