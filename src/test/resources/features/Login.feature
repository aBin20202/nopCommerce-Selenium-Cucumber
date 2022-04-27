Feature: Login Feature
  This feature deals with the login functionality of the application

  Scenario Outline: Login Data Driven
    Given user navigates to login page
    And user enters Email as "<email>" and Password as "<password>"
    And click on Login button
    Then Page Title should be "Dashboard / nopCommerce administration"

    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
