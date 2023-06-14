Feature: Adding products to the basket in different ways.

  Background:
    Given Navigate to Beymen website
    And Close the cookies
    And Click on the *hesabim* link
    When User enter valid email and password
    Then Verify that the user should be logged successfully

  @SmokeTest
  Scenario: The user should be able to select a product from any category and add it to the basket
    And Hover to element
      | kadinLink    |
      | aksesuarLink |
    And Click on the Element
      | kolSaatiLink |
    And Add the product to the basket randomly from result list
    And jsClick on the Element
      | navigateToBasket |
    Then Verify that the chosen product is in the basket

  Scenario: User should be able to add a product by searching and filtering to the favorite list and add it to the basket
    And SendKeys to the Element
      | searchBox | ipad |
    And Click on the Element
      | searchButton |
      | filterOpen   |
    And Choose the filtering options
      | marka       |
      | apple       |
      | renk        |
      | gri         |
      | applyFilter |
    And Add the product to the favorites randomly from result list
    And Add the product to the basket from favorites
    Then Verify that the chosen product is in the basket

