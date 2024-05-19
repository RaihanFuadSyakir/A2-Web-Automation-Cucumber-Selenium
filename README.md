# A2 Web Automation using Cucumber & Selenium

## project built upon

```md
## Gradle 8.7

Build time: 2024-03-22 15:52:46 UTC
Revision: 650af14d7653aa949fce5e886e685efc9cf97c10

Kotlin: 1.9.22
Groovy: 3.0.17
Ant: Apache Ant(TM) version 1.10.13 compiled on January 4 2023
JVM: 17.0.9 (Oracle Corporation 17.0.9+11-LTS-201)
OS: Windows 11 10.0 amd64
```

## prerequisite

- java JDK 17
- downloaded chromeDriver for selenium based on Chrome installed version at `https://googlechromelabs.github.io/chrome-for-testing/#stable`
- put path to executabel chromeDriver in `src\test\resources\config.properties` fill `webdriver.chrome.driver={pathToChromeDriver}`
  For example `webdriver.chrome.driver=C:\\Compiler\\chromedriver-win64\\chromedriver.exe`

## How to Create Test Case for Login

- create bdd in `src\test\resources\io\cucumber\skeleton\user_login.feature` in format :

**format for login success**

```gherkin
Feature: User Login

    Scenario: {Scenario Name}
        Given access url "https://www.saucedemo.com"
        And set username {username}
        And set password {password}
        When press login button
        Then check url "https://www.saucedemo.com/inventory.html"
```

**format for login failed**

```gherkin
Feature: User Login

    Scenario: {Scenario Name}
        Given access url "https://www.saucedemo.com"
        And set username {username}
        And set password {password}
        When press login button
        Then check error message {expectedMessageOutput}
```

- run test by execute command `./gradlew test`
- read output and report

## check output in terminal

use command `./gradlew test --info` for read detail output from cucumber

## Report Directory

report created by gradle saved in `build\reports\tests\test\index.html`
