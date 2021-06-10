package com.cyient.seleniumbasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenEMRLogin {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		//dropdown
		Select selectLanguage=new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		 
		driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();
		
		Actions action1=new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//div[ @ data-bind='text:label']"))).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Patients')]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ src='/a/openemr/interface/main/finder/dynamic_finder.php']")));
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ src='/a/openemr/interface/new/new.php']")));
		Select sirname=new Select(driver.findElement(By.id("form_title")));
		sirname.selectByValue("Mr.");
		driver.findElement(By.id("form_fname")).sendKeys("xYZ");
		driver.findElement(By.id("form_mname")).sendKeys("ABC");
		driver.findElement(By.id("form_lname")).sendKeys("PQRS");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-06-04");
		
		Select sex =new Select(driver.findElement(By.id("form_sex")));
		sex.selectByValue("Male");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@ id='modalframe']")));
		driver.findElement(By.xpath("//input[@ value='Confirm Create New Patient']")).click();
		//Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		
		//driver.switchTo().alert().accept();
        		// I am not able to understand alert, Please explain one more time
		
		 
	}
	
	

}
