package authPopup_Window;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Generic_Upload_download {

	public static void main(String[] args) throws InterruptedException, IOException {

		//System.setProperty("webdriver.chrome.driver","");
		String downloadPath=System.getProperty("user.dir")+"\\Downloaded";
		//for changing download prefrences
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions cOptions=new ChromeOptions();		
		cOptions.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver =new ChromeDriver(cOptions);		
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
		File f=new File(downloadPath+"\\Java_interview_Question.pdf");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			System.out.println("file found");
			if(f.delete())
				System.out.println("file deleted");
		}
		
		
		
		////*[@id="pickfiles"]
		
		//D:\Study Related\Udemy_Selenium\AutoiT
	}

}
////*[@id='processTask']/span[2]