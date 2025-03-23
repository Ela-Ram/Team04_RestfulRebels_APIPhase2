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
      | TestCaseID | scenario | Sheetname |

   | TC_01_class | valid data           | class     |
  # | TC_02_class | mandatory fields     | class     |
  # | TC_03_class | additional fields    | class     |
  # | TC_04_class | invalid data         | class     |
  # | TC_05_class | existing class topic | class     |
  #| TC_06_class | invalid endpoint     | class     |
  # | TC_07_class | no payload | class     |
  
  @get
  Scenario Outline: Get functionality for different endpoints for class
    Given Admin is on base url with valid auth
    When The Admin sends HTTPS Get request for <Endpoint> <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>" for Class
    Then The Admin get <Endpoint> <scenario> response code and message as "<Sheetname>" and "<TestCaseID>" for Class

    Examples: 
      | TestCaseID  | Endpoint                        | scenario | Sheetname |
      # | TC_08_class | Get all class | valid    | class     |
      # | TC_09_class | Get all class | invalid Endpoint | class     |
     # | TC_10_class | Get all class | invalid method | class     |
     # | TC_11_class | Get class recordings by BatchId | valid    | class     |
		#| TC_12_class | Get class recordings by BatchId | invalid BatchId    | class     |	
		#| TC_13_class | Get class recordings by BatchId | invalid Endpoint    | class     |		
		#| TC_14_class | Get class recordings by BatchId | invalid method    | class     |
		#| TC_15_class | Get class by Topic| valid    | class     |
		#| TC_16_class | Get class by Topic| invalid    | class     |
	#	| TC_17_class | Get class by Topic| invalid method   | class     |
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		