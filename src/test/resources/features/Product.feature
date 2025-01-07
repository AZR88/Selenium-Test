Feature: Product Page Functionality

  Scenario: Verify the product title of a specific item
    Given user is on homepage "https://www.demoblaze.com/"
    When the user checks the product title
    Then the product title should be "Samsung Galaxy S6"

  Scenario: Verify the product price of a specific item
    Given user is on homepage "https://www.demoblaze.com/"
    When the user checks the product price
    Then the product price should be "$360"

  Scenario: Verify the product image is displayed
    Given user is on homepage "https://www.demoblaze.com/"
    When the user checks the product image
    Then the product image should be displayed

  Scenario: Verify the product description contains specific text
    Given user is on homepage "https://www.demoblaze.com/"
    When the user checks the product description
    Then the product description should contain "Super AMOLED capacitive touchscreen"

  Scenario: Add a specific product to the cart
    Given user is on homepage "https://www.demoblaze.com/"
    When the user clicks the "Add to cart" button
    Then the product should be added to the cart successfully
