# TylProject


I have covered scenarios related to test only. But in actual framework I can cover many things like page action classes of each page,
scenarios for each functionality, more validations.



Project Structure - 


src-

	config -
	
		ConfigHelper - To read all configuration from properties file
		
	helperMethods -
	
		Hooks with Dependency Injections to share Objects
		
	pageObjects -
	
		UI elements object repository for each page
		
	stepDefinations -
	
		Step definations for scenarios for all feature files


	tests -
	
		Feature Files
		- TestLogin.feature - Login functionality scenarios
		- TestSortProducts.feature - Sorting products functionality scenarios
		- TestAddProductToBasket.feature - Add products to basket functionality scenarios
		- TestCheckoutTheProducts.feature - Checkout the products functionality scenarios
		 
pom.xml -
		Dependencies - cucumber-java, junit, cucumber-junit, selenium-java, selenium-server, cucumber-picocontainer


To run the Scenarios -

		- Run TestRunner.java from IDE. 
