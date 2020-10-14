package helperMethods;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MySharedObjects
{
	Base baseObject;

	@Before("@LoginTests,@SortingTests,@AddProductsToBasketTests,@CheckoutProductsFromBasketTests")
	public WebDriver setUp()
	{
		baseObject = new Base();
		return baseObject.openBrowser();
	}
	
	@After("@LoginTests,@SortingTests,@AddProductsToBasketTests,@CheckoutProductsFromBasketTests")
	public void tearDown()
	{
		baseObject.closeBrowser();
	}
}
