package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    // object of each class
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    NikeProducts searchProductsDisplayed = new NikeProducts();
    ComputerPage computerPage = new ComputerPage();
    SoftwarePage softwarePage = new SoftwarePage();
    NewOnlinePage newOnlinePage = new NewOnlinePage();
    ResultVerificationPage resultVerificationPage = new ResultVerificationPage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){
        homePage.clickOnRegisterButton();
        registerPage.enterRegistertationDetails();

    }
    @Test
    public void userShouldBeAbleToChangeCurrency()
    {
    homePage.selectCurrency();
    resultVerificationPage.verifyCurrencyDisplayed();

    }
    @Test
    public void userShouldBeAbleToSearchProductsSuccessfully()
    {
    homePage.nikeProductsSearch();
    searchProductsDisplayed.nikeProductsDisplayed();
    resultVerificationPage.searchNikeProducts();
    }
    @Test
    public void userShouldBeAbleToSeeAddToCartButtonForAllProducts()
    {
    homePage.addToCartButton();
    computerPage.clickOnSoftware();
    softwarePage.clickOnSoftwareButton();

    }
    @Test
    public void userShouldBeAbleToAddAndSeeNewComments(){
        homePage.commentForNewOnlineStore();
        newOnlinePage.leaveComment();
        resultVerificationPage.verifyCommentAdded();
        resultVerificationPage.verifyCommentPresentInComments();
    }
}
