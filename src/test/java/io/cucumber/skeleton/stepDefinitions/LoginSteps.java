package io.cucumber.skeleton.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.utils.ConfigReader;
import io.cucumber.skeleton.utils.SeleniumHelper;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    WebDriver driver;
    SeleniumHelper seleniumHelper;
    ConfigReader configReader;

    public LoginSteps() {
        configReader = new ConfigReader();
    }

    @Given("access url {string}")
    public void access_url(String url) {
        System.setProperty("webdriver.chrome.driver", configReader.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        seleniumHelper = new SeleniumHelper(driver);
        driver.get(url);
    }

    @Given("set username {string}")
    public void set_username(String username) {
        seleniumHelper.setInputByName("user-name", username);
    }

    @Given("set password {string}")
    public void set_password(String password) {
        seleniumHelper.setInputByName("password", password);
    }

    @When("press login button")
    public void press_login_button() {
        seleniumHelper.clickButtonById("login-button");
    }

    @Then("check url {string}")
    public void check_url(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
        driver.quit();
    }

    @Then("check error message {string}")
    public void check_error_message(String expectedMessage) {
        String actualMessage = seleniumHelper.getElementByClassName("error-message-container").getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}