Feature: E-shop User Flow

  Scenario: User completes a purchase successfully
    Given the user is on the login page
    When the user logs in with valid credentials
    And adds a specific product to the cart
    And goes to the cart page
    And proceeds to checkout
    And fills in personal information
    And continues to finish the order
    Then the user should see the confirmation message
