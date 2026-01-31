Feature: Login
  Background: #repeating steps for all scenarios
    Given user launch chrome browser
    When user opens url "https://www.saucedemo.com/"

#use scenario when you have single test data and
#use scenario outline when you want to pass multiple test data it will run those many times(how many data is there those many times it will rum).
  @Regression
  Scenario Outline: Successful login with valid credentials
    And user enters email as "<username>" and password "<password>"
    And click on login
    Then page title should be "Swag Labs"
    And user click on open menu option
    When user click on logout link
    Then page title should be "Swag Labs"
    And close browser

   Examples:
    |username|password|
    |standard_user|secret_sauce|
    |visual_user  |secret_sauce|

    @Sanity
  Scenario: Successful login with valid credentials
    And user enters email as "visual_user" and password "secret_sauce"
    And click on login
    Then page title should be "Swag Labs"
    And user click on open menu option
    When user click on logout link
    Then page title should be "Swag Labs"
    And close browser

