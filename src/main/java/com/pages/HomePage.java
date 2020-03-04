package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String homePageTitle = "Sludinājumi - SS.COM";
    private WebElement categoryLink;

    public HomePage(){
       categoryLink = driver.findElement(By.xpath("//*[@id=\"mtd_97\"]"));
    }

    public String getHomePageTitle(){
        return homePageTitle;
    }

    public WebElement getCategoryLink(){
        return categoryLink;
    }
}