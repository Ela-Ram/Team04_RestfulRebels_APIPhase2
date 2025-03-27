@Batch
Feature: Batch Module Functionality

  Background: Admin is on Base URL
    Given Admin is on base url with valid auth

  @createbatch
  Scenario Outline: Creating batch with different values from Test data
    Given Admin is on base url with valid auth
    When The Admin sends Batch HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get Batch  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                    | Sheetname |
      | TC_01_batch | valid data                  | batch     |
      | TC_02_batch | existingbatchname           | batch     |
      | TC_03_batch | missing mandatory fields    | batch     |
      | TC_04_batch | invalidendpoint             | batch     |
      | TC_05_batch | missingadditionfields       | batch     |
      | TC_06_batch | invaliddataintherequestbody | batch     |
      | TC_07_batch | inactiveprogramid           | batch     |

  @GetAllbatches
  Scenario Outline: Get all batches from the database
    Given Admin is on base url with valid auth
    When The Admin sends get all Batches HTTPS  request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get GetallBatch  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                         | Sheetname |
      | TC_08_batch | succesfulretrieving              | batch     |
      | TC_09_batch | getallbatcheswithinvalidendpoint | batch     |
      | TC_10_batch | getallbatcheswithsearchstring    | batch     |

  @GetbatchbyBatchId
  Scenario Outline: Get all batches by Batchid
    Given Admin is on base url with valid auth
    When The Admin sends get BatchbyBatchid HTTPS  request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get BatchbyBatchid  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                             | Sheetname |
      | TC_11_batch | succesfulretrievingbybatchid         | batch     |
      | TC_12_batch | retrievethebatchidalredydeletedbatch | batch     |
      | TC_13_batch | retrievethebatchbyinvalidbatchid     | batch     |
      | TC_14_batch | retrievebatchbyinvalidendpoint       | batch     |

  @GetbatchbyBatchName
  Scenario Outline: Get all batches by batchname
    Given Admin is on base url with valid auth
    When The Admin sends get BatchbyBatchname HTTPS  request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get BatchbyBatchname  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                             | Sheetname |
      | TC_15_batch | succesfulretrievingbybatchname       | batch     |
      | TC_16_batch | retrievethebatchidalredydeletedbatch | batch     |
      | TC_17_batch | retrievethebatchbyinvalidbatchname   | batch     |
      | TC_18_batch | retrievebatchbyinvalidendpoint       | batch     |

  @GetbatchbyProgramId
  Scenario Outline: Get batches by ProgramID
    Given Admin is on base url with valid auth
    When The Admin sends get BatchbyProgramId HTTPS  request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get BatchbyProgramId  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                              | Sheetname |
      | TC_19_batch | succesfulretrievingbyprogramid        | batch     |
      | TC_20_batch | retrievethebatchidbyinactiveprogramid | batch     |
      | TC_21_batch | retrievethebatchbyinvalidprogramid    | batch     |
      | TC_22_batch | retrievebatchbyinvalidendpoint        | batch     |
      
      @DeletebatchbyBatchId
  Scenario Outline: Deleting the batch by batch id
    Given Admin is on base url with valid auth
    When The Admin sends delete BatchbyBatchId HTTPS  request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get deleteBatchbyBatchId  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID  | scenario                         | Sheetname |  
      | TC_23_batch | succesfulbatchdeletebybatchid    | batch     |  
      | TC_24_batch | retrievethebatchbyinvalidbatchid | batch     |  
      | TC_25_batch | deletebatchbyinvalidendpoint     | batch     |  
      

  @Updatebatch
  Scenario Outline: Update the batchby Batchid
    Given Admin is on base url with valid auth
    When The Admin sends UpdateBatchbyBatchid HTTPS POST request for <scenario> scenarios as input "<Sheetname>" and "<TestCaseID>"
    Then The Admin get UpdateBatchbyBatchid  <scenario> response code and message as "<Sheetname>" and "<TestCaseID>"

    Examples: 
      | TestCaseID        | scenario                                     | Sheetname |
      | TC_32_batch       | successfulupdatebyvalidbatchid               | batch     |
      | TC_27_batch       | updatebyinvalidbatchid                       | batch     |
      | TC_28_batch       | updatebymissingmandatoryfieldsbyvalidbatchid | batch     |
      | TC_29_batch       | invaliddataintherequestbody                  | batch     |
      | TC_30_batch       | invalid endpoint                             | batch     |
      | TC_31_batch       | updatebyinactiveprogramidbyvalidbatchid      | batch     |
      | TC_26_batch       | updatebydeletedbatchid                       | batch     |
      | TC_01_batchActive | updatebydeletedbatchid                       | batch     |
