Feature: Contact
  As a user, I want to send a message through the contact form.

  Scenario: User successfully fills the contact form
    Given user is on homepage "https://www.demoblaze.com/"
    When Click Contact
    Then the user enters their email "Agus@example.com"
    And the user enters their name "Agus"
    And the user enters their message " this is Test message"
    Then Submit The form


  Scenario: User submits the form with invalid email
    Given user is on homepage "https://www.demoblaze.com/"
    When Click Contact
    Then the user enters their email "Agus-email"
    And the user enters their name "John Doe"
    And the user enters their message "This is a test message"
    And the user click Submit
    Then an error message should be displayed for emtpy field


  Scenario: User submits the form with emtpy email & name
    Given user is on homepage "https://www.demoblaze.com/"
    When Click Contact
    Then the user enters their email ""
    And the user enters their name ""
    And the user enters their message "Test message"
    And the user click Submit
    Then an error message should be displayed for emtpy field


  Scenario: User submits the form with emtpy message
    Given user is on homepage "https://www.demoblaze.com/"
    When Click Contact
    Then the user enters their email "Agus@gmail.com"
    And the user enters their name "Agus"
    And the user enters their message ""
    And the user click Submit
    Then an error message should be displayed for emtpy field
