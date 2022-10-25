Feature: To check the login functionality

  
  Scenario: Login
    Given User is the login screen
    When User enters the login credentials
    And User clicks Enter
    Then User navigated to homepage

  Scenario: Login 1
    Given User is the login screen
    When User enters the login credentials
    And User clicks Enter
    Then User navigated to homepage
