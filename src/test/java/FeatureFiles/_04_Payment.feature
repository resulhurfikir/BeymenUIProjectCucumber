Feature: Payment Functionality

  @SmokeTest @Parallel
  Scenario: User should be able to pay for products in the basket successfully
    Given Navigate to Beymen website
    And Close the cookies
    And Click on the *hesabim* link
    When User enter valid email and password
    Then Verify that the user should be logged successfully
    And Click on the Element
      | navigateToBasket |
      | satinAlButton    |
      | devamEtButton    |
    And SendKeys to the Element
      | cardNo         | 1111111111111111 |
      | cardHolderName | Resul Resul      |
      | cardMonth      | 10               |
      | cardYear       | 25               |
      | cardCvv        | 123              |
    And Click on the Element
      | checkBox |