# Project Title: Automation Testing with Java and Selenium

## Description
This project is focused on implementing automation tests using Java and Selenium. It utilizes the Page Object Model (POM) for enhanced maintainability and readability. The tests are aimed at the demo website [Yo-Meals](http://demo.yo-meals.com/), covering various functionalities like search, profile management, meal item handling, and cart operations.

## Project Structure
The project is structured into different page classes and test classes, each representing a distinct aspect of the website:

### Page Classes
- `AuthPage.java`: Authentication related functionalities.
- `BasicPage.java`: Basic operations for Login page.
- `CartSummaryPage.java`: Handling the Cart Summary and Meal Page.
- `LocationPopupPage.java`: Managing location pop-up related operations.
- `LoginPage.java`: Login functionalities.
- `MealPage.java`: Meal item handling.
- `NotificationSystemPage.java`: Managing notifications and alerts.
- `ProfilePage.java`: Profile related operations.
- `SearchResultPage.java`: Handling search results.

### Test Classes
- `SearchTest.java`: Tests for search functionality.
- `ProfileTest.java`: Tests for profile management.
- `MealItemTest.java`: Tests for meal item handling.

## Getting Started
### Prerequisites
- Java JDK
- Selenium WebDriver
- TestNG

### Installation
1. Clone the repository.
2. Import the project into your IDE.
3. Resolve any dependencies (like Selenium, TestNG).

### Running Tests
To run the tests, navigate to the test classes and execute them either individually or collectively using TestNG.

## Usage
The tests are designed to validate various functionalities of the Yo-Meals website. They use a data-driven testing approach, fetching data from an Excel file to simulate different user scenarios.

## Contributing
Contributions are welcome. Please fork the repository and create a pull request with your features or fixes.
