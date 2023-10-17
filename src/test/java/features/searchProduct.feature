Feature: Search and place order for the Product

  Background: User is on Home Page
    Given User is on Greenkart Home Page

  @Sanity
  Scenario: Search for product in Home and Deals Page
    When User searches for product with "Tom"
    And searched product is displayed
    And User searches for same product "Tom" in Deals Page
    Then User should see the searched product

  @Smoke @SearchOrder
  Scenario Outline: Product Search in Home and Deals Page
    When User searches for product with "<Name>"
    And product "<searchedProduct>" is displayed
    And User searches for same product "<Name>" in Deals Page
    Then User should see the searched product
    Examples:
      | Name  | searchedProduct |
      | Beans | Beans           |

  @E2E @Regression @PlaceOrder
  Scenario Outline: Add Product to cart and place order
    When User searches for product with "<Name>"
    And product "<searchedProduct>" is displayed
    And user adds "<quantity>" quantities of product
    And product is added to cart and proceeds to checkout
    Then added product "<addedProduct>" is displayed in the checkout
    Examples:
      | Name  | searchedProduct | addedProduct | quantity |
      | Beans | Beans           | Beans - 1 Kg | 3        |



