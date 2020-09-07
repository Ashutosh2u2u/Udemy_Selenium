package sauceLab_cloudTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//pre-requisit: Login to Sauce Lab free trial for 14days
//SignIn with credentials
//generate access key as Account--->User Setting----->Access Key
//Refer Sauce Lab authenticated doc for ref:
//https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
//https://wiki.saucelabs.com/display/DOCS/Getting+Started+with+Selenium+for+Automated+Website+Testing

public class SauceLabsTest
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
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			//Brocolli - 1 Kg
			//Brocolli,    1 kg
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//  check whether name you extracted is present in arrayList or not-
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}
}
}

