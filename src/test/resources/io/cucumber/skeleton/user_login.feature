@Login
Feature: User Login

  Scenario: Successful login with valid credentials
    Given access url "https://www.saucedemo.com"
    And set username "standard_user"
    And set password "secret_sauce"
    When press login button
    Then check url "https://www.saucedemo.com/inventory.html"

  Scenario: Unsuccessful login with invalid credentials
    Given access url "https://www.saucedemo.com"
    And set username "invalid_user"
    And set password "wrong_password"
    When press login button
    Then check error message "Epic sadface: Username and password do not match any user in this service"
