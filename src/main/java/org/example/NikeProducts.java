package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NikeProducts extends Utils{
public void nikeProductsDisplayed()
{
    // list of nike product displayed
    productList(By.xpath("(//h2 [@class='product-title'])"));

}

}
