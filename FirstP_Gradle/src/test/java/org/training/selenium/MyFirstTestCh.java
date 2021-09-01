package org.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyFirstTestCh {

    public static void main(String[] args) {
       
        Singleton singleton = Singleton.getInstance(new ChromeDriver());
        WebDriver driver = singleton.driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("http://www.bbc.com/");
            driver.findElement(By.id("orb-search-q")).sendKeys("England");
            driver.findElement(By.id("orb-search-button")).click();
            WebElement searchLink = driver.findElement(By.cssSelector("main#main-content li:first-child"));
            boolean searchLinkDisplayed = waitForIsDisplayed(searchLink,10);
            boolean searchLinkEnabled = waitForIsEnabled(searchLink,10);
            if(searchLinkEnabled && searchLinkDisplayed){
                searchLink.click();
            }

        } finally {
            driver.quit();
        }

    }

    public static boolean waitForIsDisplayed(WebElement element,float watingTime){
        float currentTime=0;
        float startTime = System.currentTimeMillis();
        while (!element.isDisplayed()){
            if(currentTime<=watingTime){
                currentTime = System.currentTimeMillis()-startTime;
            }
            else{
                System.out.println("!!!TimeOutException in waitForIsDisplayed: condition wasn't executed with time limit");
                return false;
            }
        }
        return true;
    }

    public static boolean waitForIsEnabled(WebElement element, float watingTime){
        float currentTime=0;
        float startTime = System.currentTimeMillis();
        while (!element.isEnabled()){
            if(currentTime<=watingTime){
                currentTime = System.currentTimeMillis()-startTime;
            }
            else{
                System.out.println("!!!TimeOutException in waitForIsEnabled: condition wasn't executed with time limit");
                return false;
            }
        }
        return true;
    }

}
