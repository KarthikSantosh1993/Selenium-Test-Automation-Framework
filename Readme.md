
# Test Automation Framework

Overview

This is a Java-based test automation framework.

The framework leverages various libraries and tools to facilitates data-driven testing, logging, reporting and integration with cloud based testing platform like lambdatest.


## 🚀 About Me
Hi, My Name is Karthik Duruvasula. I have 6 years of experience in Automation Testing using technologies like Selenium WebDriver, Playwright, Rest Assured 

My Major Expertise in Java as programming language

## Authors

- [@KarthikSantosh1993](https://github.com/KarthikSantosh1993/)
- Email Address: krthiksantosh@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/KarthikSantosh1993/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/karthik-duruvasula-b6972974/)


## Prerequisites

- Before running this framework, ensure the following are installed on your system:

    - **Java 11**

    - **Maven**

    - **TestNG Plugin** (for IDE support)


## Features


- **Test Execution:** With the help of TestNG

- **Data-Driven Testing:**  Using OPENCSV, Gson, and Apache POI for reading test data from CSV, JSON and Excel

- **Faker Library:** Dynamic Test Data Generation with Faker

- **Cloud Execution:** On LambdaTest

- **Headless Mode:** Faster execution by running tests in headless mode

- **Logging:** Uses Log4j for detailed logs

- **Reporting:** Generates detailed reports using Extent Reports

- **Command Line Execution:**  Using Maven Surefire Plugin 

- **CI/CD: Jenkins is utilised to achieve this

## Technologies Used

- Java 11
- TestNG
- OPENCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports
- Jenkins





## Set up instructions

**Clone the Repository:**

```bash
  git clone https://github.com/KarthikSantosh1993/Selenium-Test-Automation-Framework.git
  cd Selenium-Test-Automation-Framework
```
**Running Tests on chrome browser on Local machine in headless mode:**

```bash
  mvn test -Dbrowser=chrome -Dislambda=false -Disheadless=true -X
```
 

**Running Tests on LambdaTest:**

```bash
  mvn test -Dbrowser=chrome -Dislambda=true -Disheadless=false -X
```
 
## Logs and Reports

**Logs:** Logs are created during test execution and stored in logs/ directory)

**Test Reports:** After the execution, detailed report will be generated in ./report.html 

The report contains information on test cases executed. Status of each test case - pass, failed, skipped along with screenshots for failed Tests


## Git hub Actions Integration 

- This automation framework is integrated with github actions. 
- The tests will be executed at 06:00PM CST every day 
- Artifacts like reports, logs, screenshots)  are archived in gh-pages branch
