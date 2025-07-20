# Selenium Test Automation Project

This project contains automated tests for web applications using Selenium WebDriver with Java.

## Project Structure

- **Language**: Java
- **Framework**: Spring Boot
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Web Automation**: Selenium WebDriver

## Dependencies

- Selenium WebDriver
- TestNG
- Custom WebDriverBuilder utility

## Test Cases

### Day 1 - Login Page Test

This test class contains Day 1 automated tests for the login functionality of a practice website.

**Test Scenarios:**

1. **Valid Login Test**
    - Enters valid username (`student`) and password (`Password123`)
    - Verifies successful login message
    - Logs out after successful login

2. **Invalid Username Test**
    - Enters invalid username (`random`) with valid password
    - Verifies error message: "Your username is invalid!"

3. **Invalid Password Test**
    - Enters valid username with invalid password
    - Verifies error message: "Your password is invalid!"

## Selenium Concepts Used in Login Tests

### 1. **WebDriver Management**
- Browser initialization using custom `WebDriverBuilder`
- Window maximization for consistent testing environment
- Proper driver cleanup after test execution

### 2. **Element Locating Strategies**
- **By ID**: Located username and password input fields using unique IDs
- **By CSS Selector**: Used for locating buttons and form elements
- **By XPath**: Alternative locating strategy for complex elements

### 3. **User Interactions**
- **sendKeys()**: Entering text into input fields (username/password)
- **click()**: Clicking buttons (login, logout)
- **clear()**: Clearing input fields before entering new data

### 4. **Wait Strategies**
- Implicit waits for element availability
- Explicit waits for specific conditions (if implemented)

### 5. **Assertions & Validations**
- Text validation using `getText()` method
- Error message verification
- Success message confirmation
- Boolean assertions for test outcomes

### 6. **Page Navigation**
- URL navigation using `get()` method
- Page redirection handling after login/logout

### 7. **Test Data Management**
- Valid credentials: username = "student", password = "Password123"
- Invalid test data for negative testing scenarios

## Running the Tests

1. Ensure you have Java and Maven installed
2. Clone the repository
3. Navigate to the project directory
4. Run the following command:

**Next:** [Day 2 Test Cases](../Day2/Day2.md)