# NOTE
## API Testing with Regress.in

Due to the unavailability of the DummyAPI (https://dummyapi.io/docs/user), I have opted to use Regress.in for API testing. Regress.in provides a reliable environment to test the functionality and performance of APIs. This alternative allows for effective validation of API responses, ensuring the correct behavior of web services in the project. 



# Final Project

In this project, I conduct UI testing on the Demoblaze.com website using Selenium WebDriver to identify defects by verifying elements such as buttons, images, titles, and prices. Additionally, I perform API testing on Regress.in using REST Assured to validate the functionality, reliability, and performance of web services.

## Features

- **Automated UI Testing**: Ensures the correctness of UI elements on Demoblaze.com, including buttons, images, titles, and prices, using Selenium WebDriver.
- **API Testing with REST Assured**: Validates the functionality and reliability of APIs on Regress.in through automated test scenarios.
- **Page Object Model (POM)**: Implements the Page Object Model design pattern for better test maintainability and scalability.
- **Data-Driven Testing**: Supports executing tests with multiple data sets, such as product IDs and titles, to enhance test coverage.
- **Cross-Browser Support**: Configurable to run tests on various browsers like Chrome and Edge using WebDriver.
- **Comprehensive Test Reporting**: Generates detailed test execution reports with pass/fail results for better analysis and debugging.

## Prerequisites

Before running the tests, make sure you have the following installed on your machine:

- **Java 17 or higher**: The project is built using Java and requires Java 17 or later.
- **Maven or Gradle**: The project uses Maven or Gradle as the build automation tool to manage dependencies and run tests for both UI (using Selenium WebDriver) and API (using REST Assured).
- **Selenium WebDriver**: Required for browser automation to test UI elements on Demoblaze.com.
- **ChromeDriver or GeckoDriver**: Needed for automating tests on Chrome or Firefox browsers, respectively.
- **REST Assured**: For automating API tests on Regress.in to validate web service functionality.
- **IDE (Optional)**: You can use any Java IDE such as IntelliJ IDEA or Eclipse for development and debugging.


## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/Selenium-Test.git
   cd Selenium-Test
Install dependencies:

If you're using Maven, run:

```bash
mvn install
```
If you're using Gradle, run
```bash
./gradlew build
```
Download WebDriver binaries:

Download ChromeDriver or GeckoDriver and add them to your system PATH, or use WebDriverManager to manage it automatically.
Running Tests

To run tests with Gradle:
```bash
./gradlew test
```
To run on multiple browser :
```bash
./gradlew runAllBrowsers
```
To run on selected browser :
```bash
./gradlew cucumberChrome
./gradlew cucumberEdge
```

To run specific tests (e.g., LoginTest):
with Gradle:

```bash
./gradlew cucumberChrome -Ptags="@Login"

```
**To run API Test**
with Gradle:

```bash
./gradlew runApiTests
```

Test Reporting
Test results are generated in the target (Maven) or build (Gradle) directories. You can view detailed reports in the following format:

JUnit HTML Report: Located in the target/surefire-reports (Maven) or build/test-results (Gradle).

Acknowledgements
- Selenium WebDriver: For browser automation.
- JUnit: For running and structuring the tests.
- WebDriverManager: For automatically managing WebDriver binaries.

