# Selenium-Test

 Selenium-Test is a test automation project designed to identify UI defects in web applications. The project leverages Selenium WebDriver to perform functional and regression testing, with a focus on verifying the correctness of UI elements like buttons, images, titles, and prices on a web page.

## Features

- **Automated UI Testing**: Validates the visual and functional integrity of web elements.
- **Page Object Model (POM)**: Follows the Page Object Model design pattern for better maintainability and scalability of tests.
- **Data-Driven Testing**: Supports running tests with different sets of data, such as product IDs and titles.
- **Cross-Browser Support**: Can be configured to run tests on different browsers like Chrome and Edge using WebDriver.
- **Test Reporting**: Generates detailed reports of test execution with passed/failed test results.

## Prerequisites

Before running the tests, make sure you have the following installed on your machine:

- **Java 17 or higher**: The project is built using Java and requires Java 17 or later.
- **Maven or Gradle**: The project uses Maven or Gradle as the build automation tool for managing dependencies and running tests.
- **Selenium WebDriver**: WebDriver for browser automation.
- **ChromeDriver or GeckoDriver**: Required for Chrome or Firefox automation respectively.
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
Test Reporting
Test results are generated in the target (Maven) or build (Gradle) directories. You can view detailed reports in the following format:

JUnit HTML Report: Located in the target/surefire-reports (Maven) or build/test-results (Gradle).

Acknowledgements
- Selenium WebDriver: For browser automation.
- JUnit: For running and structuring the tests.
- WebDriverManager: For automatically managing WebDriver binaries.

