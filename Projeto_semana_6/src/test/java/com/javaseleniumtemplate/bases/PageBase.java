package com.javaseleniumtemplate.bases;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.utils.DriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.StopWatch;

public class PageBase {
    //Variaveis globlais
    public static WebDriverWait wait = null;
    public static WebDriver driver = null;
    public static JavascriptExecutor javaScriptExecutor = null;

    //Construtor
    public PageBase(){
        wait = new WebDriverWait (DriverUtils.INSTANCE, GlobalParameters.TIMEOUT_DEFAULT);
        driver = DriverUtils.INSTANCE;
        javaScriptExecutor = (JavascriptExecutor) driver;
    }

    //Custom Actions
    private static void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            String documentState = javaScriptExecutor.executeScript("return document.readyState").toString();
            if (documentState.equals("complete")){
                timeOut.stop();
                break;
            }
        }
    }

    protected static WebElement waitForElement(By locator){
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected static void click(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            WebElement element = null;

            try
            {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                return;
            }

            catch (StaleElementReferenceException e)
            {
                continue;
            }

            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Did this so I reuse it wherever I want.
    public static void comboboxSelect(By locator, String value, String text){
        WebElement comboboxElement = driver.findElement(locator);
        driver.findElement(locator).click();
        Select combobox = new Select(comboboxElement);
        combobox.selectByValue(value);
        combobox.selectByVisibleText(text);
    }

    protected static void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
    }

    protected void sendKeysWithoutWaitVisible(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected void comboBoxSelectByVisibleText(By locator, String text){
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        return text;
    }

    protected String getValue(By locator){
        String text = waitForElement(locator).getAttribute("value");
        return text;
    }

    //Default actions
    public void refresh(){
        DriverUtils.INSTANCE.navigate().refresh();
    }

    public void navigateTo(String url){
        DriverUtils.INSTANCE.navigate().to(url);
    }

    public void openNewTab(){
        javaScriptExecutor.executeScript("window.open();");
    }
    public void closeTab(){
        driver.close();
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getURL(){
        String url = driver.getCurrentUrl();
        return url;
    }


}
