@LMS

Feature: User Module Functionality

Background: Admin is on Base URL
Given Admin is on base url with valid auth

@cleanclass
Scenario: Cleanup all the ClassId Generated
	Given Admin is on base url with valid auth
  When The Admin sends HTTPS DELETE request to clean up classid
  Then The Admin gets suceess code
 

 