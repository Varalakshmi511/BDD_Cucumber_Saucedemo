Feature: Add to cart
Background:
  Given user launch chrome browser
  When user opens url "https://www.saucedemo.com/"
  @Sanity @Regression
  Scenario: Verify user can add item to cart
    And user enters email as "standard_user" and password "secret_sauce"
    And click on login
    Then page title should be "Swag Labs"
    When user click on Addcart button
    Then User should be able to view Remove button
    And close browser
