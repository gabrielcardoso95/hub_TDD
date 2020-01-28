package br.com.rsinet.hub_TDD.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.methods.Register_Action;
import br.com.rsinet.hub_TDD.utility.ExcelUtils;
import br.com.rsinet.hub_TDD.utility.Screenshot;
public class CadastraClienteTest {
	private static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void deveCadastrarUsuario() throws Exception {
		String expectedName = ExcelUtils.getCellData(1, 1);
		Register_Action.registraUsuario(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")), ExcelUtils.getCellData(1, 1)));
		String pageSource = driver.getPageSource();
		assertTrue(pageSource.contains(expectedName));
		Screenshot.PrintScreenshot(driver, "UsuarioCadastradoComSucesso");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
