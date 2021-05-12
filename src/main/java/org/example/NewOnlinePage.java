package org.example;

import org.openqa.selenium.By;

public class NewOnlinePage extends Utils{

    public void leaveComment(){

        waitForClickable(By.xpath("//input[@class='enter-comment-title']"),4000);
        // Type tile
        enterText(By.xpath("//input[@class='enter-comment-title']"),"Good Store");
        // type comment
        enterText(By.id("AddNewComment_CommentText"),"Like the products");
       // click on new comment
        clickOnElement(By.xpath("//button[@name='add-comment']"));
    }
}
