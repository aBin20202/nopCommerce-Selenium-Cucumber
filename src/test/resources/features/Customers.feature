Feature: Customers Feature

  Background: Login successfully
    Given user has already logged in to the application

  Scenario: Add new Customer
    Given user is on Dashboard page
    When user clicks on Customers Menu
    And click on Customers Menu Item
    And click on Add new button
    Then user can view Add a new customer page
    When user enters customer info
    And click on Save button
    Then user can view confirmation message "The new customer has been added successfully"