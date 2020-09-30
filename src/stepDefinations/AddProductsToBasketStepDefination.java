package stepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import helperMethods.MySharedObjects;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.BasketPageObjects;
import pageObjects.ProductListPageObjects;

@RunWith(Cucumber.class)
public class AddProductsToBasketStepDefination 
{
	private WebDriver driver;
    
	public AddProductsToBasketStepDefination(MySharedObjects hk)
	{
		driver = hk.setUp();
	}
	
	ProductListPageObjects productObjects = new ProductListPageObjects();
	BasketPageObjects basketObjects = new BasketPageObjects();
	
	@When("^Add \"([^\"]*)\" product to Basket from sorted products$")
	public void addProductToBasket(String productNumber)
	{
		List<String> productList= new ArrayList<String>();
		List<WebElement> elements = driver.findElements(productObjects.productNameBy);
		String productName = "";
		
		for(WebElement ele : elements)
		{
			productList.add(ele.getText());
		}

		if(productNumber.equals("First"))
		{
			productName = productList.get(0);
		}
		else
		if(productNumber.equals("Second"))
		{
			productName = productList.get(1);
		}
		if(productNumber.equals("Last"))
		{
			productName = productList.get(productList.size()-1);
		}
			
		String str = "//div[text()='%s']/../../..//button[@class='btn_primary btn_inventory']";
		driver.findElement(By.xpath(String.format(str,productName))).click();
		
	}
	
	@When("^Go to Basket$")
	public void goToBasket()
	{
		driver.findElement(By.xpath("//a[@href='./cart.html']")).click();
	}
	
	@Then("^\"([^\"]*)\" product should be in basket$")
	public void verifyProductsFromBasket(int productNumber)
	{
		List<WebElement> elements = driver.findElements(productObjects.productNameBy);
		int itemCount = elements.size();
		Assert.assertEquals(itemCount, productNumber);
	}
	
}
