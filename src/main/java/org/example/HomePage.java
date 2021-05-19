package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Utils {
    LoadProperty loadProperty = new LoadProperty();
    private By _waitOnRegister = By.linkText("Register");
    private By _clickOnRegister = By.linkText("Register");
    private By _selectCurrency = By.id("customerCurrency");
    private By _priceList = By.xpath("//span[@class='price actual-price']");
    private By _selectEuro = By.id("customerCurrency");
    private By _actualpricelist = By.xpath("//div[@class='item-box']//span[@class='price actual-price']");
    private By _clickoncomputer = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']");
    private By _clickonNewOnline = By.linkText("New online store is open!");
    private By _typeNike = By.xpath("//input[@class='search-box-text ui-autocomplete-input']");
    private By _clickonSearch = By.xpath("//button[@class='button-1 search-box-button']");

    public void clickOnRegisterButton()
    {
        // to wait before clicking on Register
        waitForClickable(_waitOnRegister,6000);

        //click on Register button
        clickOnElement(_clickOnRegister);
    }

    public String getCurrencySymbol(String currencyName){
        String currencySymbol = null;
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
        clickOnElement(_clickonNewOnline);
   }

}
