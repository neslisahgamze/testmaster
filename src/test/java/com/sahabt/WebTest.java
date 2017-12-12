package com.sahabt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {

    WebDriver driver;

    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "driver/chromedriver";
    public String url = "http://46.101.63.20:8080/testinium";

    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver= new ChromeDriver();
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void sendKey(By by,String value){
        driver.findElement(by).sendKeys(value);
    }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testinium_Chrome_Testi(){

        driver.navigate().to(url);

        click(By.className("btn")); // enterlıyoruz ve aramayı yapıyor

        thread(1000);

        sendKey(By.id("firstName"),"Neslisah");

        sendKey(By.id("lastName"),"Hayırlıoglu");

        sendKey(By.id("email"),"neslisahgamze@gmail.com");

        sendKey(By.id("password"),"1234");

        click(By.id("uploadPhotoButton"));

        String title = driver.getTitle();
        Assert.assertTrue("PAGE-2 Title içermiyor", title.contains("PAGE-2 Title"));

        driver.findElement(By.id("exampleSelect1")).sendKeys("4");


        click(By.id("uploadPhotoButton"));

        thread(100);

        String fN = driver.findElement(By.id("firstName")).getText();
        Assert.assertEquals(fN, "Neslisah");


    }



}
