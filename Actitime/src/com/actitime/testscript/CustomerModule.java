package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		String custName = f.readExcelData("createCustomer", 1, 1);
		String desc = f.readExcelData("createCustomer", 1, 2);
		HomePage h=new HomePage(driver);
		h.setTasks();
//		driver.findElement(By.linkText("TASKS")).click();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
//		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		t.getNewCustomerBtn().click();
//		driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
		t.getCustNameTbx().sendKeys(custName);
//		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("ICICI-001");
		t.getCustDescTbx().sendKeys(desc);
//		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("banking");
		t.getExistingCustomerDropdown().click();
//		driver.findElement(By.id("customerLightBox_customerSelectorPlaceholder")).click();
		t.getOurCompanyLink().click();
//		driver.findElement(By.linkText("Our Company")).click();
		t.getCreateCustomerButton().click();
//		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		String actualText = t.getConfirmationMsg().getText();
//		String text = driver.findElement(By.className("innerHtml")).getText();
//		System.out.println(text);
		Assert.assertEquals(actualText, "Customer '"+custName+"' has been created");
	}
	
	@Test
	public void deleteCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage h=new HomePage(driver);
		h.setTasks();
		String customerName = f.readExcelData("createCustomer", 1, 1);
//		driver.findElement(By.linkText("TASKS")).click();
		TaskListPage t=new TaskListPage(driver);
		
		t.getSearchBox().sendKeys(customerName);
//		driver.findElement(By.xpath("//input[@placeholder='Start typing name ...']")).sendKeys("Virat");
		t.getSettingsBtn().click();
//		driver.findElement(By.xpath("//span[@class='highlightToken']/../../div[@class='editButton available']")).click();
		Thread.sleep(2000);
		t.getActionsBtn().click();
//	driver.findElement(By.xpath("//div[contains(@class,'edit_customer_sliding_panel')]//div[text()='ACTIONS']")).click();
		t.getDeleteBtn().click();
//	driver.findElement(By.xpath("//div[contains(@class,'edit_customer_sliding_panel')]//div[text()='Delete']")).click();
		t.getDeletePermBtn().click();
//		driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
		String actualText = t.getConfirmationMsg().getText();
//		String text = driver.findElement(By.className("innerHtml")).getText();
//		System.out.println(text);
		Assert.assertEquals(actualText, "Customer '"+customerName+"' has been deleted");
	}
}
