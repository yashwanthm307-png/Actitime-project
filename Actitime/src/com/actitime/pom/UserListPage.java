package com.actitime.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserListPage {
	@FindBy(id="username")
	private WebElement unTbx;
public UserListPage(WebDriver driver){
  PageFactory.initElements(driver,this);
}
  
}
