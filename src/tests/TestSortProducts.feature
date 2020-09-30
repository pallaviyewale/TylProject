Feature: Sorting Products Functionality

@SortingTests
Scenario Outline: Check user can sort the products
Given Login with valid user "standard_user" and password "secret_sauce"
When Sort products by <value>
Then Products should be sorted by <value>

Examples: 
| value                |
| Price (low to high)  |
| Price (high to low)  |
| Name (Z to A)        |
| Name (A to Z)        |