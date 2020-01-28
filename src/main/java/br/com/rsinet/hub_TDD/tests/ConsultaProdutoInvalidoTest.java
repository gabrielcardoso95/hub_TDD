package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_TDD.methods.Register_Action;
import br.com.rsinet.hub_TDD.utility.Screenshot;

public class ConsultaProdutoInvalidoTest {
	public static WebDriver driver;
	ExtentReports extensao;
    ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void produtoNaoEncontrado() throws Exception {
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("target/reports/ProdutoNaoEncontrado.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("ProdutoNaoEncontrado");
		String nome = "ProdutoNaoEncontrado";
		Register_Action.pesquisaProdutoInvalido(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div[3]/div")));
		Assert.assertTrue(driver.getPageSource().contains("No results for"));
		Screenshot.PrintScreenshot(driver, nome);
	}

	@AfterMethod
	public void afterMethod() {
		extensao.flush();
		driver.quit();
	}
}
