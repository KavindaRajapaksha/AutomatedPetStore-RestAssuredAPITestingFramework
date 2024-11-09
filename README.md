AutomatedPetStore - API Testing Framework

Overview
AutomatedPetStore is an API testing framework designed for validating the functionalities of the Pet Store API using RestAssured, Java, Maven, TestNG, and Jenkins. This framework enables automated API testing with extensive reporting, continuous integration (CI), and version control using Git.

Key Features
API Testing Automation: Ensures comprehensive test coverage for API endpoints.
Data-Driven Testing: Supports dynamic data testing using TestNG's @DataProvider and data sources like Excel files.
Continuous Integration (CI): Integrated with Jenkins for automated test execution and reporting.
Customizable Reporting: Test reports generated using Maven and TestNG configurations.
Framework Overview
What is RestAssured?
RestAssured is a powerful Java-based library for testing RESTful web services. It simplifies HTTP requests and responses, allowing you to focus on validating API functionalities with ease and accuracy.

Why Use an API Testing Framework?
Efficiency: Streamlines the process of writing and managing API test cases.
Reusability: Provides modular test methods and reusable components.
Scalability: Easily accommodates new endpoints and test cases.
Automated Reporting: Generates test results directly from Jenkins builds, saving time on manual reporting.
Project Structure

![WhatsApp Image 2024-11-09 at 18 59 28](https://github.com/user-attachments/assets/a3410b57-9ebd-4df8-8f2d-052ae88f9450)


Dependencies and Technologies
Java
Maven
RestAssured
TestNG
Jenkins
Excel (for test case management)
Getting Started
Clone the Repository:

bash
Copy code
git clone https://github.com/KavindaRajapaksha/AutomatedPetStore-RestAssuredAPITestingFramework.git
cd AutomatedPetStore-RestAssuredAPITestingFramework
Configure the Framework:

Modify pom.xml for dependencies.
Configure testng.xml to adjust test suite settings.
Execute Tests:
Run tests locally using Maven:

bash
Copy code
mvn clean test
Test Results:

Jenkins will generate reports in the pipeline.
Local Reports: Reports are also generated in the target/surefire-reports directory.
CI/CD Integration
We use Jenkins for CI to trigger the testing pipeline automatically with each commit.

Test Case Management
Test cases are organized in an Excel file, which can be accessed here. The Excel file structure supports managing test data and scenarios efficiently.

Repository Structure
bash
Copy code
AutomatedPetStore-RestAssuredAPITestingFramework/
├── src/test/java           # Test cases
├── src/main/java           # Core classes and utilities
├── resources               # Config files and data sources
├── pom.xml                 # Project dependencies
└── testng.xml              # Test suite configuration
License
This project is licensed under the MIT License.

Contributing
Feel free to submit issues or feature requests. Pull requests are welcome!
