package com.actitime.guru.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledElements {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://demoapps.qspiders.com/");
	driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();Thread.sleep(2000);
	driver.findElement(By.xpath("//li[text()='Disabled']")).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeAsyncScript("doucument.getElementById('name').value='Arun Bhandari';");Thread.sleep(2000);
	js.executeScript("doucument.getElementById('email').value='arun2020bhandari@gmail.com';");Thread.sleep(2000);
	js.executeScript("document.getElementById('password').value='arun2020bhandari';");Thread.sleep(2000);
	
	
	
	
	}

}
