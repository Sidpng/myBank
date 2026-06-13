# myBank

[![parabank-ci](https://github.com/Sidpng/myBank/actions/workflows/ci.yml/badge.svg)](https://github.com/Sidpng/myBank/actions/workflows/ci.yml)

UI automation for the [ParaBank](https://parabank.parasoft.com/parabank/index.htm) demo banking app,
built with **Selenium 4 + TestNG** using the Page Object Model and an external config + Allure reporting.

## Stack
- **Selenium WebDriver 4.9**
- **TestNG 7.7**
- **Allure** reporting (`allure-testng` + aspectj weaver)
- **Maven** build

## What it does
Automates new-customer **registration** end-to-end: opens ParaBank, fills the register form via the
`SignUp` page object (data from `Configuration/config.properties`), submits, and asserts the
"account created successfully" confirmation. A unique username is generated per run so the test is
repeatable.

## Run
```bash
mvn clean test            # runs **/TC_*.java
mvn allure:serve          # view the Allure report (optional)
```

## Layout
```
src/test/java/com/myBank/pages       # SignUp page object (ParaBank locators)
src/test/java/com/myBank/tests       # BaseClass + TC_SignUp_001
src/test/java/com/myBank/utilities   # readConfig
Configuration/config.properties      # baseUrl + test data
```

## CI
GitHub Actions runs the suite headlessly (xvfb + preinstalled Chrome) on every push.
**Verified: registration test passing.**
