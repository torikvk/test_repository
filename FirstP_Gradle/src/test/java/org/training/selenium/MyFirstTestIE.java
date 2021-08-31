package org.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class MyFirstTestIE {
    public static void main(String[] args) {
        InternetExplorerOptions capabilities = new InternetExplorerOptions();
        capabilities.ignoreZoomSettings();
        Singleton singleton = Singleton.getInstance(new InternetExplorerDriver(capabilities));
        WebDriver driver = singleton.driver;
        try {
            System.out.println("!!!!!!1");
            driver.get("http://www.bbc.com/");
            System.out.println("!!!!!!2");
            System.out.println("!!!!!!"+driver.findElement(By.id("orb-search-q")).isDisplayed()+"\n"+driver.findElement(By.id("orb-search-q")).isEnabled());
            driver.findElement(By.id("orb-search-q")).sendKeys("England");
            driver.findElement(By.id("orb-search-button")).click();
            WebElement searchLink = driver.findElement(By.cssSelector("main#main-content li:first-child"));
            boolean searchLinkPresence = searchLink.isDisplayed();
            boolean searchLinkEnabled = searchLink.isEnabled();
            if(searchLinkEnabled==true && searchLinkPresence==true){
                searchLink.click();
            }                } finally {
            driver.quit();
        }

    }

}
