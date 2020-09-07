package authPopup_Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auth_handle {
//handling window authentication pop up
	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver","");
		WebDriver driver =new ChromeDriver();
		//https://the-internet.herokuapp.com/
		//http://Username:Password@SiteURL
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
	}

}
