package com.steps;

import com.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAdFromRecentlyViewedStep extends BasePage {

    ProductPage productPage = new ProductPage();
    SingleProductPage singleProductPage = new SingleProductPage();
    MemoPage memoPage = new MemoPage();

    @Then("^User adds two products from product list$")
    public void UserAddsProductsFromProductList() throws Exception {
        productPage.addToListMultiple(2);
        productPage.clickOnElement(productPage.getAddToMemoLink());
        productPage.closePopupWindow();
        Thread.sleep(2000);
    }

    @Then("^User views single products$")
    public void userViewsSingleProducts() throws Exception {
        productPage.clickOnElement(productPage.getSingleProductLink());
        singleProductPage.clickOnElement(singleProductPage.getBackToProductListLink());
        productPage.clickOnElement(productPage.getSingleProductLinkOneMoreTime());
        Thread.sleep(2000);
    }

    @When("^User gets to Recently Viewed Tab on Memo Page")
    public void userGetsToMemoPage() throws InterruptedException {
        memoPage.clickOnElement(memoPage.getMemoPageLink());
        memoPage.clickOnElement(memoPage.getMemoTabLink());
        //Verify user is on Memo page
        memoPage.compareElements(
                memoPage.getMemoPageUrl(),
                memoPage.getPageUrlActual()
        );
    }

    @Then("^User adds product from Recently Viewed Tab$")
    public void UserAddsProductsFromRecentlyViewedTab () throws Exception {
        if (productPage.getListOfProducts() != null && !productPage.getListOfProducts().isEmpty()){
            memoPage.clickOnElement(memoPage.getRecentlyViewedTabLink());
        }
        productPage.addToListSingle(
                memoPage.getViewedTabProductLink(),
                memoPage.getViewedTabProductLinkCheckBox()
        );
        productPage.clickOnElement(productPage.getAddToMemoLink());
        productPage.closePopupWindow();
    }

    @Then("^Verify ad is added from Recently Viewed Tab to Memo Page$")
    public void verifyAdIsAddedToMemoPage() throws InterruptedException {
        memoPage.clickOnElement(memoPage.getMemoTabLink());
        memoPage.compareTwoLists(
                memoPage.getProductInMemoLinks(),
                productPage.getListOfProducts()
        );
    }
}
