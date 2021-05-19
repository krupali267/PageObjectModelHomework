package org.example;

import org.openqa.selenium.By;

public class NewOnlinePage extends Utils{
    LoadProperty loadProperty = new LoadProperty();
    private By _waittoclick = By.xpath("//input[@class='enter-comment-title']");
    private By _enterTitle = By.xpath("//input[@class='enter-comment-title']");
    private By _entercomment = By.id("AddNewComment_CommentText");
    private By _newComment = By.xpath("//button[@name='add-comment']");

    public void leaveComment(){

        waitForClickable(_waittoclick,4000);
        // Type tile
        enterText(_enterTitle,loadProperty.getProperty("commenttitle"));
        // type comment
        enterText(_entercomment,loadProperty.getProperty("commentfield"));
       // click on new comment
        clickOnElement(_newComment);
    }
}
