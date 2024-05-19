package io.cucumber.skeleton.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.skeleton.utils.ConfigReader;
import io.cucumber.skeleton.utils.SeleniumHelper;

public class LogoutSteps {
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    ConfigReader configReader;

    public LogoutSteps() {
        configReader = new ConfigReader();
    }

    @Given("the user is logged in with username {string} and password {string}")
    public void the_user_is_logged_in_with_username_and_password(String username, String password) {
        // Assuming user is already logged in, so we just need to open the website
        System.setProperty("webdriver.chrome.driver", configReader.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        seleniumHelper = new SeleniumHelper(driver);
        driver.get("https://www.saucedemo.com");

        // Perform login if needed
        if (!seleniumHelper.isElementDisplayedById("login-button")) {
            // Already logged in, no need to perform login again
            return;
        }

        // Perform login
        seleniumHelper.setInputByName("user-name", username);
        seleniumHelper.setInputByName("password", password);
        seleniumHelper.clickButtonById("login-button");
    }

    @When("click element {string}")
    public void click_element(String elementId) {
        seleniumHelper.clickElementById(elementId);
    }

    @When("click element with id {string}")
    public void click_element_with_id(String elementId) {
        seleniumHelper.clickElementById(elementId);
    }

    @When("logout via url {string}")
    public void access_logout_link(String url) {
        driver.get(url);
    }

    @Then("check if {string} is displayed")
    public void check_if_login_button_is_displayed(String elementId) {
        try {
            assertTrue(seleniumHelper.isElementDisplayedById(elementId));
        } finally {
            driver.quit();
        }
    }
}
