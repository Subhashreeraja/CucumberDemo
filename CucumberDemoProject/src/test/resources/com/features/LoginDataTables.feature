Feature: Login

@ValidCredentials
Scenario: Login with valid credentials-Data Table without header

Given user is on the Demoblazepage
When user enters valid credentials
 |Admin| admin|
 Then user should be able to login successfully and new page open