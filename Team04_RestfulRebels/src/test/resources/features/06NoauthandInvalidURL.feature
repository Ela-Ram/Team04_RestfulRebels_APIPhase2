@LMS
Feature: Scenarios with No auth and Invalid Url





@logoutnoauth
  Scenario: Validating valid logout with no auth
    Given Admin is on base url with no auth
    When The Admin sends HTTPS GET request for logout as "login" and "TC_01_logout_noauth" for no auth
    Then The Admin gets response code and message as "login" and "TC_01_logout_noauth" for logout for no auth



  @classnoauth
  Scenario Outline: Validating different Crud Operations with no auth
    Given Admin is on base url with no auth
    When The Admin sends <scenario> request with no auth as input "<Sheetname>" and "<TestCaseID>" for class
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for class

    Examples: 
      | TestCaseID         | scenario                            | Sheetname |
      | TC_01_class_noAuth | createclass                         | class     |
      | TC_02_class_noAuth | class_get_allclasslist              | class     |
      | TC_03_class_noAuth | class_get_classrecordings_bybatchid | class     |
      | TC_04_class_noAuth | class_get_classdetails_byclassid    | class     |
      | TC_05_class_noAuth | class_get_allclasses_bybatchid      | class     |
      | TC_06_class_noAuth | class_get_allclasses_bystaffid      | class     |
      | TC_07_class_noAuth | class_get_allrecordings             | class     |
      | TC_08_class_noAuth | class_get_classrecordings_byclassid | class     |
      | TC_09_class_noAuth | class_get_byclasstopic              | class     |
      | TC_10_class_noAuth | class_put_newclass                  | class     |
      | TC_11_class_noAuth | class_put_class_recording_path      | class     |
      | TC_12_class_noAuth | class_delete_byclassid              | class     |

  

  @LMSInvalidURLClass
  Scenario Outline: Validating LMS API using CRUD operations with Invalid URL
    Given Admin is on base url with Invalid URL
    When The Admin sends <scenario> request with invalid url as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for class

    Examples: 
      | TestCaseID             | scenario   | Sheetname |
      | TC_01_class_InvalidURL | Class Post | class     |

  @batchnoauth
  Scenario Outline: Validating different Crud Operations with no auth
    Given Admin is on base url with no auth
    When The Admin sends batch <scenario> request with no auth as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin gets batch response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID         | scenario                    | Sheetname |
      | TC_01_batch_noAuth | createbatchnoauth           | batch     |
      | TC_02_batch_noAuth | getallbatchesnoauth         | batch     |
      | TC_03_batch_noAuth | getbatchbybatchidsnoauth    | batch     |
      | TC_04_batch_noAuth | getbatchbybatchnamessnoauth | batch     |
      | TC_05_batch_noAuth | getbatchbyprogramidsnoauth  | batch     |
      | TC_06_batch_noAuth | updatebatchbybatchidsnoauth | batch     |
      | TC_07_batch_noAuth | deletebatchbybatchidsnoauth | batch     |

  @programnoauth
  Scenario Outline: Validating different Crud Operations with no auth
    Given Admin is on base url with no auth
    When The Admin sends <scenario> request with no auth as input "<Sheetname>" and "<TestCaseID>" for program
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for program

    Examples: 
      | TestCaseID           | scenario                          | Sheetname |
      | TC_01_program_noAuth | createprogram                     | program   |
      | TC_02_program_noAuth | program_get_allprogramlist        | program   |
      | TC_03_program_noAuth | program_get_Get_allPrograms_Users | program   |
      | TC_04_program_noAuth | program_Get_Program_ProgramId     | program   |
      | TC_05_program_noAuth | program_put_byProgramId           | program   |
      | TC_06_program_noAuth | program_put_byprogramName         | program   |
      | TC_07_program_noAuth | program_delete_byProgramId        | program   |
      | TC_08_program_noAuth | program_delete_byprogramName      | program   |

  @ProgramInvalidUrl
  Scenario Outline: Validating LMS API using CRUD operations with Invalid URL
    Given Admin is on base url with Invalid URL
    When The Admin sends <scenario> request with invalid url as input "<Sheetname>" and "<TestCaseID>" for program
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for program

    Examples: 
      | TestCaseID               | scenario    | Sheetname |
      | TC_01_program_InvalidURL | createclass | class     |
