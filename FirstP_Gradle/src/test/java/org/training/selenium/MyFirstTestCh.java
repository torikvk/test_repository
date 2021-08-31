package org.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTestCh {

    public static void main(String[] args) {
   
        Singleton singleton = Singleton.getInstance(new ChromeDriver());
        WebDriver driver = singleton.driver;
        try {
            driver.get("http://www.bbc.com/");
            driver.findElement(By.id("orb-search-q")).sendKeys("England");
            driver.findElement(By.id("orb-search-button")).click();
            WebElement searchLink = driver.findElement(By.cssSelector("main#main-content li:first-child"));
            boolean searchLinkPresence = searchLink.isDisplayed();
            boolean searchLinkEnabled = searchLink.isEnabled();
            if(searchLinkEnabled==true && searchLinkPresence==true){
                searchLink.click();
            }

        } finally {
            driver.quit();
        }

    }

}
