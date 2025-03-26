@LMS
Feature: Logout Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @logout
  Scenario Outline: Logout functionality with different values from Tese data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS GET request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for logout

    Examples: 
      | TestCaseID   | scenario         | Sheetname |
      | TC_01_logout | Invalid Endpoint | login     |
      

      
    @validlogout
    
    Scenario: Validating valid logout
    
     Given Admin is on base url with valid auth
    When The Admin sends HTTPS GET request for logout as "login" and "TC_02_logout"
    Then The Admin gets response code and message as "login" and "TC_02_logout" for successfull logout
    
    