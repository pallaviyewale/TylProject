Feature: Login Functionality

@LoginTests
Scenario Outline: Check user can login with valid credentials
Given Open Main page
And Enter User Credentials on login page with <username> and password <password>
When Click on Login
Then User Should be logged in

Examples: 
| username       | password     | 
| standard_user  | secret_sauce | 


@LoginTests
Scenario Outline: Check that locked user cannot login to system
Given Open Main page
Given Enter User Credentials on login page with <username> and password <password>
When Click on Login
Then Locked User Should not be logged in

Examples: 
| username         | password     | 
| locked_out_user  | secret_sauce | 


@LoginTests
Scenario Outline: Check user cannot be logged in with invalid credentials
Given Open Main page
Given Enter User Credentials on login page with <username> and password <password>
When Click on Login
Then Invalid User Should not be logged in

Examples: 
| username       | password     | 
| invalis_user   | secret_sauce | 