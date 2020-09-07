package Udemy_Selenium.Udemy_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs 
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		//getting link count of complete page
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		//getting link count of footer links
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		//getting link count of column
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			//for opening every link on new tab
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		}
		
		

	}

}
