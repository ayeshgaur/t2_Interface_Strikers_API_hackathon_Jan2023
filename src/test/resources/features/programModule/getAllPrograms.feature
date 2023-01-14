Feature:

  Scenario: Get all Programs and do necessary validations
    Given A a Service with "URL"
    And  Request is sent to extract the program body of the already created programs
    When  GET request is made
    Then Validate status code for getting all programs

