package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils {
    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod

   public void openBrowser(){
        browserSelector.openBrowser();

        // open url
        driver.get("https://demo.nopcommerce.com/");
    }


    @AfterMethod
    public void closeBrowser(){

        // close the browser
          driver.quit();


    }



}
