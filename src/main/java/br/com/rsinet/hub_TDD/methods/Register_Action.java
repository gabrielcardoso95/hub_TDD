package br.com.rsinet.hub_TDD.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.pageobjects.HomePage;
import br.com.rsinet.hub_TDD.pageobjects.LogInPage;
import br.com.rsinet.hub_TDD.pageobjects.RegisterPage;
import br.com.rsinet.hub_TDD.pageobjects.SearchPage;
import br.com.rsinet.hub_TDD.utility.Constant;
import br.com.rsinet.hub_TDD.utility.ExcelUtils;

public class Register_Action {
	public static void registraUsuario(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		
		HomePage.lnk_MenuUser(driver).click();
		
		LogInPage.lnk_CreateNewAccount(driver).sendKeys(Keys.ENTER);

		RegisterPage.txtbx_UserName(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		RegisterPage.txtbx_UserEmail(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		RegisterPage.txtbx_Password(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		RegisterPage.txtbx_ConfirmPassword(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		RegisterPage.txtbx_FirstName(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		RegisterPage.txtbx_LastName(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		RegisterPage.txtbx_PhoneNumber(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		Select drpCountry = new Select(RegisterPage.lstbx_Country(driver));
		drpCountry.selectByVisibleText(ExcelUtils.getCellData(1, 7));
		RegisterPage.txtbx_City(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		RegisterPage.txtbx_Address(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		RegisterPage.txtbx_StateProvinceRegion(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		RegisterPage.txtbx_PostalCode(driver).sendKeys(ExcelUtils.getCellData(1, 11));
		RegisterPage.chckbx_IAgree(driver).click();
		RegisterPage.btn_Register(driver).click();		
	}
	
	public static void pesquisaProduto(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
		HomePage.lnk_MenuSearch(driver).click();
		SearchPage.txtbx_Search(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]")));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		SearchPage.lnk_AddToCart(driver).click();
		SearchPage.lnk_menuCart(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shoppingCart\"]/table/tbody/tr/td[1]/img")));
	}
	
	public static void pesquisaProdutoInvalido(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
		HomePage.lnk_MenuSearch(driver).click();
		SearchPage.txtbx_Search(driver).sendKeys(ExcelUtils.getCellData(2, 0) + (Keys.ENTER));
	}
	
	public static void pesquisaProdutoPorTelaInicial(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha3");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", HomePage.lnk_Speakers(driver));
		driver.findElement(By.linkText(ExcelUtils.getCellData(1, 0))).click();
		SearchPage.lnk_AddToCart(driver).click();
		SearchPage.lnk_menuCart(driver).click();
	}
}
