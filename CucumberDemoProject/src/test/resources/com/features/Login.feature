Feature: Login to the Demoblaze Application

Background:
  Given User is on the HomePage
  When user click the login link

@ValidCredentials 
Scenario: Login with valid credentials
  When user enters username as "Admin"
  And User enters password as "admin"
  And user click the log in button
  Then User should see the welcome message

@InValidCredentials
Scenario: Login with invalid credentials
  When user enters username as "Admin"
  And User enters password as "aaa"
  And user click the log in button
  Then User should see the popup message

@EmptyCredentials
Scenario: Login with empty credentials
  When user enters username as ""
  And User enters password as ""
  And user click the log in button
  Then User should not be able to login successfully