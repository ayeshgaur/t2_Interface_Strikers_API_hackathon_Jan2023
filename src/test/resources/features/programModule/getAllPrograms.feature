Feature: Program module

  Scenario: Get all Programs and do necessary validations
    Given body specifications with a Service URL
    When  GET request is made
    Then Validate status code for getting all programs

