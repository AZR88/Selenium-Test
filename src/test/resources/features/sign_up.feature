@SignUp
Feature: automation Sign Up

  @valid-SignUp
  Scenario: Sign UP with valid username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Signup button
    And user input username  with "sosososo"
    And user input password  with "123123"
    And user click submit button
    Then show account succes created alert

  @invalid-SignUp
  Scenario: Sign Up with empty username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Signup button
    And user input username  with ""
    And user input password  with ""
    And user click submit button
    Then show invalid SignUP notification

  @invalid-SignUp
  Scenario: Sign Up with registered username and password
    Given user is on homepage "https://www.demoblaze.com/"
    When user click Signup button
    And user input username  with "Beta123"
    And user input password  with "123"
    And user click submit button
    Then show invalid SignUP notification


