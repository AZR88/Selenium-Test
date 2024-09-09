Feature: Automation Login

  Scenario: Login with valid username and password
    Given user is on homepage
    When user click Login button
    And user input username with "Beta123"
    And user input password with "123"
    And user click submit
    Then user will redirect to hompage
    And username change to "Beta123"