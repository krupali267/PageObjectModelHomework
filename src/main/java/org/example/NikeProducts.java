package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.WeakHashMap;

public class NikeProducts extends Utils{

    private By _itemBoxes = By.className("item-box");
    private By _productNames = By.cssSelector("h2.product-title");

    public void nikeProductsDisplayed()
{

    //to find number of items
    List<WebElement> webElementList = driver.findElements(_itemBoxes);
    int count = 0;
    // list of items
    for(WebElement element : webElementList){
        if(element.findElement(_productNames).getText().contains("Nike")){
            // to print product title when above condition becomes true
            System.out.println(element.findElement((_productNames)).getText());
            // to count all product titles
            count++;
        }
        else {
            // when product title doesn't contain Nike
            System.out.println("It is not Nike product");
        }
        // to verify all products have Nike in title
        Assert.assertEquals(count,webElementList.size(), "Nike must be present in "+webElementList.size()+" but is present in "+ count+ "\n");
        System.out.println("All products displayed are with Nike product title");
    }

}

}
