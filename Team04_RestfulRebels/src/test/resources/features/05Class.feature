@LMS @class
Feature: Class Module Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @createclass
  Scenario Outline: Creating Class with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID       | scenario             | Sheetname |
      | TC_01_class_post | valid data           | class     |
      | TC_02_class_post | mandatory fields     | class     |
      | TC_03_class_post | additional fields    | class     |
      | TC_04_class_post | invalid data         | class     |
      | TC_05_class_post | existing class topic | class     |
      | TC_06_class_post | invalid endpoint     | class     |
      | TC_07_class_post | no payload           | class     |

 
  @updateclass&ClassRecordingpath
  Scenario Outline: Updating Class with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS PUT request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID               | scenario                      | Sheetname |
      | TC_01_class_put          | mandatory fields              | class     |
      | TC_02_class_put          | invalid classId               | class     |
      | TC_03_class_put          | additional fields             | class     |
      | TC_04_class_put          | invalid data                  | class     |
      | TC_05_class_put          | invalid Topic                 | class     |
      | TC_06_class_put          | invalid endpoint              | class     |
      | TC_07_class_put          | invalid BatchID               | class     |
      | TC_08_class_put          | Deleted ClassId               | class     |
      | TC_09_classAllRecord_put | valid class_get_allrecordings | class     |
      | TC_10_classAllRecord_put | invalidData allrecordings     | class     |
      | TC_11_classAllRecord_put | invalidData allrecordings     | class     |
      | TC_12_classAllRecord_put | invalidData allrecordings     | class     |
      | TC_13_classAllRecord_put | invalidData allrecordings     | class     |

 
  @getclassvalid
  Scenario Outline: Get functionality for different endpoints for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <Endpoint> <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID      | Endpoint                        | scenario | Sheetname |
      | TC_01_class_get | Get all class                   | valid    | class     |
      | TC_04_class_get | Get class recordings by BatchId | valid    | class     |
      | TC_08_class_get | Get class by Topic              | valid    | class     |
      | TC_12_class_get | Get class by classId            | valid    | class     |
      | TC_13_class_get | Get class by BatcId             | valid    | class     |
      | TC_14_class_get | Get class by staffId            | valid    | class     |
      | TC_15_class_get | Get all recordings              | valid    | class     |
      | TC_16_class_get | Get recordings by classId       | valid    | class     |

  @getclassinvalid
  Scenario Outline: Get functionality for different endpoints for class invalid scenarios
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for scenarios as input "<Sheetname>" and "<TestCaseID>" for Class invalid
    Then The Admin get response code and message as "<Sheetname>" and "<TestCaseID>" for Class invalid

    Examples: 
      | TestCaseID      | scenario                        | Sheetname |
      | TC_02_class_get | Get all class  invalid Endpoint | class     |
      | TC_03_class_get | Get all class  invalid method   | class     |
      | TC_05_class_get | Get by id and topic             | class     |
      | TC_06_class_get | Get by id and topic             | class     |
      | TC_07_class_get | Get by id and topic             | class     |
      | TC_09_class_get | Get by id and topic             | class     |
      | TC_10_class_get | Get by id and topic             | class     |
      | TC_11_class_get | Get by id and topic             | class     |
      | TC_17_class_get | Get by id and topic             | class     |
      | TC_18_class_get | Get by id and topic             | class     |
      | TC_19_class_get | Get by id and topic             | class     |
      | TC_20_class_get | Get by id and topic             | class     |
      | TC_21_class_get | Get by id and topic             | class     |
      | TC_22_class_get | Get by id and topic             | class     |
      | TC_23_class_get | Get by id and topic             | class     |
      | TC_24_class_get | Get by id and topic             | class     |
      | TC_25_class_get | Get by id and topic             | class     |
      | TC_26_class_get | Get all class  invalid Endpoint | class     |
      | TC_27_class_get | Get all class  invalid method   | class     |
      | TC_28_class_get | Get by id and topic             | class     |
      | TC_29_class_get | Get by id and topic             | class     |
      | TC_30_class_get | Get by id and topic             | class     |


 @deleteclass
  Scenario Outline: Delete functionality for different values for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Delete request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin  response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID      | scenario         | Sheetname |
      | TC_02_class_del | invalid Endpoint | class     |
      | TC_03_class_del | invalid classId  | class     |
      | TC_01_class_del | valid classID    | class     |


 
  @changeStatus
  Scenario: Change the classId status to Active for chaining
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS PUT request as input "class" and "TC_01_class_chaining" for Class
    Then The Admin  response code and message as "class" and "TC_01_class_chaining" for Class
