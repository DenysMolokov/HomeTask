package com.pages;

import com.util.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends Base {

    private String okWindowXpath = "//a[@id=\"alert_ok\"]";
    private ArrayList<String> listOfAddedProducts = new ArrayList<>();

    public void clickOnElement (WebElement elementToClick) throws InterruptedException {
        try {
            waitDriver = new WebDriverWait(driver,IMPLICIT_TIMEOUT);
            waitDriver.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
            System.out.println("WebElement: " + "<" + elementToClick.toString() + ">" + " was clicked");
        } catch (Exception e) {
            System.out.println("incorrect locator of WebElement : " + e);
        }
    }

    public void compareElements (String act, String exp){
        Assert.assertEquals(act, exp);
        System.out.println("Expected : " + act);
        System.out.println("Actual : " + exp);
    }

    public void compareContainsElements (String act, String exp){
        Assert.assertTrue(act.contains(exp));
        System.out.println("Expected : " + act);
        System.out.println("Actual : " + exp);
    }

    public String getPageTitleFromUrl(){
        return driver.getTitle();
    }

    public String getElementName (WebElement elementName){
        return elementName.getText();
    }

    public String getElementId (WebElement elementId) {
        return elementId.getAttribute("id");
    }

    public String getPageUrlActual(){
        return driver.getCurrentUrl();
    }

    public List<String> getListOfProducts(){
        return listOfAddedProducts;
    }

    public void addToListSingle (WebElement product, WebElement checkBoxElement) throws Exception {
        String productId = this.getElementId(product);
        listOfAddedProducts.add(productId);
        this.clickOnElement(checkBoxElement);
    }

    // count - number of products we want to add at a time
    public void addToListMultiple (int count) throws Exception {
        int j=3;
        for(int i = 0; i<count; i++) {
            WebElement product = driver.findElement(By.xpath("//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][" + j + "]"));
            String productId = product.getAttribute("id");
            listOfAddedProducts.add(productId);
            WebElement checkBoxElement = driver.findElement(By.xpath("//table[@align=\"center\"]//tr[not(contains(@id,'head_line')) and not(contains(@id,'tr_bnr_712'))][" + j + "]//input"));
            this.clickOnElement(checkBoxElement);
            j++;
        }
    }

    public void closePopupWindow()throws Exception {
        this.clickOnElement(driver.findElement(By.xpath(okWindowXpath)));
    }
}
