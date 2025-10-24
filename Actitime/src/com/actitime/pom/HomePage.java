package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(linkText = "TASKS")
private WebElement tasksLink;
@FindBy(id="logoutLink")
private WebElement logoutLink;
@FindBy(linkText = "USERS")
private WebElement usersLink;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setTasks() {
	tasksLink.click();
}
public void setLogout() {
	logoutLink.click();
}
public void setUsers() {
	usersLink.click();
}
}
