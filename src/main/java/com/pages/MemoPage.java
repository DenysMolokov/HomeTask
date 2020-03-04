package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoPage extends BasePage {

    private String MemoPageUrl= "https://www.ss.com/lv/favorites/fDgTeF4S.html";

    @FindBy( xpath = "//div[@class=\"filter_second_line_dv\"]/a[1]")
    private WebElement memoTabLink ;

    @FindBy(xpath = "//div[@class=\"filter_second_line_dv\"]//a[@class=\"a9a\"]")
    private WebElement recentlyViewedTabLink ;

    @FindBy(xpath = "//form[@name=\"filter_frm\"]//table[@align=\"center\"]//tr[not(contains(@id,'head_line'))]")
    private List<WebElement> productInMemoLinks;

    @FindBy(xpath ="//span[@class=\"page_header_menu\"]//span//a")
    private WebElement memoPageLink;

    @FindBy(xpath = "//form[@name=\"filter_frm\"]//table[@align=\"center\"][2]//tr[not(contains(@id,'head_line'))]")
    private WebElement viewedTabProductLink ;

    @FindBy(xpath = "//form[@name=\"filter_frm\"]//table[@align=\"center\"][2]//tr[not(contains(@id,'head_line'))]//input")
    private WebElement viewedTabProductLinkCheckBox ;

    public MemoPage () {
        PageFactory.initElements(driver, this);
    }

    public WebElement getMemoPageLink (){
        return memoPageLink;
    }

    public String getMemoPageUrl(){
        return MemoPageUrl;
    }

    public WebElement getMemoTabLink(){
        return memoTabLink;
    }

    public WebElement getRecentlyViewedTabLink(){
        return recentlyViewedTabLink;
    }

    public List <WebElement> getProductInMemoLinks(){
        return productInMemoLinks;
    }

    public WebElement getViewedTabProductLink (){
        return viewedTabProductLink;
    }

    public WebElement getViewedTabProductLinkCheckBox (){
        return viewedTabProductLinkCheckBox;
    }

    public void compareTwoLists(List<WebElement> elements, List<String> productList) {
        //list with products Web elements
        List<WebElement> listOfElements = this.getProductInMemoLinks();
        System.out.println("amount of products that are in memo : " + listOfElements.size());
        System.out.println("amount of products that were added  : " + productList.size());
        //list with products converted in Strings
        List<String> listOfIds = new ArrayList<String>();
        for (int i = 0; i < listOfElements.size(); i++) {
            listOfIds.add(listOfElements.get(i).getAttribute("id"));
        }
        Collections.sort(productList);
        Collections.sort(listOfIds);
        System.out.println("id of products that are in memo:  " + listOfIds);
        System.out.println("id of products that were added :  " + productList);
        Assert.assertEquals(listOfIds, productList);
    }
}
