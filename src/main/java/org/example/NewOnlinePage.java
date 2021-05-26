package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewOnlinePage extends Utils{
    LoadProperty loadProperty = new LoadProperty();

    //news online store locators
    private By _waittoclick = By.cssSelector("input.enter-comment-title");
    private By _commentTitle = By.cssSelector("input.enter-comment-title");
    private By _commentTextBox = By.cssSelector("textarea#AddNewComment_CommentText");
    private By _newCommentButton = By.xpath("//button[contains(@class,'button-1 news-item-add-comment-button')]");
    private  By _commentsBox = By.xpath("//div[contains(@class,'comments')]");
    private By _commentSuccessMessage = By.cssSelector("div.notifications");
    private By _totalComments = By.xpath("//div[contains(@class, 'comment news-comment')]");


    //test data used
    String commentTitle = loadProperty.getProperty("commenttitle") + dateStamp();
    String commentText = loadProperty.getProperty("commentfield") + dateStamp();

    public void fillCommentDetails(){

     //   waitForClickable(_newCommentButton,500);
        // Type tile
        enterText(_commentTitle,commentTitle);
        // type comment text
        enterText(_commentTextBox,commentText);
        // click on new comment button
        clickOnElement(_newCommentButton);
    }

    public void verifyCommentAddedSuccessMessage()
    {
        // verify Comment Added Success Message
        Assert.assertEquals(getTextFromElement(_commentSuccessMessage), "News comment is successfully added.", "Comment added success message wrong or not displayed");
        System.out.println("News comment is successfully added");
    }

    public void verifyCommentPresentInCommentList()
    {
        //verify Comment Present In Comment List
        Assert.assertTrue(getTextFromElement(_commentsBox).contains(commentText), "Recently added comment is not present in comment list");
        System.out.println("Comment is present in comment list");
    }

    public void verifyCommentsAddedAtLastInTheList()
    {
        //finding total comments
        List<WebElement> commentList = driver.findElements(_totalComments);

        //total comments
        int numberOfComments = commentList.size();

        //finding last comment index
        int lastCommentIndex = numberOfComments-1;

        //get text of whole last comment
        String lastCommentActualText = commentList.get(lastCommentIndex).getText();

        //verifying last comments contains text of added comment
        Assert.assertTrue(lastCommentActualText.contains(commentText),"Added comment is NOT at last in comment list");
        System.out.println("Added comment is at last in comment list");
    }

}
