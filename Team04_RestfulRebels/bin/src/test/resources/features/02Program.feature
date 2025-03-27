@LMS
Feature: Program Module Functionality


  Background: Admin is on Base URL ss
   Given Admin is on base url with valid auth


  @createuser
  Scenario Outline: Creating user with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Program
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Program

    Examples: 
      | TestCaseID | scenario     | Sheetname |
      | TC_01_user | valid data   | program      |
    
     