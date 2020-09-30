package stepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helperMethods.MySharedObjects;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class SortProductsStepDefination
{
	private WebDriver driver;
	
	public SortProductsStepDefination(MySharedObjects hk)
	{
		this.driver = hk.setUp();
	}
	
	@When("^Sort products by (.+)$")
	public void sortProducts(String value) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement sortElement = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sortParam = new Select(sortElement);
		sortParam.selectByVisibleText(value);
		Thread.sleep(1000);
	}
	
	@Then("^Products should be sorted by (.+)$")
	public void checkLockedUserNotLoggedIn(String value)
	{
		boolean sortingStatus = false;
		List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<WebElement> prodctNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<Double> priceList = new ArrayList<Double>();
		List<String> nameList = new ArrayList<String>();
		for(WebElement ele : productsPrice)
		{
			String price = ele.getText();
			priceList.add(Double.parseDouble(price.substring(1, 5)));
		}
		
		for(WebElement ele : prodctNames)
		{
			String name = ele.getText();
			nameList.add(name);
		}
		
		if (value.equals("Price (low to high)"))
		{
			for(int i = 0;i<priceList.size()-1;i++)
			{
				if(priceList.get(i) < priceList.get(i+1))
					sortingStatus = true;
			}
		}
		
		if (value.equals("Price (high to low)"))
		{
			for(int i = 0;i<priceList.size()-1;i++)
			{
				if(priceList.get(i) > priceList.get(i+1))
					sortingStatus = true;
			}
		}
		
		if (value.equals("Name (A to Z)"))
		{
			
			for(int i = 0;i<nameList.size()-1;i++)
			{
				if(nameList.get(i).compareTo(nameList.get(i+1)) < 0)
					sortingStatus = true;
			}
		}
		
		if (value.equals("Name (Z to A)"))
		{
			for(int i = 0;i<nameList.size()-1;i++)
			{
				if(nameList.get(i).compareTo(nameList.get(i+1)) > 0)
					sortingStatus = true;
			}
		}
		
		Assert.assertTrue(sortingStatus);
	}

}
