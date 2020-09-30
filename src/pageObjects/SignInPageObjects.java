package pageObjects;

import org.openqa.selenium.By;

//This is object repository for sign in page.
public class SignInPageObjects
{

	public By userNameBy = By.id("user-name");
	public By userPasswordBy = By.id("password");
	public By signInBy = By.id("login-button");
	
	public By signInFailedMessage = By.xpath("//h[@data-test='error']");
}