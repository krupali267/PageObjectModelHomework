package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    // object of each class
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    NikeProducts nikeProducts = new NikeProducts();
    ComputerPage computerPage = new ComputerPage();
    SoftwarePage softwarePage = new SoftwarePage();
    NewOnlinePage newOnlinePage = new NewOnlinePage();
    ResultVerificationPage resultVerificationPage = new ResultVerificationPage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){
        homePage.clickOnRegisterButton();
        registerPage.enterRegisterationDetails();

    }
    @Test
    public void userShouldBeAbleToChangeCurrency()
    {
   homePage.verifyCurrencySymbolInEachPrice();
    homePage.changeCurrency();
    homePage.verifyCurrencySymbolInEachPrice();

    }
    @Test
    public void userShouldBeAbleToSearchProductsSuccessfully()
    {
    homePage.nikeProductsSearch();
    nikeProducts.nikeProductsDisplayed();

    }
    @Test
    public void userShouldBeAbleToSeeAddToCartButtonForAllProducts()
    {
    homePage.addToCartButton();
    computerPage.clickOnSoftware();
    softwarePage.verifyAddtoCardButtonPresent();

    }
    @Test
    public void userShouldBeAbleToAddAndSeeNewComments(){
        homePage.commentForNewOnlineStore();
        newOnlinePage.leaveComment();
        resultVerificationPage.verifyCommentAdded();
        resultVerificationPage.verifyCommentPresentInComments();
        resultVerificationPage.verifyComment();
    }
}
