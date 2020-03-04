package com.steps;

import com.pages.BasePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.pages.*;

public class AddAdFromProductListStep extends BasePage {

    ProductPage productPage = new ProductPage();
    MemoPage memoPage = new MemoPage();

    @Then("^User adds products from product list$")
    public void UserAddsProductsFromProductList() throws Exception {
        productPage.addToListMultiple(3);
        productPage.clickOnElement(productPage.getAddToMemoLink());
        productPage.closePopupWindow();
    }

    @When("^User gets to Memo page from Product Page")
    public void userGetsToMemoPage() throws InterruptedException {
        memoPage.clickOnElement(memoPage.getMemoPageLink());
        //Verify user is on Memo page
        memoPage.compareElements(
                memoPage.getMemoPageUrl(),
                memoPage.getPageUrlActual()
        );
    }

    @Then("^Verify ads are added from Product Page to Memo Page$")
    public void verifyAdIsAddedToMemoPage() {
        memoPage.compareTwoLists(
                memoPage.getProductInMemoLinks(),
                productPage.getListOfProducts()
        );
    }
}