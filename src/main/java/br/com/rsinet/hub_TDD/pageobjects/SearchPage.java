package br.com.rsinet.hub_TDD.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_TDD.utility.ExcelUtils;

public class SearchPage {
	public static WebElement element;
	
	public static WebElement txtbx_Search(WebDriver driver) {
		return element = driver.findElement(By.id("autoComplete"));
	}
	
	public static WebElement lnk_Product(WebDriver driver) throws Exception {
		return element = driver.findElement(By.partialLinkText(ExcelUtils.getCellData(1, 0).toUpperCase()));
	}

	public static WebElement lnk_AddToCart(WebDriver driver) throws Exception {
		return element = driver.findElement(By.name("save_to_cart"));
	}
	
	public static WebElement lnk_menuCart(WebDriver driver) {
		return element = driver.findElement(By.id("menuCart"));
	}
}
