package helperMethods;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MySharedObjects
{
	//public static WebDriver driver;
	
	Base baseObject;

	@Before("@LoginTests,@SortingTests")
	public WebDriver setUp()
	{
		baseObject = new Base();
		return baseObject.openBrowser();
	}
	
	@After("@LoginTests,@SortingTests")
	public void tearDown()
	{
		baseObject.openBrowser();
	}
}
