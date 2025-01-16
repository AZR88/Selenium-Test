@Cart
Feature: Shopping Cart Functionality

  @Valid-Cart
  Scenario: Verify the price and title of a specific item in the cart
    Given the user has added the item "Samsung galaxy s6" to the cart
    When Click Cart button
    Then user checks the title of the item and it should be "Samsung galaxy s6"
    Then the displayed price should be "360"

  @Valid-Cart
  Scenario: Delete an item from the cart
    Given the user has added the item "Samsung galaxy s6" to the cart
    When Click Cart button
    Then the user deletes the item from the cart
    Then the item "Samsung galaxy s6" should no longer be displayed in the cart


  @Valid-Cart
  Scenario: Verify the total price in the cart
    Given the user has added the following items to the cart:
      | Item Name          | Price  |
      | Samsung galaxy s6  | $360   |
      | Nexus 6            | $650   |
    When Click Cart button
    Then the total price displayed should match "$860"


  @Valid-Cart
  Scenario: Complete a purchase
    Given  the user has added the item "Samsung galaxy s6" to the cart
    When Click Cart button
    Then the user clicks the "Place Order" button
    Then the user fills in the following order details:
      | Field      | Value           |
      | name       | Agus            |
      | country    | USA             |
      | city       | New York        |
      | card       | 1234567890123456|
      | month      | December        |
      | year       | 2025            |
    And the user clicks the Purchase
    Then the user click ok button to complete the purchase

  @inValid-Cart
  Scenario: Complete a purchase
    Given  the user has added the item "Samsung galaxy s6" to the cart
    When Click Cart button
    Then the user clicks the "Place Order" button
    Then the user fills in the following order details:
      | Field      | Value           |
      | name       |                 |
      | country    | USA             |
      | city       |                 |
      | card       | 1234567890123456|
      | month      | December        |
      | year       | 2025            |
    And the user clicks the Purchase
    Then An alert Should be show up