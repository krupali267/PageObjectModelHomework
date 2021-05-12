package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ResultVerificationPage extends Utils {

    public void verifyRegisterMessage(){
        // verify user has registered successfully
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration is completed","Registration Not Successful");
        System.out.println("Your registration completed");
    }

    public void verifyCurrencyDisplayed(){
        // verify price of all featured products displayed in Euro
        boolean currencyIsDisplayed = driver.findElement(By.xpath("(//span [@ class='price actual-price'])")).isDisplayed();
        Assert.assertTrue(currencyIsDisplayed,"Price is not printed in Euro");
        System.out.println("Price is printed in Euro");

    }
    public void searchNikeProducts(){
        // verify all products displayed are Nike
        boolean nikeProductDisplayed = driver.findElement(By.xpath("(//h2 [@class='product-title'])")).isDisplayed();
        Assert.assertTrue(nikeProductDisplayed,"Nike products are not displayed");
        System.out.println("Nike Products are displayed");

    }

    public void verifyCommentAdded(){
        // verify comment is added
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"News comment is successfully added.","Comment is not added");
        System.out.println("News comment is successfully added");
    }

    public void verifyCommentPresentInComments(){
        // verify comment is displayed in Comments
        boolean commentDisplayed = driver.findElement(By.xpath("//div[@class='comment-content']")).isDisplayed();
        Assert.assertTrue(commentDisplayed,"Comments are not displayed");
        System.out.println("Comments are displayed");

        // verify most recent comment is displayed
        boolean commentDisplayedAtEnd = driver.findElement(By.xpath("//span[@class='stat-value']")).isDisplayed();
        Assert.assertTrue(commentDisplayedAtEnd,"Comment not displayed at end");
        System.out.println("Recent Comment Displayed");

    }
}
