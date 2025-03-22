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
      | TestCaseID  | scenario             | Sheetname |
      | TC_01_class | valid data           | class     |
     # | TC_02_class | mandatory fields     | class     |
    #  | TC_03_class | additional fields    | class     |
    #  | TC_04_class | invalid data         | class     |
     # | TC_05_class | existing class topic | class     |
     # | TC_06_class | invalid endpoint     | class     |
