@Login
Feature: Automation Login
  @valid-Login
  Scenario: Login with valid username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Login button
    And user input username with "Beta123"
    And user input password with "123"
    And user click submit
    Then user redirect to home page with "Beta123" username displayed

  @invalid-Login
  Scenario: Login with invalid username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Login button
    And user input username with "adawqrsd"
    And user input password with "222"
    And user click submit
    Then show invalid login notification

  @invalid-Login
  Scenario: Login with empty username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Login button
    And user input username with ""
    And user input password with ""
    And user click submit
    Then show invalid login notification