package com.metsky_net.pages;

import com.metsky_net.utilities.BrowserUtils;
import com.metsky_net.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusIcon;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement newFolderArrowIcon;

    @FindBy(xpath = "//span[.='nancy_file1_plsNotDelete']")
    public WebElement file_nancyFile1;

    @FindBy(xpath = "//input[@value='New folder']")
    public WebElement newFolderNameInput;

    @FindBy(xpath = "//span[.='New folder']/span")
    public WebElement file_newFolderFile;

    @FindBy(xpath = "//span[.='NancyFolder']/span")
    public WebElement file_nancyFolderFile;

    @FindBy(xpath = "//span[.='New folder']/../following-sibling::span/a[2]")
    public WebElement threeDots_file_newFolderFile;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFolderOption;

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFilesModule;

    @FindBy(xpath = "//span[@title='New folder']")
    public WebElement delete_newFolderFile;

    @FindBy(xpath = "//span[@class='dirinfo']")
    public WebElement folderSummary;
    @FindBy(xpath = "//span[@class='fileinfo']")
    public WebElement fileSummary;


    //when user click on + icon to create new file, there is options pop up, below is the List of those option elements
    @FindBy(xpath = "//div[@class='newFileMenu popovermenu bubble menu open menu-left']//li//span[2]")
    public List<WebElement> newFileOptions;

    //when user click on + icon to create new file, there is options pop up, put in the text to choose which option
    public void newFileOptionByText(String option){
        for(WebElement eachOption : newFileOptions){
            if(option.equalsIgnoreCase(eachOption.getText())){
                eachOption.click();
                BrowserUtils.sleep(5);
            }
        }
    }

//this is the list all the files in the file page
    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> allFilesInFilesPage;

// below method is to hover to any file on the files page
    public void hoverToFileByText(String fileName){
       for(WebElement each : allFilesInFilesPage){
           if(fileName.equalsIgnoreCase(each.getText())){
               Actions actions = new Actions(Driver.getDriver());
               actions.moveToElement(each).perform();
           }
       }
    }



}
