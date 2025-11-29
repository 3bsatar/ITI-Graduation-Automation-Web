# ITI Graduation Web Automation Project

![Java](https://img.shields.io/badge/Language-Java-blue?logo=java)
![Maven](https://img.shields.io/badge/Build-Maven-orange?logo=apache-maven)
![TestNG](https://img.shields.io/badge/TestNG-Framework-yellow?logo=testng)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen?logo=selenium)
![Allure](https://img.shields.io/badge/Allure-Reports-purple?logo=allure)

A **Web Automation Framework** built with **Java**, **Selenium**, **TestNG**, and **Maven**.  
Created as part of the **ITI Graduation Project** to automate testing for the **SwagLabs web application** with clean, maintainable code and integrated **Allure Reports**.


## Tech Stack
- **Java 11+**
- **Maven**
- **TestNG**
- **Selenium WebDriver**
- **Allure Report**
- **Log4j2**

## Project Structure
```bash
ITI-Graduation-Automation-Web/
├── src/
│   ├── main/java/com/swaglabs/
│   │   ├── drivers/          # WebDriver setup & factories
│   │   │   ├── AbstractDriver
│   │   │   ├── BrowserFactory.java
│   │   │   ├── ChromeFactory
│   │   │   ├── EdgeFactory
│   │   │   ├── FirefoxFactory
│   │   │   ├── GUIDriver
│   │   │   └── WebDriverOptionsAbstract
│   │   │
│   │   ├── listeners/        # TestNG listeners
│   │   │   └── TestNGListeners
│   │   │   └── WebManagerListener
│   │   │
│   │   ├── pages/            # Page Objects (POM)
│   │   │   ├── CartPage
│   │   │   ├── ConfirmationPage
│   │   │   ├── HomePage
│   │   │   ├── InformationPage
│   │   │   ├── LoginPage
│   │   │   └── OverviewPage
│   │   │
│   │   └── utils/            # Helper & utility classes
│   │       ├── AllureUtils
│   │       ├── BrowserActions
│   │       ├── CustomSoftAssertion
│   │       ├── ElementActions
│   │       ├── FileUtils
│   │       ├── JsonUtils
│   │       └── LogUtils
│   │       └── PropertiesUtils
│   │       └── ScreenshotsUtils
│   │       └── Scrolling
│   │       └── TimestampUtils
│   │       └── Validations
│   │       └── Waits
│   │
│   └── resources/            # Config files
│       ├── allure.properties
│       ├── environment.properties
│       ├── log4j2.properties
│       └── web.properties
│
├── test/
│   ├── java/com/swaglabs/tests/  # TestNG classes
│   │   ├── E2eTest
│   │   └── UserFlowTC
│   │
│   └── resources/                # Test data
│       └── test-data.json
│
├── test-outputs/
│   ├── allure-results/           # Allure raw data
│   ├── Logs/                     # Log4j2 logs
│   ├── screenshots/              # Test screenshots
│   └── target/                   # Compiled output & reports
│
├── pom.xml                       # Maven config & dependencies
```

   ## Running Tests
  You can execute the tests using Maven:

  ```bash
  # Run all tests
  mvn clean test

  # Run a specific TestNG class (single test case)
  mvn clean test -Dtest=ClassName
  ```

  ## Generating & Viewing Allure Reports
  The framework integrates **Allure Reports** for rich test insights.

  ```bash
  # Generate Allure report after test execution
  allure generate test-outputs/allure-results/ -o test-outputs/allure-report/ --clean

  # Open Allure report in browser
  allure open test-outputs/allure-report/

  # OR serve Allure report directly
  allure serve test-outputs/allure-results/
  ```
## Project Snapshots

Here are some visuals from the framework in action:

| Adding Product to Cart | Checkout Product |
|-----------------------|-----------------|
| ![Adding Product to Cart](https://github.com/3bsatar/ITI-Graduation-Automation-Web/blob/master/images/successful_addingProductToCart.png?raw=true) | ![Checkout Product](https://github.com/3bsatar/ITI-Graduation-Automation-Web/blob/master/images/successful_checkoutProduct.png?raw=true) |

| Fill Information Form | Overview Page |
|----------------------|---------------|
| ![Fill Information Form](https://github.com/3bsatar/ITI-Graduation-Automation-Web/blob/master/images/successful_fillInformationForm.png?raw=true) | ![Overview Page](https://github.com/3bsatar/ITI-Graduation-Automation-Web/blob/master/images/successful_overviewPage_2025.png?raw=true) |

  ## Notes
  - Ensure **Java 11+**, **Maven**, and **Allure CLI** are installed and added to your system PATH.
  - Chrome, Edge, or Firefox browsers must be installed for WebDriver tests.
  - Allure results are saved in `test-outputs/allure-results/`.
  - Screenshots of failed tests are stored in `test-outputs/screenshots/`.
  - Logs are available in `test-outputs/Logs/`.

  ## Author
  **Mahmoud Mesalem**

  - [LinkedIn](https://www.linkedin.com/in/mahmoud--mesalem)
  - [GitHub](https://github.com/3bsatar)

  ## Collaboration
  This repository is maintained by the author.  
  You are welcome to **fork** the project, experiment freely, and explore the code.  
  It's a great way to learn, test ideas, and get hands-on experience!  

  ![Fork](https://img.shields.io/badge/Fork-blue?style=for-the-badge) 
  ![Experiment](https://img.shields.io/badge/Experiment-brightgreen?style=for-the-badge) 
  ![Learn](https://img.shields.io/badge/Learn-orange?style=for-the-badge)
