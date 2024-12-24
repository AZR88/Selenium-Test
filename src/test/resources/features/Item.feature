Feature: Validate HomepageText

  Scenario: Validate navbar Text
    Given  user is on homepage
    When check Navbar "Home" button
    Then Check "About us" button
    Then Chek "Contact" button
    Then Check the "Cart" button
    Then Check a "Log in" button
    Then check "Sign up" buton

  Scenario: Validate multiple product titles in all category
    Given user is on homepage
    When check multiple titles and ids
      | id  | title               | price    |
      | 1   | Samsung galaxy s6   | $360     |
      | 4   | Samsung galaxy s7   | $800     |
      | 5   | Iphone 6 32gb       | $790     |
      | 7   | HTC One M9          | $700     |

    Then click next to show next product where id = "10" and title = "Apple monitor 24"
    Then check multiple titles and ids on next page
      | id  | title               | price   |
      | 10  | Apple monitor 24    | $400    |
      | 11  | MacBook air         | $700    |
      | 12  | Dell i7 8gb         | $700    |


  Scenario: Validate multiple product titles in phone category
      Given user is on homepage
      When user clik Category phone button
      Then check multiple titles and ids
        | id  | title               | price    |
        | 1   | Samsung galaxy s6   | $360     |
        | 2   | Nokia lumia 1520    | $820     |
        | 4   | Samsung galaxy s7   | $800     |
        | 5   | Iphone 6 32gb       | $790     |

  Scenario: Validate multiple product titles in Laptops category
    Given user is on homepage
    When user clik Category laptop button
    Then check multiple titles and ids
      | id  | title               | price    |
      | 8   | Sony vaio i5        | $790     |
      | 9   | Sony vaio i7        | $790     |
      | 11  | MacBook air         | $700     |
      | 13  | 2017 Dell 15.6 Inch | $700     |

  Scenario: Validate multiple product titles in Monitors category
    Given user is on homepage
    When user clik Category Monitor button
    Then check multiple titles and ids
      | id  | title               | price     |
      | 10  | Apple monitor 24    | $400      |
      | 14  | ASUS Full HD        | $230      |



