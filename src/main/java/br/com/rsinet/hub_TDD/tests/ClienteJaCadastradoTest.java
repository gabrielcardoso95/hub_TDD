package br.com.rsinet.hub_TDD.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.methods.Register_Action;
import br.com.rsinet.hub_TDD.utility.Screenshot;

public class ClienteJaCadastradoTest {
	private static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}
	
	@Test
	public void usuarioJaCadastrado() throws Exception {
		String nome = "UsuarioJaCadastrado";
		Register_Action.registraUsuario(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]\r\n")), "User name already exists"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,400)");
		assertTrue(driver.getPageSource().contains("User name already exists"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"follow\"]/a[3]/img")));
		Screenshot.PrintScreenshot(driver, nome);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
