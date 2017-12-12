package com.sahabt;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SahibindenTest {

    WebDriver driver;
    Login login=new Login();

    public WebElement find(By by){
        return driver.findElement(by);
    }

    @Test
    public void falseEmailTest(){

        login.setup();
        login.click(By.cssSelector(".login-text [rel]"));
        login.click(By.cssSelector(".qr-login-promotion .close"));
        login.login("neslisah","1234");
        login.click(By.cssSelector(".user-info-campaign-dialog [ng-hide]"));


        String title = login.getTitle();
        Assert.assertTrue("Login failed",title.contains("Bana özel özet"));
        System.out.println("Login successful");



    }
    @Test
    public void searchTest(){
        login.setup();
        login.sendKey(By.id("searchText"),"Ford");
        login.submit(By.id("searchText"));
        login.click(By.cssSelector("[class] li:nth-of-type(1) [data-category=\"3517\"]"));
        login.sendKey(By.cssSelector("#searchResultLeft-price div [type=\"text\"]:nth-of-type(1)"),"200");
        login.sendKey(By.cssSelector("#searchResultLeft-price div [type=\"text\"]:nth-child(3)"),"50.000");
        login.click(By.linkText("Benzin"));
        login.click(By.cssSelector("#closeCookiePolicy"));
        login.click(By.cssSelector("#searchResultLeft-price .js-manual-search-button"));
        login.click(By.cssSelector(".search-submit"));
        login.click(By.cssSelector("thead [href=\"\\/otomobil\\?sorting\\=yil-nu_asc\\&query_text\\=ford\"]"));


        //WebElement element = click(By.id("#advancedSorting"));

        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public WebElement click(By by) {
        driver.findElement(by).click();
        return null;
    }

}
