Feature: automation Sign Up

  Scenario: Sign UP with valid username and password
    Given user is on homepage
    When user click Signup button
    And user input username with {sosososo}
    And user input password with {123123}
    And user click submit button
    Then user can login with registered account

  Scenario: Sign Up with empty username and password
    Given user is on homepage
    When user click Signup button
    And user input username with {sosososo}
    And user input password with {123123}
    And user click submit button
    Then user can login with registered account

