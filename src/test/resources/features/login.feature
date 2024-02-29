Feature: Full test rail test
  Scenario: Login, create project, delete project
    Given driver is ready
    Given page is opened
    Then login page is opened
    When perform login with "email" email and "password" password
    Then Dashboard page is opened
    Given pages opened
    When Create project
    Then Banner on a page
    When Delete project
    Then Banner on a page

