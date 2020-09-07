package Udemy_Selenium.Udemy_Selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderLogic 
{

	public static void main(String[] args)
	{

		//System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		//April 23
		driver.findElementByXPath(".//*[@id='travel_date']").click();
		//check for specific month in calender
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
			//iterate for next available month
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		//click on respective day by locating common attribute
		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}


