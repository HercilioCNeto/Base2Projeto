package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.ReportPage;

public class ReportFlows {
    //Objects and constructor
    ReportPage reportPage;

    public ReportFlows(){
        //Page and Steps Objects
        reportPage = new ReportPage();
    }

    //Flows
    public void reportIssue(String project){
        reportPage.clickReportLink();
        reportPage.chooseProject(project);
        reportPage.clickSelectButton();
    }
}
