package Udemy_Selenium.Udemy_Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalPropertyDrive 
{

public static void main(String[] args) throws IOException 
{
Properties prop=new Properties();
FileInputStream fis =new FileInputStream("D:\\Automation\\GithubAssignment\\Udemy_Selenium\\data.properties");
//to load property file
prop.load(fis);
System.out.println(prop.getProperty("browser"));
System.out.println(prop.getProperty("url"));
prop.setProperty("browser", "firefox");
System.out.println(prop.getProperty("browser"));
FileOutputStream fos =new FileOutputStream("D:\\Automation\\GithubAssignment\\Udemy_Selenium\\data.properties");
//to store new updates in property file

prop.store(fos, null);
} 
}

