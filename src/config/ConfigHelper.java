package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//This class it to read config file and load all values in variables which can be passed to tests. 
//As this class is created as singleton class, no need to create object of this class.
public class ConfigHelper 
{
	private String url = null;
	private String loginUser = null;	
	private String loginPassword = null;	
	
	InputStream input = null;
	
	static ConfigHelper getconfig = new ConfigHelper();
	
	public static ConfigHelper getGetconfig() {
		return getconfig;
	}

	public String getUrl() 
	{
		return url;
	}
	public String getLoginUser() 
	{
		return loginUser;
	}

	public String getLoginPassword() 
	{
		return loginPassword;
	}
	
	private ConfigHelper()
	{
		ReadProperties();
	}
	
	private void ReadProperties()
	{
		Properties prop = new Properties();
		try 
		{
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		url = prop.getProperty("url");
		loginUser = prop.getProperty("loginUser");
		loginPassword = prop.getProperty("loginUserPassword");
	}
	
}
