@DbF1 
Feature: Techfios login page with data extracted from databases 

@Db1 
Scenario: 1 User hould be abe to login with valid credentials 
	Given User is on Techfios login page with daata 
	When  User enter "username" from techfios with database 
	When  User enter "password" from techfios with database 
	And user clicks on Signin button with database 
	Then user should land on Dadhbord Page with database 
