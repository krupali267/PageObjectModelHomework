package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends BasePage{
    LoadProperty loadProperty = new LoadProperty();
    String browserName = loadProperty.getProperty("browser");

    public void openBrowser(){

        if(browserName.equalsIgnoreCase(loadProperty.getProperty("browser"))){
            System.setProperty("webdriver.edge.driver","src/test/resources/BrowserDriver/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase(loadProperty.getProperty("browser"))){
            System.setProperty("webdriver.chrome.driver","src/test/resources/BrowserDriver/chromedriver.exe");
            // initialzing the object
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase(loadProperty.getProperty("browser"))){

            System.setProperty("webdriver.gecko.driver","src/test/resources/BrowserDriver/geckodriver.exe");
            //initializing the object
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Incorrect browser name....." +browserName);

        }

        // maximize the browser window
        driver.manage().window().maximize();
        // applying implicity wait to driver object
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

}
}
