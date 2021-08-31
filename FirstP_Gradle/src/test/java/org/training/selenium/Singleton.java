package org.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*public class Singleton{//многопоточный1
    private static Singleton instance= new Singleton();
    public WebDriver driver = new ChromeDriver();

    private Singleton(){
    }

    public static Singleton getInstance(){
        return instance;
    }

}*/

/*public class Singleton {//многопоточный2
    public WebDriver driver = new ChromeDriver();
    private Singleton() {
    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        System.out.println("!!!!!!"+Math.random());//Проверка
        return SingletonHolder.instance;
    }
}*/
/*public final class Singleton {//однопоточный для Chrome
    private static Singleton instance;
    public WebDriver driver = new ChromeDriver();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance==null) {
            instance = new Singleton();
            System.out.println("!!!!!!"+Math.random());//Проверка
        }
        return instance;
    }
}*/
public final class Singleton {//однопоточный
    private static Singleton instance;
    public WebDriver driver;

    private Singleton(WebDriver driver) {
        this.driver = driver;
    }

    public static Singleton getInstance(WebDriver driver) {
        if(instance==null) {
            instance = new Singleton(driver);
            System.out.println("!!!!!!"+Math.random());//Проверка
        }
        return instance;
    }
}
