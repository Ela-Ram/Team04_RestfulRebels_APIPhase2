@LMS
Feature: Login Functionality

  @login
  Scenario Outline: Login functionality with different values from Tese data
    Given The Admin creates POST request for login
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario          | Sheetname |
      | TC_01_login | valid credentials | login     |
      | TC_02_login | invalid username  | login     |
      | TC_03_login | invalid password  | login     |
      | TC_04_login | invalid Endpoint  | login     |
      | TC_05_login | empty username    | login     |
      | TC_06_login | empty password    | login     |
