package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils{

    public void clickOnSoftware()
    {
        // wait method for webdriver to wait before clicking
        waitForClickable(By.xpath("//ul[@class='sublist']/li[3]/a"),5000);
        // click on  Software sub-menu
        clickOnElement(By.xpath("//a[@href='/software']//img"));
    }
}
