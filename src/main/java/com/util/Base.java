package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties properties;
    public static WebDriverWait waitDriver;
    public final static int IMPLICIT_TIMEOUT = 4;
    public final static int PAGE_LOAD_TIMEOUT = 8;

    public Base(){
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src//main//java//com//config//config.properties");
            properties.load(fis);
        }catch (IOException e){
            e.getMessage();
        }
    }

    public static void WebDriverInit(){
        System.setProperty("webdriver.chrome.driver","src//SeleniumDrivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseUrl"));
    }
}