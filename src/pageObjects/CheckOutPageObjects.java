package pageObjects;

import org.openqa.selenium.By;

public class CheckOutPageObjects 
{
	public By firstNameBy = By.id("first-name");
	public By lastNameBy = By.id("last-name");
	public By zopCodeBy = By.id("postal-code");
	public By continueBy = By.xpath("//input[@value='CONTINUE']");
	
	public By finishBy = By.xpath("//a[text()='FINISH']");
	public By confirmationMessageBy = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
}
