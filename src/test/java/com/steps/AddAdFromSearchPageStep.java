package com.steps;

import com.pages.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAdFromSearchPageStep extends BasePage {

    ProductPage productPage = new ProductPage();
    MemoPage memoPage = new MemoPage();
    SearchPage searchPage = new SearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Then("^User gets to Search page")
    public void userGetsToSearchPage() throws InterruptedException {
        searchPage.clickOnElement(searchPage.getSearchPageLink());
        Thread.sleep(2000);
        // VerifyUserIsOnSearchPage
        searchPage.compareContainsElements(
                searchPage.getPageUrlActual(),
                searchPage.getSearchPageUrl()
        );
    }

    @When("^User fills out searching forms")
    public void userFillsOutSearchingForms() throws InterruptedException {
        searchPage.fillSearchForm(
                searchPage.getSearchFieldLink(),
                searchPage.getInputText(),
                searchPage.getSelectValueYear(),
                searchPage.getSelectValueEngine(),
                searchPage.getSelectValueDealType()
        );
        searchPage.clickOnElement(searchPage.getFormSbmtButton());
    }

    @Then("^Verify user is on Search Result page$")
    public void VerifyUserIsOnSearchResultPage() {
        searchResultPage.compareContainsElements(
                searchResultPage.getPageUrlActual(),
                searchResultPage.getSearchResultPageUrl()
        );
    }

    @Then("^User adds products from list at Search Result Page$")
    public void UserAddsProductsFromProductList() throws Exception {
        searchResultPage.addToListMultiple(4);
        searchResultPage.clickOnElement(productPage.getAddToMemoLink());
        searchResultPage.closePopupWindow();
    }

    @When("^User gets to Memo page from Search Result Page")
    public void userGetsToMemoPage() throws InterruptedException {
        memoPage.clickOnElement(memoPage.getMemoPageLink());
        memoPage.clickOnElement(memoPage.getMemoTabLink());
        //Verify user is on Memo page
        memoPage.compareElements(
                memoPage.getMemoPageUrl(),
                memoPage.getPageUrlActual()
        );
    }

    @Then("^Verify ads are added from Search Result Page to Memo Page$")
    public void verifyAdIsAddedToMemoPage() {
        memoPage.compareTwoLists(
                memoPage.getProductInMemoLinks(),
                searchResultPage.getListOfProducts()
        );
    }
}
