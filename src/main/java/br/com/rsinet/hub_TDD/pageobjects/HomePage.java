package br.com.rsinet.hub_TDD.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public static WebElement element;
	
	public static WebElement lnk_MenuUser(WebDriver driver) {
		return element = driver.findElement(By.id("menuUser"));
	}
	
	
	public static WebElement lnk_MenuSearch(WebDriver driver) {
		return element = driver.findElement(By.xpath("//*[@id=\"menuSearch\"]"));
	}
	
	public static WebElement lnk_Speakers(WebDriver driver) {
		return element = driver.findElement(By.id("speakersImg"));
	}
}
