#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@batch-module
Feature: LMS API batch module testing

  @batch-module
  Scenario Outline: Fetch batch info using batch id
    Given a service with baseURI "https://lms-backend-service.herokuapp.com/lms"
    When get by batch id request is made with endpoint "/batches/batchId/" and batch id <batchId>
    Then validate response status code
    And validate response body <batchName>, <batchDescription>, <batchStatus>, <batchNoOfClasses>, <programId>

    Examples:
      | batchId | batchName                              | batchDescription | batchStatus | batchNoOfClasses | programId |
      | 338     | Jan23-InterfaceStrikers-SDET-Batch-111 | Python           | Active      | 30               | 458       |
      



