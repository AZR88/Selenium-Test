Feature: automation Sign Up

  Scenario: Sign Up with valid username and password
    Given user is on homepage
    When user click Login button
    And user input username with "Beta123"
    And user input password with "123"
    And user click submit
    Then user redirect to home page with "Beta123" username displayed

  Scenario: Sign Up with empty username and password
    Given user is on homepage
    When user click Login button
    And user input username with ""
    And user input password with ""
    And user click submit
    Then show invalid login notification