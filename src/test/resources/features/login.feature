Feature: Full test rail test
  Scenario: Login attempt
    Given driver is ready
    Then login page is opened
    When perform login with "chichaevwork+qazwsx@gmail.com" email and "Qwerty1234%" password
    Then Dashboard page is opened

  Scenario: Create project
    When Create project
    Then Banner on a page

  Scenario: Delete project
    When Delete project
    Then Banner on a page