Feature: Checkout Products from Basket Functionality

@CheckoutProductsFromBasketTests
Scenario Outline: Check user can checkout products from basket
Given Login with valid user "standard_user" and password "secret_sauce"
When Sort products by <value>
Then Products should be sorted by <value>
When Add "Second" product to Basket from sorted products
And Add "Last" product to Basket from sorted products
And Go to Basket
And Click on Checkout
And Fill the user details- FirstName: "John" LastName: "Lee" ZipCode: "CR0N 6BP"
And Click on Finish
Then User should get confirmation message

Examples: 
| value                |
| Price (high to low)  |
