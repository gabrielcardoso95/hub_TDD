package br.com.rsinet.hub_TDD.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	private static WebElement element;

	public static WebElement txtbx_UserName(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;

	}

	public static WebElement txtbx_UserEmail(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement txtbx_Password(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement txtbx_ConfirmPassword(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement txtbx_FirstName(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement txtbx_LastName(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement txtbx_PhoneNumber(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static WebElement lstbx_Country(WebDriver driver) {
		element = driver.findElement(By.name("countryListboxRegisterPage"));
		return element;
	}

	public static WebElement txtbx_City(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}

	public static WebElement txtbx_Address(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement txtbx_StateProvinceRegion(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement txtbx_PostalCode(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}

	public static WebElement chckbx_IAgree(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}

	public static WebElement btn_Register(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));
		return element;
	}

}