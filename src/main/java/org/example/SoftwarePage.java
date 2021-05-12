package org.example;

import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.By;

public class SoftwarePage extends Utils{

    public void clickOnSoftwareButton(){
        // list of all products in Software
        productList(By.xpath("//h2[@class='product-title']"));
        waitForClickable(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"),5000);

        // condition to check all products has add to cart button
    if (getTextFromElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']")).contains("Add to cart"))
    {

    }
    else {
            System.out.println(getTextFromElement(By.xpath("//h2[@class='product-title']")).contains("No Cart Button"));
        }

}
}
