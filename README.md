# AutomatedPetStore - API Testing Framework

## Overview
**AutomatedPetStore** is an API testing framework designed for validating the functionalities of the Pet Store API using **RestAssured**, **Java**, **Maven**, **TestNG**, and **Jenkins**. This framework facilitates automated API testing, continuous integration, and extensive reporting with version control managed through Git.

## Key Features
- **API Testing Automation**: Ensures comprehensive test coverage for API endpoints.
- **Data-Driven Testing**: Supports dynamic data testing using TestNG’s `@DataProvider` and data sources like Excel files.
- **Continuous Integration (CI)**: Integrated with Jenkins for automated test execution and reporting.
- **Customizable Reporting**: Generates detailed test reports through Maven and TestNG configurations.

## Framework Overview

### What is RestAssured?
**RestAssured** is a powerful Java-based library for testing RESTful web services. It simplifies HTTP requests and responses, enabling you to focus on validating API functionalities with ease and accuracy.

### Why Use an API Testing Framework?
- **Efficiency**: Streamlines the process of writing and managing API test cases.
- **Reusability**: Provides modular test methods and reusable components.
- **Scalability**: Easily accommodates new endpoints and test cases.
- **Automated Reporting**: Generates test results directly from Jenkins builds, saving time on manual reporting.

## Project Structure

![Project Structure](https://github.com/user-attachments/assets/a3410b57-9ebd-4df8-8f2d-052ae88f9450)

## Dependencies and Technologies
- **Java**
- **Maven**
- **RestAssured**
- **TestNG**
- **Jenkins**
- **Excel** (for test case management)

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/KavindaRajapaksha/AutomatedPetStore-RestAssuredAPITestingFramework.git
cd AutomatedPetStore-RestAssuredAPITestingFramework
```

### Configure the Framework
1. Modify `pom.xml` for dependencies.
2. Configure `testng.xml` to adjust test suite settings.

### Execute Tests
Run tests locally using Maven:
```bash
mvn clean test
```

### Test Results
- **Jenkins**: Generates reports in the pipeline.
- **Local Reports**: Reports are also generated in the `target/surefire-reports` directory.

## CI/CD Integration
We use **Jenkins** for CI, which triggers the testing pipeline automatically with each commit.

## Test Case Management
Test cases are organized in an Excel file. [Access the Excel file here](https://docs.google.com/spreadsheets/d/1xjX6C-zKr1G-sdFJs59DUxDIg0j0DFAiIIh6t8tosVM/edit?usp=sharing). The file structure supports efficient management of test data and scenarios.

## Repository Structure
```bash
AutomatedPetStore-RestAssuredAPITestingFramework/
├── src/test/java           # Test cases
├── src/main/java           # Core classes and utilities
├── resources               # Config files and data sources
├── pom.xml                 # Project dependencies
└── testng.xml              # Test suite configuration
```

## License
This project is licensed under the **MIT License**.

## Contributing
Feel free to submit issues or feature requests. Pull requests are welcome!

--- 
