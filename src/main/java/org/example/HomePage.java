package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {
    public void clickOnRegisterButton()
    {
        // to wait before clicking on Register
        waitForClickable(By.linkText("Register"),6000);

        //click on Register button
        clickOnElement(By.linkText("Register"));

    }

    public void selectCurrency(){

        // to select Euro currency
       selectFromDropdownByVisibleText(By.id("customerCurrency"),"Euro");
        // price of all featured products
        productList(By.xpath("(//span[@class='price actual-price'])"));

    }

    public void nikeProductsSearch()
    {
        // type Nike in Search option
        enterText(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"),"Nike");
        // click on search button
        clickOnElement(By.xpath("//button[@class='button-1 search-box-button']"));

    }
    public void addToCartButton()
{
        // click on Computer menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
}

   public void commentForNewOnlineStore()
   {
        // click on New online store
        clickOnElement(By.linkText("New online store is open!"));

   }

}
