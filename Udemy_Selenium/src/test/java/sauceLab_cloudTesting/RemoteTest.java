package sauceLab_cloudTesting;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//pre-requisit: Login to Sauce Lab free trial for 14days
//SignIn with credentials
//generate access key as Account--->User Setting----->Access Key
//Refer Sauce Lab authenticated doc for ref:
//https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
//https://wiki.saucelabs.com/display/DOCS/Getting+Started+with+Selenium+for+Automated+Website+Testing

public class RemoteTest
{
	public static final String USERNAME = "Ashutosh1";
	public static final String ACCESS_KEY = "530379e2-2e28-4646-8b68-7bb84b905b7c";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");
		WebDriver driver=new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://google.com");
		driver.getTitle();
		
}
	
	
}