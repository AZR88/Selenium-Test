Feature: Product Page Functionality

  Scenario: Verify the product title of a specific item
    Given user is on homepage "https://www.demoblaze.com/"
    When the user click the product title "Samsung galaxy s6"
    Then the product title should be "Samsung galaxy s6"
    Then the product price should be "$360"
    Then the product image should be displayed
    Then the product description should contain "Super AMOLED capacitive touchscreen"


  Scenario: Add a specific product to the cart
    Given user is on homepage "https://www.demoblaze.com/"
    When the user clicks the "Add to cart" button
    Then the product should be added to the cart successfully
