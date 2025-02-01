@Product
Feature: Product Page Functionality

  @valid-Product
  Scenario: Verify the product title of a specific item
    Given user is on homepage "https://www.demoblaze.com/"
    When the user click the product title "Samsung galaxy s6"
    Then the product title should be "Samsung galaxy s6"
    And the product price should be "$360"
    And the product image should be displayed
    And the product description should contain "Samsung Galaxy S6"

  @valid-Product
  Scenario: Add a specific product to the cart
    Given user is on homepage "https://www.demoblaze.com/"
    When the user click the product title "Samsung galaxy s6"
    And the user clicks the Add to cart button
    Then Show Alert Product Added
