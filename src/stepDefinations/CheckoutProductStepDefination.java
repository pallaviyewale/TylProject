package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import helperMethods.MySharedObjects;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.BasketPageObjects;
import pageObjects.CheckOutPageObjects;

@RunWith(Cucumber.class)
public class CheckoutProductStepDefination 
{
	private WebDriver driver;
    
	public CheckoutProductStepDefination(MySharedObjects hk)
	{
		driver = hk.setUp();
	}
	
	BasketPageObjects basketObjects = new BasketPageObjects();
	CheckOutPageObjects checkoutObjects = new CheckOutPageObjects();
	
	@When("^Click on Checkout$")
	public void clickOnCheckOut()
	{
		driver.findElement(basketObjects.checkoutBy).click();
	}
	
	@When("^Fill the user details- FirstName: \"([^\"]*)\" LastName: \"([^\"]*)\" ZipCode: \"([^\"]*)\"$")
	public void fillInUserDetails(String firstname,String lastname, String zipcode) throws InterruptedException
	{
		driver.findElement(checkoutObjects.firstNameBy).sendKeys(firstname);
		driver.findElement(checkoutObjects.lastNameBy).sendKeys(lastname);
		driver.findElement(checkoutObjects.zopCodeBy).sendKeys(zipcode);
		driver.findElement(checkoutObjects.continueBy).click();
		Thread.sleep(1000);		
	}
	
	@When("^Click on Finish$")
	public void clickOnFinish()
	{
		driver.findElement(checkoutObjects.finishBy).click();
	}
	
	@Then("^User should get confirmation message$")
	public void userShouldGetConfirmation()
	{
		String message = driver.findElement(checkoutObjects.confirmationMessageBy).getText();
		Assert.assertEquals(message, "THANK YOU FOR YOUR ORDER");
	}
}
