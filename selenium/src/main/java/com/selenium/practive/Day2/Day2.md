# Selenium Test Automation Project

## Test Cases

### Day 2 - Form Validation and Navigation Tests

This test class contains Day 2 automated tests for form validation and navigation functionality of a practice website.

**Test Scenarios:**

1. **Form Submission with Valid Data**
    - Fills out a form with valid data
    - Submits the form
    - Verifies success message: "Form submitted successfully!"

2. **Form Submission with Missing Required Fields**
    - Leaves one or more required fields empty
    - Submits the form
    - Verifies error message: "Please fill out this field."

3. **Form Submission with Invalid Data**
    - Enters invalid data (e.g., incorrect email format)
    - Submits the form
    - Verifies error message: "Invalid input."

4. **Navigation Test**
    - Clicks on a navigation link
    - Verifies the user is redirected to the correct page
    - Confirms the page title or URL matches the expected value

## Selenium Concepts Used in Day 2 Tests

### 1. **Form Handling**
- **sendKeys()**: Entering data into form fields
- **clear()**: Clearing fields before entering new data
- **submit()**: Submitting forms

### 2. **Error Handling**
- Validating error messages for missing or invalid inputs

### 3. **Navigation**
- Clicking links or buttons to navigate between pages
- Verifying page titles and URLs

### 4. **Assertions**
- Validating success and error messages
- Confirming navigation outcomes

---

**Previous:** [Day 1 Test Cases](../Day1/Day1.md) | **Next:** [Day 3 Test Cases](../Day3/Day3.md)