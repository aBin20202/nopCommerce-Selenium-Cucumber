Feature: Login Feature
  This feature deals with the login functionality of the application

  @SmokeTest
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then verify that page title should be "Your store. Login"

  @SmokeTest
  Scenario Outline: Login Data Driven
    Given user is on login page
    And user enters Email as "<email>" and Password as "<password>"
    And click on Login button
    Then verify that page title should be "Dashboard / nopCommerce administration"
    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
