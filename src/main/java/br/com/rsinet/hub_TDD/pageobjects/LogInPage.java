package br.com.rsinet.hub_TDD.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
public static WebElement element;
	
	public static WebElement lnk_CreateNewAccount(WebDriver driver) {
		return element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
	}
}
