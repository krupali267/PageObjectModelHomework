package org.example;

import org.openqa.selenium.By;

public class ComputerPage extends Utils
{
        private By _waitforclick = By.xpath("//a[contains(@href,'/computers')]");
        private By _waitSoftwareclick = By.cssSelector(".active.last .sublist .inactive:nth-of-type(3)>a");
        private By _clickonsoftware = By.xpath("//a[contains(@href,'/software')]");

    public void clickOnSoftware()
    {
        // wait method for webdriver to wait before clicking
       // waitForClickable(_waitforclick,5000);
       waitForClickable(_clickonsoftware,100);
        // click on  Software sub-menu
        clickOnElement(_clickonsoftware);
    }
}
