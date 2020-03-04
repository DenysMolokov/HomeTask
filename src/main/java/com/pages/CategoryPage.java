package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//h2[@class=\"headtitle\"]/a")
    private WebElement headtitleCategoryPageLink;

    @FindBy(xpath = "//*[@id=\"ahc_99\"]")
    private WebElement productLink;

    public CategoryPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeadtitleCategoryPageLink(){
        return headtitleCategoryPageLink;
    }

    public WebElement getProductLink(){
        return productLink;
    }
}