package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleProductPage extends BasePage {

    @FindBy(xpath = "//div[@id=\"msg_div_msg\"]")
    private WebElement singleProductPageText;

    @FindBy(xpath = "//a[@id=\"a_fav\"]")
    private WebElement addToMemoLink;

    @FindBy(xpath = "//span[@class=\"td7\"]//a[@class=\"a9a\"]")
    private WebElement backToProductListLink;

    public SingleProductPage() {
        PageFactory.initElements(driver, this);
    }

    public String getSingleProductPageText (){
          return singleProductPageText.getText().replaceAll("\n"," ").substring(0,25);
    }

    public WebElement getAddToMemoLink (){
        return addToMemoLink;
    }

    public WebElement getBackToProductListLink (){
        return backToProductListLink;
    }

}
