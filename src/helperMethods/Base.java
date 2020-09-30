package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public static WebDriver driver;

	public WebDriver openBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yewal\\Desktop\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
		if(driver==null)
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}

}
