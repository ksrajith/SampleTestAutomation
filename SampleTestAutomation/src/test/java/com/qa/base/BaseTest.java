package com.qa.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    BasePage pge = new BasePage();

    @BeforeSuite
    public void beforeSuite() {
        pge.initWebDriver();
    }

    @AfterSuite
    public void afterSuite() {
    pge.quitWebDriver();
    }
}
