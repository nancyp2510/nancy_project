package com.metsky_net.pages;

import com.metsky_net.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li/a")
    public List<WebElement> menuOptions;

    public void clickMenuByText(String text){
        try {
            for (WebElement module : menuOptions) {
                if (module.getAttribute("aria-label").equalsIgnoreCase(text)) {
                    module.click();
                }
            }
        }catch(Exception e){
            System.err.println("No such element found with text: " + text);
            e.printStackTrace();
        }
    }






}
