@LMS @cleanup

Feature: User Module Functionality

Background: Admin is on Base URL
Given Admin is on base url with valid auth



@cleanclass
Scenario: Cleanup all the ClassId Generated
	Given Admin is on base url with valid auth
  When The Admin sends HTTPS DELETE request to clean up classid
  Then The Admin gets success code
 
 @DeleteProgrambyname
  Scenario Outline: Delete Requests with different endpoints for Program
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS DELETE request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Program
    Then The Admin get response code and message as "<Sheetname>" and "<TestCaseID>" for delete Program

    Examples: 
      | TestCaseID           | scenario                   | Sheetname |
      | TC_03_delete_program | delete valid ProgramName   | program   |
      | TC_04_delete_program | delete Invalid ProgramName | program   |

 @cleanprogram
Scenario: Cleanup all the ProgramId Generated
	Given Admin is on base url with valid auth
  When The Admin sends HTTPS DELETE request to clean up programid
   Then The Admin gets success code
   
   @deleteuser
  Scenario Outline: Delete functionality for different values for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Delete request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID     | scenario       | Sheetname |
      | TC_01_user_del | valid userID   | user      |
      | TC_02_user_del | invalid userID | user      |
   
   
@cleanuser
 Scenario: Cleanup all the UserId Generated
	Given Admin is on base url with valid auth
  When The Admin sends HTTPS DELETE request to clean up userid
  Then The Admin gets success code
  
    
@cleanBatch
 Scenario: Cleanup all the UserId Generated
	Given Admin is on base url with valid auth
  When The Admin sends HTTPS DELETE request to clean up BatchId
  Then The Admin gets success code