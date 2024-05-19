@logout
Feature: User Logout

    Scenario: Logout success
        Given the user is logged in with username "standard_user" and password "secret_sauce"
        When click element "react-burger-menu-btn"
        And click element "logout_sidebar_link"
        Then check if "login-button" is displayed