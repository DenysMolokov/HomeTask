package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

    private String searchPageUrl = "/search/";
    private String inputText = "Alfa romeo";

    @FindBy(id = "ptxt")
    private WebElement searchFieldLink ;

    @FindBy(xpath = "//select[@name=\"topt[18][max]\"]")
    private WebElement selectValueYear;

    @FindBy(xpath = "//select[@name=\"opt[34][]\"]")
    private WebElement selectValueEngine;

    @FindBy(xpath = "//select[@name=\"sid\"]")
    private WebElement selectValueDealType;

    @FindBy(xpath = "//input[@id=\"sbtn\"]")
    private WebElement formSbmtButton;

    @FindBy(xpath ="//span[@class=\"page_header_menu\"]//b[3]//a")
    private WebElement searchPageLink;

    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchPageLink (){
        return searchPageLink;
    }

    public String getSearchPageUrl(){
        return searchPageUrl;
    }

    public WebElement getSearchFieldLink(){
        return searchFieldLink;
    }

    public String getInputText(){
        return inputText;
    }

    public WebElement getSelectValueYear(){
        return selectValueYear;
    }

    public WebElement getSelectValueEngine(){
        return selectValueEngine;
    }

    public WebElement getSelectValueDealType(){
        return selectValueDealType;
    }

    public WebElement getFormSbmtButton(){
        return formSbmtButton;
    }

    public void fillSearchForm (WebElement searchFieldLink,
                            String inputText,
                            WebElement year,
                            WebElement engine,
                            WebElement dealType
    ) throws InterruptedException {
        searchFieldLink.clear();
        searchFieldLink.sendKeys(inputText);
        searchFieldLink.click();
        Thread.sleep(2000);
        Select sectionOption = new Select(year);
        sectionOption.selectByValue("2017");
        Select categoryOption = new Select(engine);
        categoryOption.selectByValue("493");
        Select dealTypeOption = new Select(dealType);
        dealTypeOption.selectByValue("1");
    }
}