package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    private String hmeDiv = "//h5[text()='Widgets']";

    public boolean isWidgetClicked(){
        return isClick(By.xpath(hmeDiv));
    }

}
