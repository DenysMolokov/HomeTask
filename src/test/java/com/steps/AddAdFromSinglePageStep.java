package com.steps;

import com.pages.*;
import com.pages.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAdFromSinglePageStep extends BasePage {

    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    ProductPage productPage = new ProductPage();
    SingleProductPage singleProductPage = new SingleProductPage();
    MemoPage memoPage = new MemoPage();

    String categoryName;
    String productName;
    String singleProductText;

    @Given("^User is on Home page$")
    public void VerifyUserIsOnHomePage(){
        homePage.compareElements(
                homePage.getHomePageTitle(),
                homePage.getPageTitleFromUrl()
        );
    }

    @Then("^User chooses category$")
    public void userChoosesCategory() throws InterruptedException {
        categoryName = homePage.getElementName(homePage.getCategoryLink());
        homePage.clickOnElement(homePage.getCategoryLink());
        //Verify user is on Category page
        categoryPage.compareElements(
                categoryPage.getElementName(categoryPage.getHeadtitleCategoryPageLink()),
                categoryName
        );
   }

    @Then("^User chooses product")
    public void userChoosesProduct() throws InterruptedException {
        productName = categoryPage.getElementName(categoryPage.getProductLink());
        categoryPage.clickOnElement(categoryPage.getProductLink());
        //Verify user is on Product page
        productPage.compareContainsElements(
                productPage.getElementName(productPage.getHeadtitleProductPage()),
                productName
        );
    }

    @Then("^User chooses single product$")
    public void userChoosesSingleProduct() throws Exception {
        productPage.addToListSingle(
                productPage.getSingleProductLink(),
                productPage.getSingleProductCheckBox()
        );
        singleProductText = productPage.getElementName(productPage.getSingleProductTextLink());
        productPage.clickOnElement(productPage.getSingleProductLink());
        //Verify user is on SingleProduct page
        singleProductPage.compareContainsElements(
                singleProductText,
                singleProductPage.getSingleProductPageText()
        );
    }

    @Then("^User adds single product to memo$")
    public void userAddsSingleProductToMemo() throws Exception {
        singleProductPage.clickOnElement(singleProductPage.getAddToMemoLink());
        singleProductPage.closePopupWindow();
    }

    @When("^User gets to Memo page")
    public void userGetsToMemoPage() throws InterruptedException {
        memoPage.clickOnElement(memoPage.getMemoPageLink());
        //Verify user is on Memo page
        memoPage.compareElements(
                memoPage.getMemoPageUrl(),
                memoPage.getPageUrlActual()
        );
    }

    @Then("^Verify ad is added to Memo Page$")
    public void verifyAdIsAddedToMemoPage() {
        memoPage.compareTwoLists(
                memoPage.getProductInMemoLinks(),
                productPage.getListOfProducts()
        );
    }
}