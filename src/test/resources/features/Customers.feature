Feature: Customers Feature

  Background: Login successfully
    Given user has already entered to 'Dashboard' page

  @RegressionTest
  Scenario: Add new Customer
    Given user navigates to 'Customer list' page
    When click on Add new button
    And user is redirected to 'Add a new customer' page
    And fill customer information
    And click on Save button
    Then verify that user should see confirmation message "The new customer has been added successfully"

