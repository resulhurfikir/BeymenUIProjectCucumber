Feature: Adding a new address


  Scenario: User should be able to add a new address
    Given Navigate to Beymen website
    And Close the cookies
    And Click on the *hesabim* link
    When User enter valid email and password
    When User click on the *adreslerim* button
    And Click on the *YeniAdresEkle* button
    And Choose the city
    And Choose the district
    And Choose the neighbourhood
    And Enter the address from *FakerClass*
    And Enter the address name from database with "select * from address"
    And Click on the *kaydet* button
    Then Verify that the process is successful