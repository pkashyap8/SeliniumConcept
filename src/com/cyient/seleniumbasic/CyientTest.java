package com.cyient.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CyientTest {

	public static void main(String[] args) {
		
		//class---> ChromeDriver
		//non static method----> getTitle(), getCurrenturl()
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.cyient.com/");
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		
	}

}
