package com.qa.base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

     public static WebDriver driver;
     private int timeOut = 3;


    public void initWebDriver(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    public void quitWebDriver(){

        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public boolean isClick(By locator){

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;

        }
    }

    public boolean type(By locator, String value){

        try{
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
            element.sendKeys(value);
            return true;
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return false;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

    }


    public String getText(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(locator),"value"));
            return driver.findElement(locator).getAttribute("value");
        }catch (Exception ex){
            return null;
        }
    }

    public boolean isAvailable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))) != null;
    }

    public WebElement getElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void selectFromList(By locator, String val){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Select st = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        st.selectByValue(val);
    }

    public void scrollDown(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
