package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows(){
        //Page and Steps Objects
        loginPage = new LoginPage();
    }

    //Flows
    public void logIn(String user, String password){
        loginPage.fillUser(user);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
    }
}
