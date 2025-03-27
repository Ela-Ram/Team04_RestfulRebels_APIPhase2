@LMS
Feature: Class Module Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @createclass
  Scenario Outline: Creating Class with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID | scenario | Sheetname |

  # | TC_01_class_post | valid data           | class     |
  # | TC_02_class_post | mandatory fields     | class     |
  # | TC_03_class_post | additional fields    | class     |
  # | TC_04_class_post | invalid data         | class     |
  #| TC_05_class_post | existing class topic | class     |
  #| TC_06_class_post | invalid endpoint     | class     |
  #| TC_07_class_post | no payload | class     |
  @getclass
  Scenario Outline: Get functionality for different endpoints for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <Endpoint> <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID | Endpoint | scenario | Sheetname |

   | TC_01_class_get | Get all class | valid    | class     |
  # | TC_02_class_get | Get all class | invalid Endpoint | class     |
  # | TC_03_class_get | Get all class | invalid method | class     |
  # | TC_04_class_get | Get class recordings by BatchId | valid    | class     |
  #	| TC_05_class_get | Get class recordings by BatchId | invalid BatchId    | class     |
  #| TC_06_class_get | Get class recordings by BatchId | invalid Endpoint    | class     |
  #| TC_07_class_get | Get class recordings by BatchId | invalid method    | class     |
  #	| TC_08_class_get | Get class by Topic| valid    | class     |
  #	| TC_09_class_get | Get class by Topic| invalid    | class     |
  #	| TC_10_class_get | Get class by Topic| invalid method   | class     |
  #| TC_11_class_get | Get class by Topic| invalid Endpoint   | class     |
  
  @deleteclass
  Scenario Outline: Delete functionality for different values for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Delete request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID      | scenario      | Sheetname |
     | TC_01_class_del | valid classID | class     |
     | TC_02_class_del | valid classID | class     |
      
      
      
      
      
      
      
      
      
      
      
      
      
