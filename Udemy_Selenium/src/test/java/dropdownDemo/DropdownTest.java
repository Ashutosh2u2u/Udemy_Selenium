package dropdownDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import library.BrowserLaunch;

public class DropdownTest {
	static WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
		driver=BrowserLaunch.launchBrowser();
		//Handle Static dropdown
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		WebElement drop1=driver.findElement(By.xpath("//select[contains(@id,'mainContent_ddl_Adult')]"));
		Select s=new Select(drop1);
		s.selectByIndex(4);
		s.selectByValue("6");
		s.selectByVisibleText("7");
		//Handle dynamic dropdowns
		driver.close();
	}

}
