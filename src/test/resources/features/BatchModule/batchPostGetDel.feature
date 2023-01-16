Feature: Batch module POST,GET and DEl request

  Scenario Outline: POST/create a batch
    Given A Service with URL (Create Batch)
    When POST request is made with parameters at path "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
    Then validate the status code
    And save the batch ID
    Then validate the necessary fields "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
    Then get the batch details using created batch ID
    And validate the necessary fields "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>"
    Then delete the batch Id that is created
    And validate the response message


#
    Examples:
      | batchName                     | batchDescription | batchStatus | batchNoOfClasses | programId |
      | Jan14-Interface Strikers 0089 | API Testing      | Active      | 15               | 458       |
      | Jan23 - Interface 57          | Automation       | Active      | 12               | 458       |