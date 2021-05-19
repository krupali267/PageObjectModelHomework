package org.example;

import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SoftwarePage extends Utils{

    By itemBoxesField = By.className("item-box");
    By addToCartButtonField = By.cssSelector("button.button-2.product-box-add-to-cart-button");
    By productNameField = By.cssSelector("h2.product-title > a");

        public  void verifyAddtoCardButtonPresent(){

        // to find number of items
            List<WebElement> webElementList = driver.findElements(itemBoxesField);
            int count = 0, noofbutton = 0;

            for (WebElement element : webElementList){
                if(element.findElements(addToCartButtonField).size() == 1){
                    count++;
                }
                if (element.findElements(addToCartButtonField).size() != 1){
                    noofbutton++;
                    System.out.println(element.findElement(productNameField).getText()+ ">>>> No Add To Cart Button");
                }
            }
            Assert.assertEquals(count,webElementList.size(),"Add to cart button should be"+webElementList.size()+" but it is "+count+"\n");
            System.out.println("Add to cart button present in each product on this page");
        }


}
