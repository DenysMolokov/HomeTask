package com.steps;

import com.util.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksStep extends Base {

    @Before
    public void setUp(){
        Base.WebDriverInit();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}