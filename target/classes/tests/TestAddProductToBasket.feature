Feature: Add Products to Basket Functionality

@AddProductsToBasketTests
Scenario Outline: Check user can add selected products in basket
Given Login with valid user "standard_user" and password "secret_sauce"
When Sort products by <value>
Then Products should be sorted by <value>
When Add "First" product to Basket from sorted products
And Go to Basket
Then "1" product should be in basket

Examples: 
| value                |
| Price (high to low)  |
