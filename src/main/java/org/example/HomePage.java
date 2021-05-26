package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {
    LoadProperty loadProperty = new LoadProperty();
    private By _waitOnRegister = By.xpath("//a[contains(@class, 'ico-register')]");
    private By _clickOnRegister = By.xpath("//a[contains(@class, 'ico-register')]");
    private By _selectCurrency = By.xpath("//select[contains(@id,'customerCurrency')]");
    private By _priceList = By.xpath("//span[@class='price actual-price']");
    private By _selectEuro = By.xpath("//select[contains(@id,'customerCurrency')]");
    private By _actualpricelist = By.xpath("//span[contains(@class, 'price actual-price')]");
    private By _clickoncomputer = By.xpath("//a[contains(@href,'/computers')]");
    private By _clickonNewOnline = By.cssSelector("a.news-title:first-of-type");
    private By _typeNike = By.xpath("//input[starts-with(@class, 'search-box-text ui-autocomplete-input')]");
    private By _clickonSearch = By.cssSelector("button.button-1.search-box-button");
    private By _facebookLink = By.xpath("//a[contains(@href, 'http://www.facebook.com/nopCommerce')]");
    private By _loginButtonOnFacebook = By.cssSelector("label#loginbutton");


    public void clickOnRegisterButton()
    {
        // to wait before clicking on Register
        waitForClickable(_waitOnRegister,60);

        //click on Register button
        clickOnElement(_clickOnRegister);
    }

    public String getCurrencySymbol(String currencyName){
        String currencySymbol = null;
        // applying condition
        switch (currencyName){
            case "US Dollar":
            currencySymbol = "$";
            break;
            case "Euro":
                currencySymbol= "€";
                break;
            default:
                System.out.println("Currency is not available");
        }
        return currencySymbol;
    }
    public void verifyCurrencySymbolInEachPrice(){
        String currencyNameSelected = getSelectedTextFromDropDown(_selectCurrency);
        String expectedCurrencySymbol = getCurrencySymbol(currencyNameSelected);
        List<WebElement> pricelist = driver.findElements(_priceList);

        for (WebElement element : pricelist){
            String priceSymbolActual = element.getText().substring(0,1);
            Assert.assertEquals(priceSymbolActual,expectedCurrencySymbol);
        }
        System.out.println("currency Verified successfully :" + currencyNameSelected+ " as "+expectedCurrencySymbol);
    }

    public void changeCurrency(){
        //select Euro currency
        selectFromDropdownByVisibleText(_selectEuro, loadProperty.getProperty("selectcurrency"));
        productList(_actualpricelist);
    }

    public void nikeProductsSearch()
    {
        // type Nike in Search option
        enterText(_typeNike, loadProperty.getProperty("searchword"));
        // click on search button
        clickOnElement(_clickonSearch);

    }
    public void addToCartButton()
{
        // click on Computer menu
        clickOnElement(_clickoncomputer);
}
   public void commentForNewOnlineStore()
   {
        // click on New online store
       waitForClickable(_clickonNewOnline,50);
        clickOnElement(_clickonNewOnline);
   }

   public void clickOnSearchAlert (){

        // click on search button
        clickOnElement(_clickonSearch);
        // switch to alert window
        Alert alert = driver.switchTo().alert();
        // get text displayed on alert window
        String alertmessage = alert.getText();
       System.out.println(alertmessage);
       // to dismiss the alert
       alert.dismiss();

       // to verify alert message is present
       Assert.assertEquals(loadProperty.getProperty("expectedalertmessage"),alertmessage,"alert message doesn't have text");
       System.out.println("Alert message text is as per requirement");
   }
   public void facebookWindowHandling (){

    // Main Window
       String MainWindow = driver.getWindowHandle();

   // To handle all new opened window
       Set<String> s1 = driver.getWindowHandles();
       Iterator<String> i1 =s1.iterator();

    // condition application
       while(i1.hasNext())
       {
           String ChildWindow=i1.next();
           if(!MainWindow.equalsIgnoreCase(ChildWindow))
           {
               // Switching to Child window
               driver.switchTo().window(ChildWindow);
               //verify login button is present

             Assert.assertTrue(driver.findElement(_loginButtonOnFacebook).isDisplayed(),"Login button is not present");
               System.out.println("Login button is present");

               // Closing the Child Window.
            driver.close();
           }
       }
       // Switching to Parent window i.e Main Window.
       driver.switchTo().window(MainWindow);
   }
}


