package authPopup_Window;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoITDemo {

	public static void main(String[] args) throws InterruptedException, IOException {

		//System.setProperty("webdriver.chrome.driver","");
		WebDriver driver =new ChromeDriver();
		//site that give authantication popup
		//https://the-internet.herokuapp.com/
		
		//approach to handle authentication popup
		//http://Username:Password@SiteURL
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.xpath("//*[@id='pickfiles']/span")).click();
		Thread.sleep(3000);
		//to upload file
		Runtime.getRuntime().exec("D:\\Study Related\\Udemy_Selenium\\AutoiT\\fileupload.exe");
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"processTask\"]/span[2]"));
		WebDriverWait wb=new WebDriverWait(driver,10);
		//to convert file word to pdf
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='processTask']/span[2]")));
		driver.findElement(By.xpath("//*[@id='processTask']/span[2]")).click();
		//to download converted file 
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pickfiles']")));
		driver.findElement(By.xpath("//*[@id='pickfiles']")).click();
		//check for the file availability 
		File f=new File("C:\\Users\\acer a\\Downloads\\Java_interview_Question.pdf");
		if(f.exists())
		{
			System.out.println("file found");
		}
		
		
		
		////*[@id="pickfiles"]
		
		//D:\Study Related\Udemy_Selenium\AutoiT
	}

}
////*[@id='processTask']/span[2]