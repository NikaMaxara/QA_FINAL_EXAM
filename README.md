# QA Final Exam – Test Automation Project

## Group Members

* **Giorgi Burduladze**
* **Nikoloz Razmadze**
* **Nika Makharashvili**

---

## Test Case Responsibility Mapping

### Giorgi Burduladze

Automated the following UI test cases:

* ContactFormTest
* CorrectLoginTest
* IncorrectLoginTest
* LoginExistingEmailTest

---

### Nikoloz Razmadze

Automated the following UI test cases:

* LogOutTest
* TestCasePageTest
* UserRegisterTest
* VerifySubcriptionTest

---

### Nika Makharashvili

Automated the following components and test cases:

#### Core UI Components:

* BaseTest
* ScrollUsingArrowTest
* ScrollWithoutArrowTest

#### API Automation:

* API 1: Get All Products List
* API 2: POST To All Products List
* API 3: Get All Brands List
* API 4: PUT To All Brands List
* API 5: POST To Search Product
* API 6: POST To Search Product without parameter
* API 7: POST To Verify Login with valid details
* API 8: POST To Verify Login without email parameter
* API 9: POST To Verify Login with invalid details
* API 10: GET User Detail by Email

---

## Running Tests and Generating Allure Report

1. Run the tests using the TestNG suite file (`test.xml`):

```bash
mvn test -DsuiteXmlFile=test.xml
```

2. After the tests finish, generate and open the Allure report:

```bash
allure serve target/allure-results
```

This will open the Allure report in your browser, where you can see test results, steps, screenshots (for failed UI tests), and API request and response attachments.


## Project Overview

This repository contains automated UI and API test cases developed as part of the QA Final Exam project.

The project includes:

* UI Automation using Selenium & TestNG
* API Automation using RestAssured
* Allure Reporting (including test steps, screenshots for failed UI tests, and API request/response attachments)
* Parallel test execution support

---
