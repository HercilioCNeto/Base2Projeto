package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    static By usernameField = By.name("username");
    static By passwordField = By.name("password");
    static By loginButton = By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input");

    //Actions
    public static void fillUser(String user){
        sendKeys(usernameField, user);
    }

    public static void fillPassword(String password){
        sendKeys(passwordField, password);
    }

    public static void clickLogin(){
        click(loginButton);
    }


}
