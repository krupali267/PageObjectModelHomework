package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Utils extends BasePage {

    // method for Webdriver wait
    public static void waitForClickable(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // method to select from drop down by value
    public static void selectFromDropDownByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }
    // method to select from drop down by index
    public static void selectFromDropDownByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);

    }
    // method to select from drop down by visibletext
    public static void selectFromDropdownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    // webelement list method
    public static void productList(By by){

    List<WebElement> list = driver.findElements(by);
    for(WebElement element:list)
    {
        System.out.println(element.getText());
    }
 }
    // method to get text
    public static String getTextFromElement(By by){
       return driver.findElement(by).getText();
    }
    // method to enter text
    public static void enterText(By by, String text){
        driver.findElement(by).sendKeys(text);

    }
    //method to click on element
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

}
