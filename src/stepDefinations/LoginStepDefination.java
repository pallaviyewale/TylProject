package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ConfigHelper;
import helperMethods.MySharedObjects;
import pageObjects.SignInPageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginStepDefination
{
	private WebDriver driver;
    SignInPageObjects signInObjects = new SignInPageObjects();
    
	public LoginStepDefination(MySharedObjects hk)
	{
		driver = hk.setUp();
	}


	@Given("^Open Main page$") 
	public void openMainPage() throws Throwable
	{
		//driver = Base.getDriver();
		//driver.manage().window().maximize();
		String url = ConfigHelper.getGetconfig().getUrl();
		driver.get(url);
	}
	
	@Given("^Enter User Credentials on login page with (.+) and password (.+)$")
	public void enterUserCredentials(String username, String password) throws Throwable
	{
		driver.findElement(signInObjects.userNameBy).clear();
		driver.findElement(signInObjects.userPasswordBy).clear();
		driver.findElement(signInObjects.userNameBy).sendKeys(username);
		driver.findElement(signInObjects.userPasswordBy).sendKeys(password);
	}
	
	@When("^Click on Login$")
	public void clickOnLogin() throws Throwable
	{
		driver.findElement(signInObjects.signInBy).click();
	}
	
	@Then("^User Should be logged in$")
	public void checkUserLoggedIn() throws Throwable
	{
		String message = "";
		try 
		{
			if(driver.findElement(By.xpath("//div[contains(text(),'Products')]")).isDisplayed())
			{
				message = driver.findElement(By.xpath("//div[contains(text(),'Products')]")).getText();
				Assert.assertEquals(message, "Products");
			}
		}
		catch(Exception e1)
		{
			System.out.println("User not logged in");
		}
	}
	
	@Then("^Locked User Should not be logged in$")
	public void checkLockedUserNotLoggedIn()
	{
		String message = "";
		try 
		{
			if(driver.findElement(signInObjects.signInFailedMessage).isDisplayed())
			{
				message = driver.findElement(signInObjects.signInFailedMessage).getText();
				Assert.assertEquals(message, "Epic sadface: Sorry, this user has been locked out");
			}
		}
		catch(Exception e2)
		{
			System.out.println("User logged in");
		}
	}
	
	@Then("^Invalid User Should not be logged in$")
	public void checkInvalidUserNotLoggedIn()
	{
		String message = "";
		try 
		{
			if(driver.findElement(signInObjects.signInFailedMessage).isDisplayed())
			{
				message = driver.findElement(signInObjects.signInFailedMessage).getText();
				Assert.assertEquals(message, "Epic sadface: Username and password do not match any user in this service");
			}
		}
		catch(Exception e2)
		{
			System.out.println("User logged in");
		}
	}
	
	@Given("^Login with valid user \"([^\"]*)\" and password \"([^\"]*)\"$") 
	public void loginWithValidUser(String username, String password) throws Throwable
	{
		openMainPage();
		enterUserCredentials(username,password);
		clickOnLogin();
	}
	
}
