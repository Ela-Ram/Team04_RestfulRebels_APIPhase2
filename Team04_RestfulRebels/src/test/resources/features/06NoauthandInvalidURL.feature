@LMS
Feature: Scenarios with No auth and Invalid Url

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

@logoutnoauth
Scenario: Validating valid logout with no auth
    
     Given Admin is on base url with no auth
    When The Admin sends HTTPS GET request for logout as "login" and "TC_01_logout_noauth"
     Then The Admin gets response code and message as "login" and "TC_01_logout_noauth" for logout

    

  @LMSInvalidURL
  Scenario Outline: Validating LMS API using CRUD operations with Invalid URL
    Given Admin is on base url with Invalid URL
    When The Admin sends <scenario> request with invalid url as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin gets response code and message as "<Sheetname>" and "<TestCaseID>" for class

    Examples: 
      | TestCaseID             | scenario   | Sheetname |
      | TC_01_class_InvalidURL | Class Post | class     |

      
      
      
      
      
      
      
      
      
      
      
      