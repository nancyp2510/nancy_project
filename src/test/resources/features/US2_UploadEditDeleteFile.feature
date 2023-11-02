@wip
Feature: Upload/Edit/Delete File Module features
  User Story :
  As a user, I should be able to upload a file, move or delete any selected file under the Files module

  Background: User is already in the log in page
    Given the user is on the login page
    Given the user logged in with username and password
    Given User click on the "Files" link and be on the files page


  Scenario: Upload file verification

    #Given User is on the "Files" page
    When User clicks on the + icon
    And User clicks on "Upload file" and choose file from their computer
    Then User should see the successful uploaded file displayed in Files page

  Scenario: Create an folder verification

    #Given User is on the "Files" page
    When User clicks on the + icon
    And User clicks on "New folder"
    And User clicks on the arrow icon
    Then User should see "New folder" folder displayed in Files page

    #Pre-condition: New folder file is exist
  Scenario: Create an folder that name is already exist verification

    When User clicks on the + icon
    And User clicks on "New folder"
    And User clicks on the arrow icon and see the error message
    And User enters "NancyFolder" as the new name and Enter
    Then user should see the "NancyFolder" folder displayed in Files page

 # Pre-condition: there are at least 3 files in Files module
  Scenario: Delete any selected item verification

    When user hover to "New folder" folder
    When User clicks on the three dots icon on New folder file
    And User clicks on Delete folder option
    When user is on Delete files page
    Then User should see New folder in Delete files page

  Scenario: total number of files and folders under the files list table verification

    When User scroll down to the end of the page
    Then User should see the total number of files and folders