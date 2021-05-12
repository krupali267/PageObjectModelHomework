package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils {

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\Browser\\chromedriver.exe");
        // initialzing the object
        driver = new ChromeDriver();
        // maximize the browser window
        driver.manage().window().maximize();
        // applying implicity wait to driver object
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        // open url
        driver.get("https://demo.nopcommerce.com/");

    }
    @AfterMethod
    public void closeBrowser(){

        // close the browser
        //  driver.quit();


    }



}
