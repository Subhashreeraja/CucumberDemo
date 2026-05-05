Feature: Login

Description: Login to the Demoblaze Application


  
  
   
 @invalidCredentials
Scenario Outline: Login with invalid credentials
  Given user is on the HomePage
  When user clicks the login link
  When user enters username as "<username>" and password as "<password>"
  And user clicks the log in button
  Then User should see the "<error message>"
  
  Examples:
  |username| password|error message|
  |Admin|1234|wrong password|
  |admin@|admin123|User does not exist|
  |   |   |Please fill out Username and Password.|
  
  
  