package com.sahabt;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver;

    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "driver/chromedriver";
    public String url = "https://www.sahibinden.com/";

    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver= new ChromeDriver();
        driver.navigate().to(url);
       // click(By.cssSelector(".login-text [rel]"));
        //click(By.cssSelector(".qr-login-promotion .close"));
    }

    public void click(By by) {
        find(by).click();
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }
    public void sendKey(By by, String s){
        driver.findElement(by).sendKeys(s);
    }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login(String username, String password){
        sendKey(By.id("username"), username);
        sendKey(By.id("password"),password);

        click(By.id("userLoginSubmitButton"));

    }

    public  String getTitle(){
        return  driver.getTitle();
    }
    public WebElement find(By by){
        WebElement x = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", x);
        return x;


    }
}
