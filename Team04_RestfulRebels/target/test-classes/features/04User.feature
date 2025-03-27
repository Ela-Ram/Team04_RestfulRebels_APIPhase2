@LMS
Feature: User Module Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @createuser
  Scenario Outline: Creating User with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for User
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for User

    Examples: 
      | TestCaseID | scenario          | Sheetname |
      | TC_01_user | valid data        | user      |
      | TC_02_user | mandatory fields  | user      |
      | TC_03_user | additional fields | user      |
      | TC_04_user | invalid data      | user      |
      | TC_05_user | existing phn num  | user      |

  @getuser
  Scenario Outline: Get functionality for different endpoints for User
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <Endpoint> <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for User
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for User

    Examples: 
      | TestCaseID | Endpoint                 | scenario | Sheetname |
      | TC_06_user | Get all users            | valid    | user      |
      | TC_07_user | Get all active users     | valid    | user      |
      | TC_08_user | Get emails of all users  | valid    | user      |
      | TC_09_user | Get all roles            | valid    | user      |
      | TC_10_user | Get by user id           | valid    | user      |
      | TC_11_user | Get all users with roles | valid    | user      |
      | TC_12_user | Get count of A/I users   | valid    | user      |
      | TC_13_user | Get user by pgm batches  | valid    | user      |
      | TC_14_user | Get users for program    | valid    | user      |
      | TC_15_user | Get users by role id     | valid    | user      |
      | TC_16_user | Get users by role id V2  | valid    | user      |

  @putuser
  Scenario Outline: Get functionality for different endpoints for User
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Put request for <Endpoint> <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for User
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for User

    Examples: 
      | TestCaseID | Endpoint                 | scenario               | Sheetname |
      | TC_17_user | update user by userid    | valid                  | user      |
      | TC_18_user | update user by userid    | invalid                | user      |
      | TC_19_user | update user by userid    | missing required field | user      |
      | TC_20_user | update userrole status   | valid                  | user      |
      | TC_21_user | assign user to pgm batch | valid                  | user      |
      | TC_22_user | assign user to pgm batch | invalid                | user      |
      | TC_23_user | assign user to pgm batch | missing required field | user      |
      | TC_24_user | update user login        | valid                  | user      |

  