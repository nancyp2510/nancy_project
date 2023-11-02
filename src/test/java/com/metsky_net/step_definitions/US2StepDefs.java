package com.metsky_net.step_definitions;

import com.metsky_net.pages.BasePage;
import com.metsky_net.pages.FilesPage;
import com.metsky_net.pages.LoginPage;
import com.metsky_net.utilities.BrowserUtils;
import com.metsky_net.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class US2StepDefs extends BasePage {
    FilesPage filesPage = new FilesPage();

    @Given("User click on the {string} link and be on the files page")
    public void userClickOnTheLinkAndBeOnTheFilesPage(String moduleName) {
        clickMenuByText(moduleName);
    }

    @When("User clicks on the + icon")
    public void userClicksOnTheIcon() {
        filesPage.plusIcon.click();
    }

    @And("User clicks on {string} and choose file from their computer")
    public void userClicksOnAndChooseFileFromTheirComputer(String option) throws AWTException {
        filesPage.newFileOptionByText(option);

        String filePath = "C:\\Users\\nancy\\Downloads\\nancy_file1_plsNotDelete.jpg";

        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

/* if there is the upload button, can use this method, from Selenium doc
        Path path = Paths.get("C:\\Users\\nancy\\Downloads\\nancy_file1_plsNotDelete.jpg");
        File filePath = new File(path.toUri());
        filesPage.uploadFileOption.sendKeys(filePath.toString());
*/

    @Then("User should see the successful uploaded file displayed in Files page")
    public void userShouldSeeTheSuccessfulUploadedFileDisplayedInFilesPage() {
        Assert.assertTrue(filesPage.file_nancyFile1.isDisplayed());
    }


    @And("User clicks on {string}")
    public void userClicksOn(String option) {
        filesPage.newFileOptionByText(option);
    }

    @And("User clicks on the arrow icon")
    public void userClicksOnTheArrowIcon() {
        filesPage.newFolderArrowIcon.click();
    }

    @Then("User should see {string} folder displayed in Files page")
    public void userShouldSeeFolderDisplayedInFilesPage(String expectedFolderName) {
        BrowserUtils.waitForVisibility(filesPage.file_newFolderFile,15);

        String actualFolderName = filesPage.file_newFolderFile.getText();
        Assert.assertEquals("Folder name not matching!!!",expectedFolderName,actualFolderName);
    }


    @And("User clicks on the arrow icon and see the error message")
    public void userClicksOnTheArrowIconAndSeeTheErrorMessage() {
        filesPage.newFolderArrowIcon.click();
        //filesPage.newFolderAlreadyExistMessage.isDisplayed();
    }

    @And("User enters {string} as the new name and Enter")
    public void userEntersAsTheNewNameAndEnter(String newFolderName) {

        filesPage.newFolderNameInput.click();
        BrowserUtils.sleep(5);
        filesPage.newFolderNameInput.sendKeys(newFolderName + Keys.ENTER);
    }

    @Then("user should see the {string} folder displayed in Files page")
    public void userShouldSeeTheFolderDisplayedInFilesPage(String expectedFolderName) {
        BrowserUtils.waitForVisibility(filesPage.file_nancyFolderFile,15);

        String actualNewFolderName = filesPage.file_nancyFolderFile.getText();

        Assert.assertEquals("New folder name does not match!!!", expectedFolderName, actualNewFolderName);
    }


    @When("user hover to {string} folder")
    public void userHoverToFolder(String fileName) {
        filesPage.hoverToFileByText(fileName);
    }

    @When("User clicks on the three dots icon on New folder file")
    public void userClicksOnTheThreeDotsIconOnNewFolderFile() {
        BrowserUtils.sleep(5);
        filesPage.threeDots_file_newFolderFile.click();
    }

    @And("User clicks on Delete folder option")
    public void userClicksOnDeleteFolderOption() {
        filesPage.deleteFolderOption.click();
    }

    @When("user is on Delete files page")
    public void userIsOnDeleteFilesPage() {
        filesPage.deletedFilesModule.click();
    }

    @Then("User should see New folder in Delete files page")
    public void user_should_see_in_delete_files_page() {
        String actualFileName = filesPage.delete_newFolderFile.getText();

        Assert.assertEquals("Not right deleted file displayed!!! ","New folder",actualFileName);
    }


    @When("User scroll down to the end of the page")
    public void userScrollDownToTheEndOfThePage() {
        BrowserUtils.sleep(10);
        //BrowserUtils.waitForVisibility(filesPage.fileSummary, 15);

        BrowserUtils.scrollToElement(filesPage.folderSummary);
    }

    @Then("User should see the total number of files and folders")
    public void userShouldSeeTheTotalNumberOfFilesAndFolders() {
    Assert.assertTrue(filesPage.folderSummary.isDisplayed());
    Assert.assertTrue(filesPage.fileSummary.isDisplayed());

    }
}
