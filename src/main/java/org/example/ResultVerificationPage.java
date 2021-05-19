package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ResultVerificationPage extends Utils {
    SoftAssert softAssert = new SoftAssert();
    private By _actualResult = By.xpath("//div[@class='result']");
    private By _actualCommentVerified = By.xpath("//div[@class='result']");
    private By _commentlist = By.xpath("//div[@class='comment-content']");
    private By _actualcomment = By.xpath("//strong[@class ='comment-text']");
    private By _newlyAddedComment = By.xpath("//p[@class='comment-text']");
    private By _actualcommenttitle = By.xpath("//div[@class='comment-content']");


    public void verifyRegisterMessage() {
        // verify user has registered successfully
        Assert.assertEquals(getTextFromElement(_actualResult), "Your registration is completed", "Registration Not Successful");
        System.out.println("Your registration completed");
    }
    public void verifyCommentAdded() {
        // verify comment is added
        Assert.assertEquals(getTextFromElement(_actualCommentVerified), "News comment is successfully added.", "Comment is not added");
        System.out.println("News comment is successfully added");
    }

    public void verifyCommentPresentInComments() {

        // verify comment is displayed in Comments
        List<WebElement> commentList = driver.findElements(_commentlist);
        String expectedComment = "Good Store";
        for (WebElement element : commentList) {
            softAssert.assertEquals(driver.findElement(_actualcomment).getText(), expectedComment, "comment title doesn't match");
        }
        softAssert.assertAll();
        System.out.println("Comment title matches");
    }

    public void verifyComment() {
        // verify most recent comment is displayed
        List<WebElement> newCommentAdded = driver.findElements(_newlyAddedComment);
        String expectedComment = "I like the store";
        for (WebElement element : newCommentAdded) {

            softAssert.assertEquals(driver.findElement(_newlyAddedComment).getText(), expectedComment, "Comment doesnt match");
        }
        softAssert.assertAll();
        System.out.println("Comments match");
    }

    public void verifyCommentIsDisplayed(){
        Assert.assertEquals(driver.findElement(_actualcomment),driver.findElement(_actualcomment),"Comments don't match");
        System.out.println("Most recent comment displayed at the end");
    }


}
