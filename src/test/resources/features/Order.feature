Feature: Shopping Cart Functionality

  Scenario: Verify the price of a specific item in the cart
    Given the user has added the item "Samsung Galaxy S6" to the cart
    When the user checks the price of the item "Samsung Galaxy S6"
    Then the displayed price should be "$360"

  Scenario: Verify the title of a specific item in the cart
    Given the user has added the item "Samsung Galaxy S6" to the cart
    When the user checks the title of the item
    Then the displayed title should be "Samsung Galaxy S6"

  Scenario: Delete an item from the cart
    Given the user has added the item "Samsung Galaxy S6" to the cart
    When the user deletes the item from the cart
    Then the item "Samsung Galaxy S6" should no longer be displayed in the cart

  Scenario: Verify the total price in the cart
    Given the user has added the following items to the cart:
      | Item Name          | Price  |
      | Samsung Galaxy S6  | $360   |
      | iPhone 6           | $500   |
    When the user calculates the total price
    Then the total price displayed should match "$860"

  Scenario: Place an order for items in the cart
    Given the user has added items to the cart
    When the user clicks the "Place Order" button
    Then the order form should be displayed

  Scenario: Complete a purchase
    Given the user has opened the order form
    When the user fills in the following order details:
      | Field      | Value           |
      | Name       | John Doe        |
      | Country    | USA             |
      | City       | New York        |
      | Card       | 1234567890123456|
      | Month      | December        |
      | Year       | 2025            |
    And the user clicks the "Purchase" button
    Then the purchase should be completed successfully
    And a confirmation message should be displayed
