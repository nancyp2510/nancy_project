package com.metsky_net.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Metsky_basePage_forMe {
     /*
    //when user click on three dots ... icon, there is options pop up, put in the text to choose which option
    @FindBy(xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//a")
    public List<WebElement> threeDotsOptions;

    //when user three dots ... icon, there is options pop up, put in the text is the VALUE OF ATTRIBUTE: data-action to choose which option
    public void threeDotsOptionByText(String option){
        for(WebElement eachOption : newFileOptions){
            if(option.equalsIgnoreCase(eachOption.getAttribute("data-action"))){
                eachOption.click();
            }
        }
    }
*/
   /* @FindBy()
    public WebElement ; */

    /*
    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderOption;
*/
    @FindBy(xpath = "//label[@data-action='upload']")
    public WebElement uploadFileOption;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement newFolderAlreadyExistMessage;
    @FindBy(xpath = "//span[.='nancy_file1_plsNotDelete']/../following-sibling::span/a[2]")
    public WebElement threeDots_file_nancyfile1File;


    //@FindBy(xpath = "(//span[@class='icon icon-more'])[2]")
    @FindBy(xpath = "//span[.='nancy_file2_plsNotDelete']/../following-sibling::span/a[2]")
    public WebElement threeDots_file_nancyfile2File;


    @FindBy(xpath = "//span[@title='nancy_file1_plsNotDelete.jpg']")
    public WebElement delete_nancyfile1File;

    @FindBy(xpath = "//span[@title='nancy_file2_plsNotDelete.txt']")
    public WebElement delete_nancyfile2File;

}
