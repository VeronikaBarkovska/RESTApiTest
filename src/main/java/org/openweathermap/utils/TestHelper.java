package org.openweathermap.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestHelper {
    private WebDriver driver;



    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isPageLoad(){
        return getJsExecutor(driver).executeScript("return document.readyState").equals("complete");
    }
    public JavascriptExecutor getJsExecutor(WebDriver driver){
        return (JavascriptExecutor) driver;
    }
}
