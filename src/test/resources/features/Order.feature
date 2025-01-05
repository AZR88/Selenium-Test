Feature: Product Page Functionality

  Scenario: Verify the product title of a specific item
    Given I select the product "Samsung Galaxy S6"
    When I check the product title
    Then the product title should be "Samsung Galaxy S6"

  Scenario: Verify the product price of a specific item
    Given I select the product "Samsung Galaxy S6"
    When I check the product price
    Then the product price should be "$360"

  Scenario: Verify the product image is displayed for a specific item
    Given I select the product "Samsung galaxy s6"
    When I check the product image


  Scenario: Verify the product description of a specific item
    Given I select the product "Samsung Galaxy S6"
    When I check the product description
    Then the product description should contain "Super AMOLED capacitive touchscreen"

  Scenario: Add a specific product to the cart
    Given I select the product "Samsung Galaxy S6"
    When I click on the "Add to cart" button
    Then the product should be added to the cart successfully
