Feature: To validate Login Functionality 

Scenario: To validate login function with invalid username and invalid password 
	Given User launch the facebook url 
	When User enters the username and password in FaceBook page 
	And User clicks the login button 
	Then User validates the login failure page 
	
