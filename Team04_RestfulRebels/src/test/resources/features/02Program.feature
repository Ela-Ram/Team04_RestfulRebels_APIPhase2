@Program
Feature: Program Module Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @CreateProgram
  Scenario Outline: Creating user with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Program
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Program

    Examples: 
      | TestCaseID         | scenario               | Sheetname |
      | TC_01_post_program | valid data             | program   |
      | TC_02_post_program | invalid endpoint       | program   |
      | TC_03_post_program | existing ProgramName   | program   |
      | TC_04_post_program | invalid Method         | program   |
      | TC_05_post_program | invalid RequestBody    | program   |
      | TC_06_post_program | missingMandatoryField  | program   |
      | TC_07_post_program | missingAdditionalField | program   |
      | TC_08_post_program | No Payload             | program   |

  @PutProgram
  Scenario Outline: Put Requests with different endpoints for Program
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS PUT request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Program
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for update Program

    Examples: 
      | TestCaseID        | scenario                                  | Sheetname |
      | TC_01_put_program | valid update program byprogramId          | program   |
      | TC_02_put_program | update by invalid ProgramIdinPath         | program   |
      | TC_03_put_program | update by invalid Postbody                | program   |
      | TC_04_put_program | update by without payload                 | program   |
      | TC_05_put_program | update by invalid Method                  | program   |
      | TC_06_put_program | update by missing ProgramId inPath        | program   |
      | TC_07_put_program | update by invalid ProgramName inPath      | program   |
      | TC_08_put_program | update by missing ProgramName             | program   |
      | TC_09_put_program | update by invalid ProgramNameField        | program   |
      | TC_10_put_program | update by invalid ProgramDescrip          | program   |
      | TC_11_put_program | update by invalidEndpoint                 | program   |
      | TC_12_put_program | update by missingMandatoryField           | program   |
      | TC_16_put_program | valid update byProgrameName invalidmethod | program   |
    
     

  @GetallProgramandGetallwithusersValid
  Scenario Outline: Get Requests with different endpoints for Program valid
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for program
    Then The Admin get <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for get program

    Examples: 
      | TestCaseID | scenario | Sheetname |

  | TC_01_get_program | Get_allPrograms valid                   |program   |
  | TC_04_get_program | Get_allPrograms_Users valid             |program   |
  | TC_07_get_program | Get_Program_ProgramId valid ProgramId   |program   |
  
  @GetallProgramandGetallwithusersInValid
  Scenario Outline: Get Requests with different endpoints for Program invalid
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for program invalid
    Then The Admin get response code and message as "<Sheetname>" and "<TestCaseID>" for get program invalid

    Examples: 
      | TestCaseID        | scenario                                | Sheetname |
      | TC_02_get_program | Get_allPrograms invalid Endpoint        | program   |
      | TC_03_get_program | Get_allPrograms invalid Method          | program   |
      | TC_05_get_program | Get_allPrograms_Users invaid Endpoint   | program   |
      | TC_06_get_program | Get_allPrograms_Users invalid Method    | program   |
      | TC_08_get_program | Get_Program_ProgramId invalid ProgramId | program   |
      | TC_09_get_program | Get_Program_ProgramId invaid Endpoint   | program   |

  
 
 