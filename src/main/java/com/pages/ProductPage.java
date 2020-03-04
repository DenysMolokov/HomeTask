package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h2[@class=\"headtitle\"]")
    private WebElement headtitleProductPage;

    @FindBy(xpath = "//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][2]")
    private WebElement singleProductLink;

    @FindBy(xpath = "//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][6]")
    private WebElement singleProductLinkOneMoreTime;

    @FindBy(xpath = "//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][2]//div[@class=\"d1\"]")
    private WebElement singleProductText;

    @FindBy(xpath = "//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][2]//input")
    private WebElement singleProductCheckBox;

    @FindBy(xpath = "//a[@id=\"a_fav_sel\"]")
    private WebElement addToMemoLink;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeadtitleProductPage(){
        return headtitleProductPage;
    }

    public WebElement getSingleProductLink(){
        return singleProductLink;
    }

    public WebElement getSingleProductLinkOneMoreTime(){
        return singleProductLinkOneMoreTime;
    }

    public WebElement getSingleProductTextLink(){
        return singleProductText;
    }

    public WebElement getSingleProductCheckBox(){
        return singleProductCheckBox;
    }

    public WebElement getAddToMemoLink (){
        return addToMemoLink;
    }
}