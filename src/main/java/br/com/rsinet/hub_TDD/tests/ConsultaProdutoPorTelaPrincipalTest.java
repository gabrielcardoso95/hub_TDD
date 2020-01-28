package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.methods.Register_Action;
import br.com.rsinet.hub_TDD.utility.ExcelUtils;
import br.com.rsinet.hub_TDD.utility.Screenshot;

public class ConsultaProdutoPorTelaPrincipalTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}
	
	@Test
	public void pesquisaProduto() throws Exception {
		String nome = "ProdutoAdicionadoComSucesso";
		Register_Action.pesquisaProdutoPorTelaInicial(driver);
		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 0).toUpperCase()));
		Screenshot.PrintScreenshot(driver, nome);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
