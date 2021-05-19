package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils{
private By _waitforclick = By.xpath("//ul[@class='sublist']/li[3]/a");
private By _clickonsoftware = By.xpath("//a[@href='/software']//img");
    public void clickOnSoftware()
    {
        // wait method for webdriver to wait before clicking
        waitForClickable(_waitforclick,5000);
        // click on  Software sub-menu
        clickOnElement(_clickonsoftware);
    }
}
