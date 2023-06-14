Feature: Login with Positive and Negative Data

  Background:
    Given Navigate to Beymen website
    And Close the cookies
    And Click on the *hesabim* link

  Scenario Outline: User should not be able to login with invalid multiple data
    When User enter email as "<email>"  password  as "<password>"
    Then Verify that the user should not be logged successfully

    Examples:
      | email                   | password  |
      | resulhurfikir@gmail.com | 123456    |
      | email@email.com         | R.h106617 |

  @SmokeTest
  Scenario: User should be able to login with valid data
    When User enter valid email and password
    Then Verify that the user should be logged successfully


